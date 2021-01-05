package com.jxd.growup.service;

import java.util.Map;

public interface IGetSchAllStuService {
    /**
     * 获取某期所有学校评价人模块学生信息
     * @return
     */
    Map<String,Object> getSchAllStu(int limit, int page, String stuname,int termId);

    /**
     * 获取所有学校评价人模块学生信息
     * @return
     */
    Map<String,Object> getFirstSchAllStu(int limit, int page, String stuname);
}
