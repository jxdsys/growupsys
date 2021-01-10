package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IinsertStuScoreDao;
import com.jxd.growup.dao.SchoolGetStu;
import com.jxd.growup.model.Score;
import com.jxd.growup.model.Student;
import com.jxd.growup.service.ISchoolGetStuService;
import com.jxd.growup.service.IinsertStuScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertStuScoreServiceImpl extends ServiceImpl<IinsertStuScoreDao, Score> implements IinsertStuScoreService {
   @Autowired
   private IinsertStuScoreDao iinsertStuScoreDao;
    @Override
    public boolean updmarkedScore(Score score) {
        return iinsertStuScoreDao.updmarkedScore(score);
    }
}
