package com.jxd.growup.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName Dept
 * @Description: TODO
 * @Author nsj
 * @Date 2020/12/31
 **/
@TableName("dept")
public class Dept {
    //部门id
    @TableId(type = IdType.AUTO)
    private int deptid;
    //部门名称
    private String dname;
    //部门描述
    private String dcrib;


    public int getDeptid() {
        return deptid;
    }
    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDcrib() {
        return dcrib;
    }

    public void setDcrib(String dcrib) {
        this.dcrib = dcrib;
    }

    /**
     * 默认的无参构造方法
     */
    public Dept() {
    }
}
