package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName SchoolEvaluation
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("school_evaluation")
public class SchoolEvaluation {
    //学校评价id,主键
    @TableId(type = IdType.AUTO)
    @TableField("evaluation_id")
    private int evaluationId;
    //学生id
    @TableField("stu_id")
    private int stuId;
    //学生所在班期id
    @TableField("term_id")
    private int termId;
    //学校评价人id
    @TableField("school_appra_id")
    private int SchoolAppraId;
    //学校总评分数
    @TableField("allappra_score")
    private String AllAppraScore;
    //学校评价
    @TableField("appra_content")
    private String AppraContent;

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public void setSchoolAppraId(int schoolAppraId) {
        SchoolAppraId = schoolAppraId;
    }

    public void setAllAppraScore(String allAppraScore) {
        AllAppraScore = allAppraScore;
    }

    public void setAppraContent(String appraContent) {
        AppraContent = appraContent;
    }

    /**
     * 默认的无参构造方法
     */
    public SchoolEvaluation() {
    }
}
