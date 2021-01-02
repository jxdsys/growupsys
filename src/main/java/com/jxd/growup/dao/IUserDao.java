package com.jxd.growup.dao;

import com.jxd.growup.model.Users;

import java.util.List;

public interface IUserDao {
    /**
     * 获得用户表
     * @return
     */
    List<Users> getUsers();
}
