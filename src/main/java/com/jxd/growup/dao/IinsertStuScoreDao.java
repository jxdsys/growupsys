package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.growup.model.Score;
import com.jxd.growup.model.Student;

public interface IinsertStuScoreDao extends BaseMapper<Score> {
    /**
     * 将评的成绩放入表中
     * @param score
     * @return
     */
    boolean updmarkedScore(Score score);
}
