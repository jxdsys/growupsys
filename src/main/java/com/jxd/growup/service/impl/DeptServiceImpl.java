package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IDeptDao;
import com.jxd.growup.model.Dept;
import com.jxd.growup.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeptServiceImpl extends ServiceImpl<IDeptDao, Dept> implements IDeptService  {
    @Autowired
    private IDeptDao deptDao;
    /**
     * 分页查询部门信息
     * @param limit  条数
     * @param page 页码
     * @param ename 姓名
     * @return  部门信息
     */
    @Override
    public Map<String, Object> selectDeptList(int limit, int page, String ename) {
        //构造分页对象
        Page<Map<String, Object>> pages = new Page<>(page,limit);
        //将分页对象传到dao层
        Map<String ,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String, Object>> res = deptDao.selectDeptList(pages,ename);
        map.put("data",res.getRecords());
        map.put("total",res.getTotal());
        map.put("pageCount",res.getPages());
        return map;
    }
}
