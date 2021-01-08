package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.Dept;
import com.jxd.growup.model.DeptEvaluationAll;
import com.jxd.growup.model.DeptEvaluationScore;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IDeptEvaluationAllService extends IService<DeptEvaluationAll> {
    /**
     * 分页查询未评分学员信息
     * @param limit  条数
     * @param page 页码
     * @param ename 姓名
     * @return 评价人信息
     */
    Map<String ,Object > selectEmpList(int limit, int page, String ename,int username);

    /**
     * 查询登录者属于哪一个部门
     * @param username 用户名
     * @return 用户所属部门
     */
    String getOneDept(String username);
    /**
     * 分页以评分学员信息
     * @param limit  条数
     * @param page 页码
     * @param ename 姓名
     * @return 信息
     */
    Map<String ,Object > selectAllEmpList(int limit, int page, String ename,int username);

    /**
     * 查员工部门以及其他信息
     * @param stuid
     * @return
     */
    Map<String ,String>  getEmpDeptInfoById(String stuid);
    /**
     * 保存转正成绩
     * @param deptEvaluationScore 实体类
     * @return 是否成功
     */
    boolean updateScore(DeptEvaluationScore deptEvaluationScore);

    /**
     * 保存转正评价
     * @param deptEvaluationAll 实体类
     * @return 是否成功
     */
    boolean updateAllScoreFirst(DeptEvaluationAll deptEvaluationAll);
    /**
     * 保存一年评价
     * @param deptEvaluationAll 实体类
     * @return 是否成功
     */
    boolean updateAllScoreOneYear(DeptEvaluationAll deptEvaluationAll);

    /**
     * 保存三年评价
     * @param deptEvaluationAll 实体类
     * @return 是否成功
     */
    boolean updateAllScoreTwoYear(DeptEvaluationAll deptEvaluationAll);
    /**
     * 保存三年评价
     * @param deptEvaluationAll 实体类
     * @return 是否成功
     */
    boolean updateAllScoreThridYear(DeptEvaluationAll deptEvaluationAll);
    /**
     * 查询分数
     * @param stuid 学生id
     * @param timeida 年限
     * @return 成绩数据
     */
    Map<String ,Object> selectEmpScore(@Param("stuid") int stuid, @Param("dateid") int timeida);

}
