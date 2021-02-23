package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.Dept;
import com.jxd.growup.model.DeptEvaluationAll;
import com.jxd.growup.model.DeptEvaluationScore;
import com.jxd.growup.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IDeptEvaluationAllDao extends BaseMapper<DeptEvaluationAll> {
    /**
     * 分页显示员工信息
     * @param page 页码
     * @param ename 员工名称
     * @return 数据
     */
    IPage<Map<String ,Object >> selectEmpList(Page<Map<String ,Object >> page,
                                              @Param("stuname") String ename,
                                              @Param("deptAppraid") int username);

    /**
     * 查询登录者属于哪一个部门
     * @param username 用户名
     * @return 用户所属部门
     */
    String getOneDept(@Param("deptAppraid") String username);
    /**
     * 分页显示员工信息
     * @param page 页码
     * @param ename 员工名称
     * @return 数据
     */
    IPage<Map<String ,Object >> selectAllEmpList(Page<Map<String ,Object >> page,
                                              @Param("stuname") String ename,
                                              @Param("deptAppraid") int username);

    /**
     * 查员工部门以及其他信息
     * @param stuid
     * @return
     */
    Map<String ,String> getEmpDeptInfoById(String stuid,String userName);

    /**
     * 保存成绩
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
     * @param timeid 年限
     * @return 成绩数据
     */
    Map<String ,Object> selectEmpScore(@Param("stuid") int stuid,@Param("dateid") int timeid );
}
