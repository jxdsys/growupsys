package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName User
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("users")
public class Users {
    //用户id
    @TableId(type = IdType.AUTO)
    private int userid;
    //用户名
    private String username;
    //用户密码
    private String password;
    //用户权限
    private int role;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    /**
     * 无参构造方法
     */
    public Users() {
    }

    /**
     * 登陆判断时的调用的构造方法
     * @param name
     * @param password
     */
    public Users(String name, String password) {
        this.username = name;
        this.password = password;
    }

    /**
     * 新增员工时调用的构造方法
     * @param name
     * @param role
     */
    public Users(String name, int role) {
        this.username = name;
        this.role = role;
    }

}
