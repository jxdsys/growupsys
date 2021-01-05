package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IDeptDao;
import com.jxd.growup.dao.IJobDao;
import com.jxd.growup.model.Dept;
import com.jxd.growup.model.Job;
import com.jxd.growup.service.IJobService;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends ServiceImpl<IJobDao,Job> implements IJobService {
}
