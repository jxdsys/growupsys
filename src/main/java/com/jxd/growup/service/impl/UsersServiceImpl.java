package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IUsersDao;
import com.jxd.growup.model.Users;
import com.jxd.growup.service.IUsersService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UsersServiceImpl
 * @Description: TODO
 * @Author nsj
 * @Date 2021/1/4
 **/
@Service
public class UsersServiceImpl extends ServiceImpl<IUsersDao, Users> implements IUsersService {
}
