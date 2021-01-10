package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IinsertStuScoreDao;
import com.jxd.growup.dao.SchoolGetStu;
import com.jxd.growup.model.Score;
import com.jxd.growup.model.Student;
import com.jxd.growup.service.ISchoolGetStuService;

public interface IinsertStuScoreService extends IService<Score> {
    /**
     * 将评的成绩放入表中
     * @param score
     * @return
     */
    boolean updmarkedScore(Score score);
}
