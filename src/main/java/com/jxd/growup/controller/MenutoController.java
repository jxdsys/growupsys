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

    @PostMapping("/getMenu")
    public Map<String,Object> getSchMenu(@RequestBody List<String> list){
       int role =Integer.parseInt(list.get(Integer.parseInt("role")));
        Map<String,Object> map = new HashMap<>();
        map.put("data",menutoService.getMenu(role));
        map.put("status","200");
        return map;
    }
}
