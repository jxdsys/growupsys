package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IRepwdDao;
import com.jxd.growup.dao.IUsersDao;
import com.jxd.growup.model.Users;
import com.jxd.growup.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsersServiceImpl extends ServiceImpl<IUsersDao, Users> implements IUsersService  {
    @Autowired
    IRepwdDao repwdDao;

    @Override
    public Map<String, Object> getUsers(int limit,int page,String uname) {
        //构造分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);
        //将分页对象传递到dao层
        Map<String,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String,Object>> result = repwdDao.getUsers(pages,uname);
        map.put("users",result.getRecords());
        map.put("total",result.getTotal());
        map.put("pageCount",result.getPages());
        return map;
    }

    @Override
    public boolean rePwd(int userid) {
        return repwdDao.rePwd(userid);
    }
}
