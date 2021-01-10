package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.growup.model.Users;

public interface IUsersDao extends BaseMapper<Users> {


    /**
     * 获取最后插入元素的id
     * @return
     */
    int selLastId();
}
