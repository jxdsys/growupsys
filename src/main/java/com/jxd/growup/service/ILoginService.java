package com.jxd.growup.service;

import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface ILoginService {
    /**
     *
     * @param name
     * @param password
     * @return
     */
    Users getLogin(String name, String password);
}
