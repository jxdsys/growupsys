package com.jxd.growup.service.impl;

import com.jxd.growup.dao.IGetTermidDistrStuDao;
import com.jxd.growup.service.IGetTermidDistrStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetTermidDistrStuServiceImpl implements IGetTermidDistrStuService {
    @Autowired
    private IGetTermidDistrStuDao getTermidDistrStuDao;
    @Override
    public String getTermidDistrStu(String userName) {
        return getTermidDistrStuDao.getTermidDistrStu(userName);
    }
}
