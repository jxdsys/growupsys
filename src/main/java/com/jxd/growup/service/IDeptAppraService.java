package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.DeptAppra;
import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDeptAppraService extends IService<DeptAppra> {
    /**
     * 分页查询部门评价人信息
     * @param limit  条数
     * @param page 页码
     * @param ename 姓名
     * @return 评价人信息
     */
    Map<String ,Object > selectDeptAppraWithDeptAndJob(int limit, int page, String ename);
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
