package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.Dept;
import com.jxd.growup.model.DeptAppra;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IDeptService extends IService<Dept> {
    /**
     * 分页查询部门信息
     * @param limit  条数
     * @param page 页码
     * @param ename 姓名
     * @return 信息
     */
    Map<String ,Object > selectDeptList(int limit, int page, String ename);
    /**
     * 删除部门
     * @param deptid  部门id
     * @return 删除的状态
     */
    boolean delDeptById(@Param("deptid") int deptid );
}
