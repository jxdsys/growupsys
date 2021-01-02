package com.jxd.growup.service;

import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface ILoginService {
    /**
     *登录验证
     * @param name 用户名
     * @param password 密码
     * @return
     */
    Users getLogin(String name, String password);
}
