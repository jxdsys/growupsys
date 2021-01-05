package com.jxd.growup.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUsersService extends IService<Users> {
    /**
     * 获得users表中的数据
     * @return
     */
    Map<String,Object> getUsers(int limit,int page,String uname);

    /**
     * 重置密码
     * @return
     */
    boolean rePwd(int userid);
}
