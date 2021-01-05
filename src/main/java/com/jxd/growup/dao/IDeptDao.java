package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.Dept;
import com.jxd.growup.model.DeptAppra;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IDeptDao extends BaseMapper<Dept> {
    /**
     * 分页显示部门信息
     * @param page 页码
     * @param ename 部门名称
     * @return 数据
     */
    IPage<Map<String ,Object >> selectDeptList(Page<Map<String ,Object >> page,
                                               @Param("dname") String ename);
}
