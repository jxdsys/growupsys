package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.DeptAppra;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDeptAppraDao extends BaseMapper<DeptAppra> {
    /**
     * 分页显示部门评价人信息
     * @param page 页码
     * @param ename 条数
     * @return 数据
     */
    IPage<Map<String ,Object >> selectDeptAppraWithDeptAndJob(Page<Map<String ,Object >> page,
                                                              @Param("deptAppraName") String ename);
}
