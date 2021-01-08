package com.jxd.growup.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IDeptEvaluationScoreDao {
    /**
     * 根据学生id获取转正评价的成绩
     * @param stuid 学生id
     * @return
     */
    Map<String,Object> getDeptEvaluationByThreeMScoreByStuid(@Param("stuid") int stuid);
    /**
     * 根据学生id获取转正评价的成绩
     * @param stuid 学生id
     * @return
     */
    Map<String,Object> getDeptEvaluationByOneScoreByStuid(@Param("stuid") int stuid);
    /**
     * 根据学生id获取转正评价的成绩
     * @param stuid 学生id
     * @return
     */
    Map<String,Object> getDeptEvaluationByTwoScoreByStuid(@Param("stuid") int stuid);
    /**
     * 根据学生id获取转正评价的成绩
     * @param stuid 学生id
     * @return
     */
    Map<String,Object> getDeptEvaluationByThreeScoreByStuid(@Param("stuid") int stuid);
}
