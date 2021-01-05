package com.jxd.growup.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IGetSchAllStuDao {
    /**
     * 获取某期所有学校评价人模块学生信息
     * @return
     */
    IPage<Map<String,Object>> getSchAllStu(Page<Map<String,Object>> pages, @Param("stuname") String stuname,@Param("termid") int termId);

    /**
     * 所有学校评价人模块学生信息
     * @param pages
     * @param stuname
     * @return
     */
    IPage<Map<String,Object>> getFirstSchAllStu(Page<Map<String,Object>> pages, @Param("stuname") String stuname);

}
