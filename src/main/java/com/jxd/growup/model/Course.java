package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Course
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("course")
public class Course {
    //课程id
    @TableId(type = IdType.AUTO)
    @TableField("course_id")
    private int courseId;
    //课程名称
    @TableField("course_name")
    private String courseName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /**
     * 默认的无参构造方法
     */
    public Course() {
    }
}
