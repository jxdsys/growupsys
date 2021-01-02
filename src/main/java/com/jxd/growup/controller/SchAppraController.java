package com.jxd.growup.controller;

import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.service.ISchAppraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SchAppraController {
    @Autowired
    private ISchAppraService schAppraService;

    @PostMapping("/getEmps")
    public Map<String,Object> getSchAppra(@RequestBody Map<String,String> queryMap){
        //获取每个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String sname = queryMap.get("filter")== null ? "" : queryMap.get("filter");
        return schAppraService.getAllSch(limit,page,sname);
    }

    @PostMapping("/addSch")
    public String addEmp(@RequestBody SchoolAppra schoolAppra){
        if (schAppraService.saveOrUpdate(schoolAppra)){
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/getSchById/{sch_appra_id}")
    public SchoolAppra getEmpById(@PathVariable int sch_appra_id){
        SchoolAppra schoolAppra = schAppraService.getById(sch_appra_id);
        return schoolAppra;
    }
    @PostMapping("/delBatchSch")
    public String delBatchEmp(@RequestBody List<Integer> empnos){
        if (schAppraService.removeByIds(empnos)){
            return "success";
        }else {
            return "fail";
        }
    }

    @GetMapping("/delSch/{sch_appra_id}")
    public String delSch(@PathVariable int sch_appra_id){
        if (schAppraService.removeById(sch_appra_id)){
            return "success";
        }else {
            return "fail";
        }
    }
}
