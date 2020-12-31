package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName DeptEvaluationAll
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("dept_evaluation_all")
public class DeptEvaluationAll {
    //部门总评id
    @TableId(type = IdType.AUTO)
    @TableField("dept_appraid")
    private int deptAppraid;
    //学生id
    private int stuid;
    //第几次评价标志位
    private int dateid;
    //部门id
    private int deptid;
    //职业
    private String job;
    //部门评价人id
    private  int appraiserid;
    //部门总评分数
    private  int score;
    //部门总评评价
    private String estimated;

    public int getDeptAppraid() {
        return deptAppraid;
    }

    public void setDeptAppraid(int deptAppraid) {
        this.deptAppraid = deptAppraid;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getDateid() {
        return dateid;
    }

    public void setDateid(int dateid) {
        this.dateid = dateid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAppraiserid() {
        return appraiserid;
    }

    public void setAppraiserid(int appraiserid) {
        this.appraiserid = appraiserid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }
    /**
     * 默认的无参构造方法
     */
    public DeptEvaluationAll() {
    }
}
