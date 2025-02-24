package com.jxd.growup.dao;

import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;

public interface ILoginDao {
    /**
     * 判断登录是否成功
     * @param name 用户名
     * @param password 用户密码
     * @return
     */
    Users getLogin(@Param("name") String name,@Param("password") String password);

}
