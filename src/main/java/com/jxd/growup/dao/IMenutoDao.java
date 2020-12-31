package com.jxd.growup.dao;

import com.jxd.growup.model.Menuto;

import java.util.List;

public interface IMenutoDao {
    /**
     *获取学校功能模块的菜单栏
     * @return
     */
    List<Menuto> getSchMenu();

    /**
     *获取管理员功能模块的菜单栏
     * @return
     */
    List<Menuto> getAdminMenu();





}
