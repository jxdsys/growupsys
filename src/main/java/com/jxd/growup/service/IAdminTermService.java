package com.jxd.growup.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.growup.model.SchoolAppra;
import com.jxd.growup.model.Term;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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
    boolean updSchAppra(int schAppraId,int termId,String schappraname);
    /**
     * 学校评价人表中修改状态
     * @param schAppraId
     * @return
     */
    boolean updTermState(int schAppraId);
    /**
     * 获取未结课且已分配老师的班期
     * @param flag
     * @return
     */
    List<Map<String,Object>> getBusyTerm(String flag);
    /**
     * 根据老师id查找老师姓名
     * @param schAppraId
     * @return
     */
    String selectTeacherName(int schAppraId);
}
