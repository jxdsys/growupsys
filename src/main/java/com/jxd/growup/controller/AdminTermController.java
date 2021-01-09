package com.jxd.growup.controller;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Term;
import com.jxd.growup.service.IAdminTermService;
import com.jxd.growup.service.ISchAppraService;
import com.jxd.growup.service.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminTermController {
    @Autowired
    private IAdminTermService adminTermService;
    @Autowired
    private ISchAppraService schAppraService;
    @Autowired
    private ITermService termService;

    /**
     * 获取所有班期信息
     * @return 班期信息集合
     */
    @PostMapping("/getAllTerm")
    public Map<String,Object> getAllTerm(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",termService.listMaps());
        map.put("code","200");
        return map;
    }

    /**
     * 获取未结课且已分配老师的班期
     * @return
     */
    @PostMapping("/getBusyTerm")
    public Map<String,Object> getBusyTerm(){
        String flag = "未结课";
        Map<String,Object> map = new HashMap<>();
        if (adminTermService.getBusyTerm(flag).size()>0){
            map.put("data",adminTermService.getBusyTerm(flag));
            map.put("count","200");
        }else {
            map.put("count","500");
        }
        return map;
    }

    @PostMapping("/getTerm")
    public Map<String, Object> getTerm(@RequestBody Map<String, String> queryMap) {
        //获取每个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String tname = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        return adminTermService.getAllTerm(limit, page, tname);
    }

    /**
     * 新增员工
     * @return
     */
    @PostMapping("/addTerm")
    public String addTerm() {
        String termnames = (Integer.parseInt(adminTermService.getLastTerm()) + 1) + "";
        String front = "0";
        String termname = front.concat(termnames);
        //System.out.println(termname);
        if (adminTermService.addTerm(termname)) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 得到选中该条的数据
     *
     * @param term_id
     * @return
     */
    @GetMapping("/getThisTerm/{term_id}")
    public Term getThisTerm(@PathVariable int term_id) {
        Term term = adminTermService.getById(term_id);
        return term;
    }

    /**
     * 获得空闲的老师下拉框
     *
     * @return
     */
    @GetMapping("/getTeachers")
    public List<SchoolAppra> getTeachers() {
        AbstractWrapper wrapper = new QueryWrapper();
        String name = "空闲";
        wrapper.eq("state", name);
        return schAppraService.list(wrapper);
    }

    /**
     * 修改老师状态,分配老师
     *
     * @param
     * @return
     */
    @GetMapping("/addAppra/{schAppraId}/{termId}")
    public String addAppra(@PathVariable int schAppraId,@PathVariable int termId) {
        //System.out.println(termId);
        boolean flag = adminTermService.updSchAppra(schAppraId,termId);
        boolean isState = adminTermService.updTermState(schAppraId);
        if (flag && isState) {
            return "success";
        } else {
            return "fail";
        }

    }


}
