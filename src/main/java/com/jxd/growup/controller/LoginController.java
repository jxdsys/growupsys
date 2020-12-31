package com.jxd.growup.controller;

import com.jxd.growup.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@RestController
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @PostMapping("/login")
    public Map<String,Object> getLogin(@RequestBody Map<String,String> map){
        String name = map.get("name") == null ? "" : map.get("name");
        String password = map.get("password") == null ? "" : map.get("password");
        Map<String,Object> mapLogin = new HashMap<>();
        if (loginService.getLogin(name,password) != null){
            mapLogin.put("data",loginService.getLogin(name,password));
            mapLogin.put("states","200");
            return mapLogin;
        }else {
            mapLogin.put("data","");
            mapLogin.put("states","500");
            return mapLogin;
        }


    }

}
