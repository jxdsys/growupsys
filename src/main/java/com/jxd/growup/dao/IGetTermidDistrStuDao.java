package com.jxd.growup.dao;

public interface IGetTermidDistrStuDao {
    /**
     * 获取termid当分配部门时(通过学校评价人id)
     * @param userName 老师(评价人id)
     * @return
     */
    String getTermidDistrStu(String userName);
}
