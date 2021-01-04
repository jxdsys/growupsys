package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IAdmintermDao;
import com.jxd.growup.dao.ISchAppraDao;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Term;
import com.jxd.growup.service.IAdminTermService;
import com.jxd.growup.service.ISchAppraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class AdminTermServiceImpl extends ServiceImpl<IAdmintermDao, Term> implements IAdminTermService {
    @Autowired
    private IAdmintermDao admintermDao;
    @Override
    public Map<String, Object> getAllTerm(int limit,int page,String tname) {
        //构造分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);
        //将分页对象传递到dao层
        Map<String,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String,Object>> result = admintermDao.getAllTerm(pages,tname);
        map.put("terms",result.getRecords());
        map.put("total",result.getTotal());
        map.put("pageCount",result.getPages());
        return map;
    }

    @Override
    public boolean addTerm(String termname) {
        return admintermDao.addTerm(termname);
    }

    @Override
    public String getLastTerm() {
        return admintermDao.getLastTerm();
    }

    @Override
    public boolean updSchAppra(int schAppraId,int termId) {
        return admintermDao.updSchAppra(schAppraId,termId);
    }

    @Override
    public boolean updTermState(int schAppraId) {
        return admintermDao.updTermState(schAppraId);
    }
}
