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
