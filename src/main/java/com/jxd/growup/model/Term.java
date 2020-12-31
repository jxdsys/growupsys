package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName TermId
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("term")
public class Term {
    //班期id
    @TableId(type = IdType.AUTO)
    @TableField("term_id")
    private int termId;
    //班期名
    @TableField("term_name")
    private String termName;
    //班期评价人id
    @TableField("sch_appra_id")
    private String schAppraId;
    //班期是否结束的标志
    private int flag;

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getSchAppraId() {
        return schAppraId;
    }

    public void setSchAppraId(String schAppraId) {
        this.schAppraId = schAppraId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * 默认的无参构造方法
     */
    public Term() {
    }
}
