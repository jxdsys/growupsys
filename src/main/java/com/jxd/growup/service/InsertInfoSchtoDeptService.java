package com.jxd.growup.service;

import com.jxd.growup.model.DeptEvaluationScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsertInfoSchtoDeptService {
    /**
     * 根据学生id将部门id插入student表中
     * @param stuid
     * @param deptid
     * @return
     */
    boolean updStuSchtoDept(String stuid, String deptid);

    /**
     * 根据学生id将部门评价人id插入dept_evolution_all表中
     * @param stuid
     * @param deptAppraid
     * @return
     */
    boolean insertStuSchtoDept(String stuid,String deptAppraid);

    /**
     * 将部门评价人id,学生id插入dept_evaluation_score表中
     * @param list
     * @return
     */
    boolean addByBatch(List<DeptEvaluationScore> list);

}
