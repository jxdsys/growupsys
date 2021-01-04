package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Term;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IAdmintermDao extends BaseMapper<Term> {
    /**
     * 获取所有班期信息
     * @return
     */
    IPage<Map<String,Object>> getAllTerm(Page<Map<String,Object>> pages, @Param("tname") String tname);

    /**
     * 新增班期
     * @return
     */
    boolean addTerm(String termname);

    /**
     * 获取最后一个班期
     * @return
     */
    String getLastTerm();

    /**
     * 给该班期添加老师
     * @param schAppraId
     * @return
     */
    boolean updSchAppra(@Param("schAppraId") int schAppraId,@Param("termid") int termId);

    /**
     * 学校评价人表中修改状态
     * @param schAppraId
     * @return
     */
    boolean updTermState(int schAppraId);



}
