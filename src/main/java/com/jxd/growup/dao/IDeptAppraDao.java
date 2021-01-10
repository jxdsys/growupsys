package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.DeptAppra;
import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDeptAppraDao extends BaseMapper<DeptAppra> {
    /**
     * 分页显示部门评价人信息
     * @param page 页码
     * @param ename 查询姓名
     * @return 数据
     */
    IPage<Map<String ,Object >> selectDeptAppraWithDeptAndJob(Page<Map<String ,Object >> page,
                                                              @Param("deptAppraName") String ename);

    /**
     * 新增时查询新增的id
     * @return
     */
    int getMaxId();

    /**
     *  批量删除user表中内容
     * @param users
     * @return 是否成功
     */
    boolean deUsersWithDeptAppra(List<Users> users);
}
