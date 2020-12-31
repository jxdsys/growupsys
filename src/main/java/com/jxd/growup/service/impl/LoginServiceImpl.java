package com.jxd.growup.service.impl;

import com.jxd.growup.dao.ILoginDao;
import com.jxd.growup.model.Users;
import com.jxd.growup.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private ILoginDao loginDao;
    @Override
    public Users getLogin(String name, String password) {
        return loginDao.getLogin(name, password);
    }
}
