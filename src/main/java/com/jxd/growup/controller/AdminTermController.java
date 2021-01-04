package com.jxd.growup.controller;

import com.jxd.growup.service.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdminTermController
 * @Description: TODO
 * @Author nsj
 * @Date 2021/1/4
 **/
@RestController
public class AdminTermController {
    @Autowired
    private ITermService termService;
    @PostMapping("/getAllTerm")
    public Map<String,Object> getAllTerm(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",termService.listMaps());
        map.put("code","200");
        return map;
    }
}
