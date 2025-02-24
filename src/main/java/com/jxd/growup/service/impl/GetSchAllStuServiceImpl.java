package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.dao.IGetSchAllStuDao;
import com.jxd.growup.dao.ISchAppraDao;
import com.jxd.growup.model.Score;
import com.jxd.growup.service.IGetSchAllStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class GetSchAllStuServiceImpl implements IGetSchAllStuService {
    @Autowired
    private IGetSchAllStuDao getSchAllStuDao;
    @Override
    public Map<String, Object> getSchAllStu(int limit,int page,String stuname,int termId) {
        //构造分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);
        //将分页对象传递到dao层
        Map<String,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String,Object>> result = getSchAllStuDao.getSchAllStu(pages,stuname,termId);
        map.put("schStuAppra",result.getRecords());
        map.put("total",result.getTotal());
        map.put("pageCount",result.getPages());
        return map;
    }

    @Override
    public Map<String, Object> getFirstSchAllStu(int limit, int page, String stuname) {
        //构造分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);
        //将分页对象传递到dao层
        Map<String,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String,Object>> result = getSchAllStuDao.getFirstSchAllStu(pages,stuname);
        map.put("schStuAppra",result.getRecords());
        map.put("total",result.getTotal());
        map.put("pageCount",result.getPages());
        return map;
    }

    @Override
    public int getStuCount(int termid) {
        return getSchAllStuDao.getStuCount(termid);
    }

    @Override
    public int getFromTermStudentCount(int termid) {
        return getSchAllStuDao.getFromTermStudentCount(termid);
    }

    @Override
    public boolean updTeacherState(String userName) {
        return getSchAllStuDao.updTeacherState(userName);
    }

    @Override
    public boolean updTermState(int termid) {
        return getSchAllStuDao.updTermState(termid);
    }

    @Override
    public Map<String, Object> getOneTomark(String stuid) {
        return getSchAllStuDao.getOneTomark(stuid);
    }

    @Override
    public Map<String, Object> getSchAllStuDistri(int limit,int page,String stuname,String termId) {
        //构造分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);
        //将分页对象传递到dao层
        Map<String,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String,Object>> result = getSchAllStuDao.getSchAllStuDistri(pages,stuname,termId);
        map.put("schStuAppraDistri",result.getRecords());
        map.put("total",result.getTotal());
        map.put("pageCount",result.getPages());
        return map;
    }


}
