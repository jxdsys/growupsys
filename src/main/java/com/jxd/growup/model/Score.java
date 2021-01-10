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
    private int scoreid;
    //学生id
    private int stuid;
    //html成绩
    private String html;
    //oracle成绩
    private String oracle;
    //js成绩
    private String js;
    //java成绩
    private String java;
    //superjava成绩
    private String superjava;
    //L1面试成绩
    @TableField("l1")
    private String l1;
    //content评价（优点/缺点）
    private String content;
    //apprascore成绩
    private String apprascore;
    //学校评价人id
    @TableField("sch_appra_id")
    private int schAppraId;
    //班期id
    private int termid;

    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getOracle() {
        return oracle;
    }

    public void setOracle(String oracle) {
        this.oracle = oracle;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getSuperjava() {
        return superjava;
    }

    public void setSuperjava(String superjava) {
        this.superjava = superjava;
    }

    public String getL1() {
        return l1;
    }

    public void setL1(String l1) {
        this.l1 = l1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getApprascore() {
        return apprascore;
    }

    public void setApprascore(String apprascore) {
        this.apprascore = apprascore;
    }

    public int getSchAppraId() {
        return schAppraId;
    }

    public void setSchAppraId(int schAppraId) {
        this.schAppraId = schAppraId;
    }

    public int getTermid() {
        return termid;
    }

    public void setTermid(int termid) {
        this.termid = termid;
    }

    /**
     * 默认的无参构造方法
     */
    public Score() {
    }
}
