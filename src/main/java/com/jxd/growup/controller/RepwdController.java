package com.jxd.growup.controller;


import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RepwdController {
    @Autowired
    private IUsersService usersService;
    @PostMapping("/getUsers")
    public Map<String,Object> getUsers(@RequestBody Map<String,String> queryMap){
        //获取每个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String uname = queryMap.get("filter")== null ? "" : queryMap.get("filter");
        return usersService.getUsers(limit,page,uname);
    }

    @GetMapping("/repwd/{userid}")
    public String repwd(@PathVariable int userid){
        if (usersService.rePwd(userid)){
            return "success";
        }else {
            return "fail";
        }
    }
}
