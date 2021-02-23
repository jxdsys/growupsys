package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IStudentDao extends BaseMapper<Student> {
    /**
     * 根据班期和学员姓名查询简略学员信息
     * @param stuName 查询的学生姓名
     * @param termId 班期id
     * @return
     */
   IPage<Map<String,Object>> selectStudentByPageAndTermId(Page<Map<String,Object>> page,@Param("stuname") String stuName,@Param("termid") String termId);

    /**
     * 显示所有学生信息
     * @param page
     * @return
     */
   IPage<Map<String,Object>> selectStudentByPage(Page<Map<String,Object>> page,@Param("stuName")String stuName);

}
