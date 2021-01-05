package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IRepwdDao {
    /**
     * 获得users表中的数据
     * @return
     */
    IPage<Map<String,Object>> getUsers(Page<Map<String, Object>> pages, @Param("uname") String uname);

    /**
     * 重置密码
     * @return
     */
    boolean rePwd(int userid);
}
