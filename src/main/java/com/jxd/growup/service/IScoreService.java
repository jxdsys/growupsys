package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.Score;

import java.util.Map;

public interface IScoreService extends IService<Score> {
    /**
     * 根据学生id获取学生在学校的成绩
     * @param stuid
     * @return
     */
    Map<String,Object> getScoreByStuId(int stuid);
}
