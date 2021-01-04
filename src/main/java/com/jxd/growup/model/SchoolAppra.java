package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName SchoolAppra
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("schoolappra")
public class SchoolAppra {
    //学校评价人id
    @TableId(type = IdType.AUTO)
    @TableField("sch_appra_id")
    private int schAppraId;
    //学校评价人名称
    @TableField("sch_appra_name")
    private String schAppraName;
    //学校评价人性别
    private String sex;
    //学校评价人入职日期
    private String hiredate;
    //学校评价人状态
    private String state;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getSchAppraId() {
        return schAppraId;
    }

    public void setSchAppraId(int schAppraId) {
        this.schAppraId = schAppraId;
    }

    public String getSchAppraName() {
        return schAppraName;
    }

    public void setSchAppraName(String schAppraName) {
        this.schAppraName = schAppraName;
    }

    /**
     * 默认无参构造方法
     */
    public SchoolAppra() {
    }
}
