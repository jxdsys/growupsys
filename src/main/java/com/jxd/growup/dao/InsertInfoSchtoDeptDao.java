package com.jxd.growup.dao;

import com.jxd.growup.model.DeptEvaluationScore;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface InsertInfoSchtoDeptDao {
    /**
     * 根据学生id将部门id插入student表中
     * @param stuid
     * @param deptid
     * @return
     */
    boolean updStuSchtoDept(@Param("stuid") String stuid, @Param("deptid") String deptid);

    /**
     * 将部门评价人id,学生id插入dept_evaluation_all表中
     * @param stuid
     * @param deptAppraid
     * @return
     */
    boolean insertStuSchtoDept(@Param("stuid") String stuid,@Param("deptAppraid") String deptAppraid);

    /**
     * 将部门评价人id,学生id插入dept_evaluation_score表中
     * @param list
     * @return
     */
    boolean addByBatch(List<DeptEvaluationScore> list);
}
