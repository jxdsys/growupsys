package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.growup.model.Score;

import java.util.Map;

public interface IScoreDao extends BaseMapper<Score> {
    /**
     * 根据学生id获取学生在学校的成绩
     * @param stuid
     * @return
     */
    Map<String,Object> getScoreByStuId(int stuid);
}
