package com.jxd.growup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.Student;

import java.util.Map;

public interface IStudentService extends IService<Student> {
    /**
     * 根据班期和学员姓名查询简略学员信息
     * @param stuName 查询的学生姓名
     * @param termId 班期id
     * @param limit 每页条数
     * @param page 当前页数
     * @return
     */
    Map<String,Object> selectStudentByPageAndTermId(String stuName,String termId,String limit,String page);

}
