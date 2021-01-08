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
    private int stuid;
    //第几年评价的标志位
    private int dateid;
    @TableField("dept_appraid")
    private int deptAppraid;
    //能力分数
    private int ability;
    //积极性分数
    private int activity;
    //沟通交流分数
    private int communication;
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

    public int getStuid() {
        return stuid;
    }

    public int getDeptAppraid() {
        return deptAppraid;
    }

    public void setDeptAppraid(int deptAppraid) {
        this.deptAppraid = deptAppraid;
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

    public int getCommunication() {
        return communication;
    }

    public void setCommunication(int communication) {
        this.communication = communication;
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
