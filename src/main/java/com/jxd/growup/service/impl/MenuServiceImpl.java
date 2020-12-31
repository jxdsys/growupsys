package com.jxd.growup.service.impl;


import com.jxd.growup.dao.IMenutoDao;
import com.jxd.growup.model.Menuto;
import com.jxd.growup.service.IMenutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenutoService {
    @Autowired
    private IMenutoDao menutoDao;
    @Override
    public  List<Menuto> getSchMenu() {
        return menutoDao.getSchMenu();
    }

}
