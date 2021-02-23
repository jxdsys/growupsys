package com.jxd.growup.controller;

import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Users;
import com.jxd.growup.service.ISchAppraService;
import com.jxd.growup.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SchAppraController {
    @Autowired
    private ISchAppraService schAppraService;
    @Autowired
    private IUsersService usersService;

    /**
     * （分页，模糊查询）获取所有学校评价人
     *
     * @param queryMap
     * @return
     */
    @PostMapping("/getEmps")
    public Map<String, Object> getSchAppra(@RequestBody Map<String, String> queryMap) {
        //获取每个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String sname = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        return schAppraService.getAllSch(limit, page, sname);
    }

    /**
     * 新增或修改学校评价人
     *
     * @param schoolAppra 学校评价人对象
     * @return
     */
    @PostMapping("/addSch")
    public String addEmp(@RequestBody SchoolAppra schoolAppra) {
        //新增时需要插入users表，新增没有老师id所以走此方法
        if ((schoolAppra.getSchAppraId()) == 0) {
            schAppraService.saveOrUpdate(schoolAppra);
            String schappraid = schAppraService.getIdWhenInsertSchAppra();
            schAppraService.insertToUsers(schappraid);
            return schappraid;
        } else if ((schoolAppra.getSchAppraId()) != 0){
            //修改时不需要插入users表，有老师id走此方法
            schAppraService.saveOrUpdate(schoolAppra);
            return "success";
        }else {
            return "";
        }
    }

    /**
     * 根据学校评价人的id获取该条数据
     *
     * @param sch_appra_id 学校评价人id
     * @return
     */
    @GetMapping("/getSchById/{sch_appra_id}")
    public SchoolAppra getEmpById(@PathVariable int sch_appra_id) {
        SchoolAppra schoolAppra = schAppraService.getById(sch_appra_id);
        return schoolAppra;
    }

    /**
     * 批量删除学校评价人
     *
     * @param empnos 所有学校评价人id
     * @return
     */
    @PostMapping("/delBatchSch")
    public String delBatchEmp(@RequestBody List<Integer> empnos) {
        if (schAppraService.removeByIds(empnos)) {
            List<Users> list = new ArrayList<>();
            for (int i = 0; i < empnos.size(); i++) {
                Users users = new Users();
                users.setUsername(empnos.get(i) + "");
                list.add(users);
            }
            schAppraService.delBatchUsers(list);
            return "success";
        } else {
            return "fail";
        }
    }


    /**
     * 删除一个学校评价人
     *
     * @param sch_appra_id 学校评价人id
     * @return
     */
    @GetMapping("/delSch/{sch_appra_id}")
    public String delSch(@PathVariable int sch_appra_id) {
        if (schAppraService.removeById(sch_appra_id)) {
            String schappraid = sch_appra_id + "";
            schAppraService.delUsers(schappraid);
            return "success";
        } else {
            return "fail";
        }
    }
}
