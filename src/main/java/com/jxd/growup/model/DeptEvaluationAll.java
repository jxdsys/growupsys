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
    private  int score0;
    //部门总评评价
    private String estimatedfirst;
    //部门总评分数
    private  int score1;
    //部门总评评价
    private String estimatedtwo;
    //部门总评分数
    private  int score2;
    //部门总评评价
    private String estimatedone;
    //部门总评分数
    private  int score3;
    //部门总评评价
    private String estimatedthird;

    public int getScore0() {
        return score0;
    }

    public void setScore0(int score0) {
        this.score0 = score0;
    }



    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }



    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }



    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public String getEstimatedfirst() {
        return estimatedfirst;
    }

    public void setEstimatedfirst(String estimatedfirst) {
        this.estimatedfirst = estimatedfirst;
    }

    public String getEstimatedtwo() {
        return estimatedtwo;
    }

    public void setEstimatedtwo(String estimatedtwo) {
        this.estimatedtwo = estimatedtwo;
    }

    public String getEstimatedone() {
        return estimatedone;
    }

    public void setEstimatedone(String estimatedone) {
        this.estimatedone = estimatedone;
    }

    public String getEstimatedthird() {
        return estimatedthird;
    }

    public void setEstimatedthird(String estimatedthird) {
        this.estimatedthird = estimatedthird;
    }

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


    /**
     * 默认的无参构造方法
     */
    public DeptEvaluationAll() {
    }
}
