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

    /**
     * 登录判断
     * @param map 获取用户登录时输入的用户名和密码
     * @return 登录是否成功和用户权限集合
     */
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

    /**
     * 根据用户名获取用户id和用户密码
     * @param userName 用户名
     * @return 用户id和用户密码集合
     */
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

    /**
     * 根据用户名修改密码
     * @param map 用户信息集合
     * @return 修改是否成功
     */
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
