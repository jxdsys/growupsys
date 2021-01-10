package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ISchAppraDao extends BaseMapper<SchoolAppra> {
    /**
     * 获取所有学校评价人信息
     * @return
     */
    IPage<Map<String,Object>> getAllSch(Page<Map<String,Object>> pages, @Param("sname") String sname);

    /**
     * 新增学校评价人时，获取id
     * @return
     */
    String getIdWhenInsertSchAppra();

    /**
     * 新增学校评价人时向users表新增
     * @param schappraid
     * @return
     */
    boolean insertToUsers(String schappraid);

    /**
     * 删除users表中的用户
     * @param appraid
     * @return
     */
    boolean delUsers(String appraid);

    /**
     * 批量删除users表中的用户
     * @param list
     * @return
     */
    boolean delBatchUsers(List<Users> list);
}
