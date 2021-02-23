package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IInsertStuScoreDao;

import com.jxd.growup.model.Score;
import com.jxd.growup.service.IInsertStuScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertStuScoreServiceImpl extends ServiceImpl<IInsertStuScoreDao, Score> implements IInsertStuScoreService {
   @Autowired
   private IInsertStuScoreDao iinsertStuScoreDao;
    @Override
    public boolean updmarkedScore(Score score) {
        return iinsertStuScoreDao.updmarkedScore(score);
    }
}
