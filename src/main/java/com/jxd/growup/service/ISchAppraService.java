package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.SchoolAppra;

import java.util.List;
import java.util.Map;

public interface ISchAppraService extends IService<SchoolAppra> {
    /**
     * 获取所有学校评价人信息
     * @return
     */
    Map<String,Object> getAllSch(int limit,int page,String sname);
}
