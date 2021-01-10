package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IDeptAppraDao;
import com.jxd.growup.model.DeptAppra;
import com.jxd.growup.model.Users;
import com.jxd.growup.service.IDeptAppraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptAppraServiceImpl extends ServiceImpl<IDeptAppraDao, DeptAppra> implements IDeptAppraService {

    @Autowired
    private IDeptAppraDao deptAppraDao;

    /**
     * 分页查询部门评价人信息
     * @param limit  条数
     * @param page 页码
     * @param ename 姓名
     * @return  评价人信息
     */
    @Override
    public Map<String, Object> selectDeptAppraWithDeptAndJob(int limit, int page, String ename) {

        //构造分页对象
        Page<Map<String, Object>> pages = new Page<>(page,limit);
        //将分页对象传到dao层
        Map<String ,Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String, Object>> res = deptAppraDao.selectDeptAppraWithDeptAndJob(pages,ename);
        map.put("deptAppras",res.getRecords());
        map.put("total",res.getTotal());
        map.put("pageCount",res.getPages());
        return map;
    }

    @Override
    public int getMaxId() {
        return deptAppraDao.getMaxId();
    }

    @Override
    public boolean deUsersWithDeptAppra(List<Users> users) {
        return deptAppraDao.deUsersWithDeptAppra(users);
    }
}
