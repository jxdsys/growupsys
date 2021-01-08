package com.jxd.growup.service.impl;

import com.jxd.growup.dao.InsertInfoSchtoDeptDao;
import com.jxd.growup.model.DeptEvaluationScore;
import com.jxd.growup.service.InsertInfoSchtoDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertInfoSchtoDeptServiceImpl implements InsertInfoSchtoDeptService {
    @Autowired
    private InsertInfoSchtoDeptDao insertInfoSchtoDeptDao;
    @Override
    public boolean updStuSchtoDept(String stuid, String deptid) {
        return insertInfoSchtoDeptDao.updStuSchtoDept(stuid, deptid);
    }

    @Override
    public boolean insertStuSchtoDept(String stuid, String deptAppraid) {
        return insertInfoSchtoDeptDao.insertStuSchtoDept(stuid,deptAppraid);
    }

    @Override
    public boolean addByBatch(List<DeptEvaluationScore> list) {
        return insertInfoSchtoDeptDao.addByBatch(list);
    }
}
