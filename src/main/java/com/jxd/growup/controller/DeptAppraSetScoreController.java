package com.jxd.growup.controller;

import com.jxd.growup.service.IDeptAppraSetScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeptAppraSetScoreController {
    @Autowired
    private IDeptAppraSetScoreService deptAppraSetScoreService;

    //查询总表数据
    @PostMapping("/getAllEmpInfo")
    public Map<String ,Object > getAllEmpInfo(@RequestBody Map<String ,String> queryMap){
        //获取到每一个查询参数
        int limit =Integer.parseInt(queryMap.get("limit"));
        int page =Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("filter")== null ? "" :queryMap.get("filter");
        Map<String ,Object > map= new HashMap<>();
        return map ;
//        deptAppraSetScoreService.selectDeptAppraWithDeptAndJob(limit,page,ename);
    }
}
