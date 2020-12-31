package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName DeptEvaluation
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("dept_evaluation_score")
public class DeptEvaluationScore {
    //部门评价id
    @TableId(type = IdType.AUTO)
    @TableField("dept_scoreid")
    private int deptScoreId;
    //学生id
    private int stuId;
    //第几年评价的标志位
    private int dateId;
    //能力分数
    private int ability;
    //积极性分数
    private int activity;
    //沟通交流分数
    private int communcaton;
    //人品分数
    @TableField("moral_quality")
    private int moralQuality;
    //性格分数
    private int disposition;

    public int getDeptScoreId() {
        return deptScoreId;
    }

    public void setDeptScoreId(int deptScoreId) {
        this.deptScoreId = deptScoreId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getCommuncaton() {
        return communcaton;
    }

    public void setCommuncaton(int communcaton) {
        this.communcaton = communcaton;
    }

    public int getMoralQuality() {
        return moralQuality;
    }

    public void setMoralQuality(int moralQuality) {
        this.moralQuality = moralQuality;
    }

    public int getDisposition() {
        return disposition;
    }

    public void setDisposition(int disposition) {
        this.disposition = disposition;
    }

    /**
     * 默认的无参构造方法
     */
    public DeptEvaluationScore() {
    }
}
