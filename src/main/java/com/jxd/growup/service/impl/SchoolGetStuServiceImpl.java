package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IRepwdDao;
import com.jxd.growup.dao.SchoolGetStu;
import com.jxd.growup.model.Student;
import com.jxd.growup.model.Users;
import com.jxd.growup.service.ISchoolGetStuService;
import com.jxd.growup.service.IUsersService;
import org.springframework.stereotype.Service;

@Service
public class SchoolGetStuServiceImpl extends ServiceImpl<SchoolGetStu, Student> implements ISchoolGetStuService {
}
