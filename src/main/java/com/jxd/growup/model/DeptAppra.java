package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Compappra
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("dept_appra")
public class DeptAppra {
    //部门评价人id
    @TableId(type = IdType.AUTO)
    @TableField("dept_appraid")
    private int deptAppraid;
    //部门评价人姓名
    @TableField("dept_appra_name")
    private String deptAppraName;
    //所在部门
    private int deptid;
    //职务
    private int jobid;

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public int getDeptAppraid() {
        return deptAppraid;
    }

    public void setDeptAppraid(int deptAppraid) {
        this.deptAppraid = deptAppraid;
    }

    public String getDeptAppraName() {
        return deptAppraName;
    }

    public void setDeptAppraName(String deptAppraName) {
        this.deptAppraName = deptAppraName;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }
    /**
     * 默认的无参构造方法
     */
    public DeptAppra() {
    }
}
