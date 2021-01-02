package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.ISchAppraDao;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.service.ISchAppraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SchAppraServiceImpl extends ServiceImpl<ISchAppraDao, SchoolAppra> implements ISchAppraService {
    @Autowired
    private ISchAppraDao schAppraDao;
    @Override
    public Map<String, Object> getAllSch(int limit,int page,String sname) {
        //构造分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);
        //将分页对象传递到dao层
        Map<String,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String,Object>> result = schAppraDao.getAllSch(pages,sname);
        map.put("schAppra",result.getRecords());
        map.put("total",result.getTotal());
        map.put("pageCount",result.getPages());
        return map;
    }
}
