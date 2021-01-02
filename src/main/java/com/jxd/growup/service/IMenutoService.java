package com.jxd.growup.service;

import com.jxd.growup.model.Menuto;

import java.util.List;

public interface IMenutoService {
    /**
     *获取菜单栏
     * @return
     */
    List<Menuto> getMenu(int mid);

}
