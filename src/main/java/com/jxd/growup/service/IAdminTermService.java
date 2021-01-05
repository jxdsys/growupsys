package com.jxd.growup.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Term;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IAdminTermService extends IService<Term> {
    /**
     * 获取所有班期信息
     * @return
     */
    Map<String,Object> getAllTerm(int limit,int page,String tname);
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
    boolean updSchAppra(int schAppraId,int termId);
    /**
     * 学校评价人表中修改状态
     * @param schAppraId
     * @return
     */
    boolean updTermState(int schAppraId);
}
