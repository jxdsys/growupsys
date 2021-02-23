package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.Score;


public interface IInsertStuScoreService extends IService<Score> {
    /**
     * 将评的成绩放入表中
     * @param score
     * @return
     */
    boolean updmarkedScore(Score score);
}
