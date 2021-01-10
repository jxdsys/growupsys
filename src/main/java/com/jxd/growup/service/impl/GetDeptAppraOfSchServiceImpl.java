package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IDeptDao;
import com.jxd.growup.dao.IGetDeptAppraOfSchDao;
import com.jxd.growup.model.Dept;
import com.jxd.growup.model.DeptAppra;
import com.jxd.growup.service.IDeptService;
import com.jxd.growup.service.IGetDeptAppraOfSchService;
import org.springframework.stereotype.Service;

@Service
public class GetDeptAppraOfSchServiceImpl extends ServiceImpl<IGetDeptAppraOfSchDao, DeptAppra> implements IGetDeptAppraOfSchService {
}
