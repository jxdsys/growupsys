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
@TableName("user")
public class Users {
    //用户id
    @TableId(type = IdType.AUTO)
    private int userId;
    //用户名
    private String name;
    //用户密码
    private String password;
    //用户权限
    private int role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.name = name;
        this.password = password;
    }

    /**
     * 新增员工时调用的构造方法
     * @param name
     * @param role
     */
    public Users(String name, int role) {
        this.name = name;
        this.role = role;
    }
}
