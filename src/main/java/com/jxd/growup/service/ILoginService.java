package com.jxd.growup.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface ILoginService {
    /**
     *
     * @param name
     * @param password
     * @return
     */
    String getLogin(@Param("name") String name, @Param("password") String password);
}
