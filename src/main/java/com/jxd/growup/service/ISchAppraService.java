package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Users;

import java.util.List;
import java.util.Map;

public interface ISchAppraService extends IService<SchoolAppra> {
    /**
     * 获取所有学校评价人信息
     * @return
     */
    Map<String,Object> getAllSch(int limit,int page,String sname);
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
