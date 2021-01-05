package com.jxd.growup.controller;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.growup.model.Users;
import com.jxd.growup.service.ILoginService;
import com.jxd.growup.service.IUsersService;
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
    @Autowired
    private IUsersService usersService;
    @PostMapping("/login")
    public Map<String,Object> getLogin(@RequestBody Map<String,String> map){
        String name = map.get("name") == null ? "" : map.get("name");
        String password = map.get("password") == null ? "" : map.get("password");
        Map<String,Object> mapLogin = new HashMap<>();
        if (loginService.getLogin(name,password) != null){
            mapLogin.put("data",loginService.getLogin(name,password));
            mapLogin.put("status","200");
            return mapLogin;
        }else {
            mapLogin.put("data","");
            mapLogin.put("status","500");
            return mapLogin;
        }
    }
    @PostMapping("getPwdByUserName")
    public Map<String,Object> getPwdByUserName(@RequestBody String userName){
        AbstractWrapper wrapper = new QueryWrapper();
        String[] usernames = userName.split("=");
        String username = "";
        for (int i = 0; i < usernames.length; i++) {
            username = usernames[i]+username;
        }
        wrapper.eq("username",username);
        String password = usersService.getOne(wrapper).getPassword();
        String userid = usersService.getOne(wrapper).getUserid() + "";
        Map<String,Object> map = new HashMap<>();
        map.put("password",password);
        map.put("userid",userid);
        return map;
    }
    @PostMapping("/updPwd")
    public String updPwd(@RequestBody Map<String,Object> map ){
        String username = map.get("userName").toString();
        String password = map.get("pass").toString();
        int userid = Integer.parseInt(map.get("userid").toString());
        Users users = new Users(userid,username,password);
        if (usersService.updateById(users)){
            return "success";
        }else {
            return  "fail";
        }

    }
}
