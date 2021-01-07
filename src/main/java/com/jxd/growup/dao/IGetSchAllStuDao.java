package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.Score;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IGetSchAllStuDao {
    /**
     * 获取某期所有学校评价人模块学生信息
     * @return
     */
    IPage<Map<String,Object>> getSchAllStu(Page<Map<String,Object>> pages, @Param("stuname") String stuname,@Param("termid") int termId);

    /**
     * 所有学校评价人模块学生信息
     * @param pages
     * @param stuname
     * @return
     */
    IPage<Map<String,Object>> getFirstSchAllStu(Page<Map<String,Object>> pages, @Param("stuname") String stuname);

    /**
     * 得到某一期学生总数
     * @param termid
     * @return
     */
    int getStuCount(int termid);

    /**
     * 得到成绩表中，总成绩不为空的某一期的学生人数
     * @param termid
     * @return
     */
    int getFromTermStudentCount(int termid);

    /**
     * 修改老师(评价人)状态
     * @return
     */
    boolean updTeacherState(String userName);

    /**
     * 修改班期状态
     * @return
     */
    boolean updTermState(int termid);

    /**
     * 给某个学生评分时所获取的该条数据
     * @param stuid
     * @return
     */
    Map<String,Object> getOneTomark(String stuid);

    /**
     * 获取某期所有学校评价人模块学生信息(分配部门)
     * @return
     */
    IPage<Map<String,Object>> getSchAllStuDistri(Page<Map<String,Object>> pages, @Param("stuname") String stuname,@Param("termid") int termId);


}
