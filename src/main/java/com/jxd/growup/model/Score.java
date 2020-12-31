package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Score
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("score")
public class Score {
    //学生id,主键
    @TableId
    @TableField("stu_id")
    private int stuId;
    //学生课程id,主键
    @TableId
    @TableField("course_id")
    private int courseId;
    //课程成绩
    private String score;
    //学校评价人id
    @TableField("sch_appraid")
    private int schAppraid;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getSchAppraid() {
        return schAppraid;
    }

    public void setSchAppraid(int schAppraid) {
        this.schAppraid = schAppraid;
    }

    /**
     * 默认的无参构造方法
     */
    public Score() {
    }
}
