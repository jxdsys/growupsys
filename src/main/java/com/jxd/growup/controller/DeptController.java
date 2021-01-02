package com.jxd.growup.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.growup.service.IDeptAppraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class DeptController {
    @Autowired
    private IDeptAppraService deptAppraService;

    @PostMapping("/getDeptAppra")
    public Map<String ,Object > getDeptAppras(@RequestBody Map<String ,String> queryMap){
        //获取到每一个查询参数
        int limit =Integer.parseInt(queryMap.get("limit"));
        int page =Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("filter")== null ? "" :queryMap.get("filter");
        return  deptAppraService.selectDeptAppraWithDeptAndJob(limit,page,ename);
    }


}
