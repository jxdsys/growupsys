package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IDeptEvaluationAllDao;
import com.jxd.growup.model.DeptEvaluationAll;
import com.jxd.growup.model.DeptEvaluationScore;
import com.jxd.growup.service.IDeptEvaluationAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DeptEvaluationAllServiceImpl extends ServiceImpl<IDeptEvaluationAllDao, DeptEvaluationAll> implements IDeptEvaluationAllService {
    @Autowired
    private IDeptEvaluationAllDao deptEvaluationAllDao;

    /**
     * 分页查询员工信息
     *
     * @param limit 条数
     * @param page  页码
     * @param ename 姓名
     * @return 信息
     */
    @Override
    public Map<String, Object> selectEmpList(int limit, int page, String ename, int username) {

        //构造分页对象
        Page<Map<String, Object>> pages = new Page<>(page, limit);
        //将分页对象传到dao层
        Map<String, Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String, Object>> res = deptEvaluationAllDao.selectEmpList(pages, ename, username);
        map.put("data", res.getRecords());
        map.put("total", res.getTotal());
        map.put("pageCount", res.getPages());
        return map;
    }

    @Override
    public String getOneDept(String username) {
        return deptEvaluationAllDao.getOneDept(username);
    }

    @Override
    public Map<String, Object> selectAllEmpList(int limit, int page, String ename, int username) {
        //构造分页对象
        Page<Map<String, Object>> pages = new Page<>(page, limit);
        //将分页对象传到dao层
        Map<String, Object> map = new HashMap<>();
        //调用dao层获取数据
        IPage<Map<String, Object>> res = deptEvaluationAllDao.selectAllEmpList(pages, ename, username);
        map.put("data", res.getRecords());
        map.put("total", res.getTotal());
        map.put("pageCount", res.getPages());
        return map;
    }

    @Override
    public Map<String, String> getEmpDeptInfoById(String stuid) {
        return deptEvaluationAllDao.getEmpDeptInfoById(stuid);
    }

    @Override
    public boolean updateScore(DeptEvaluationScore deptEvaluationScore) {
        return deptEvaluationAllDao.updateScore(deptEvaluationScore);
    }

    @Override
    public boolean updateAllScoreFirst(DeptEvaluationAll deptEvaluationAll) {
        return deptEvaluationAllDao.updateAllScoreFirst(deptEvaluationAll);
    }

    @Override
    public boolean updateAllScoreOneYear(DeptEvaluationAll deptEvaluationAll) {
        return deptEvaluationAllDao.updateAllScoreOneYear(deptEvaluationAll);
    }

    @Override
    public boolean updateAllScoreTwoYear(DeptEvaluationAll deptEvaluationAll) {
        return deptEvaluationAllDao.updateAllScoreTwoYear(deptEvaluationAll);
    }

    @Override
    public boolean updateAllScoreThridYear(DeptEvaluationAll deptEvaluationAll) {
        return deptEvaluationAllDao.updateAllScoreThridYear(deptEvaluationAll);
    }

    @Override
    public Map<String,Object> selectEmpScore(int stuid,int timeida) {
        return deptEvaluationAllDao.selectEmpScore(stuid, timeida);
    }

}
