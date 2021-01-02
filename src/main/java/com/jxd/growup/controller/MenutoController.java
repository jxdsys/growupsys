package com.jxd.growup.controller;


import com.jxd.growup.service.IMenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenutoController {
    @Autowired
    private IMenutoService menutoService;

    /**
     * 动态获取菜单
     * @param role
     * @return
     */
    @PostMapping("/getMenu")
    public Map<String,Object> getSchMenu(@RequestBody String role){
        System.out.println(role);
        String[] role1 = role.split("=");
        Map<String,Object> map = new HashMap<>();
        map.put("data",menutoService.getMenu(Integer.parseInt(role1[0])));
        map.put("status","200");
        return map;
    }
}
