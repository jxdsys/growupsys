package com.jxd.growup.service.impl;

import com.jxd.growup.dao.IDeptEvaluationScoreDao;
import com.jxd.growup.service.IDeptAppraSetScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeptAppraSetScoreServiceImpl implements IDeptAppraSetScoreService {
    @Autowired
    private IDeptEvaluationScoreDao deptEvaluationScoreDao;

    //查询分数
    @Override
    public Map<String, Object> getDeptEvaluationByThreeMScoreByStuid(int stuid) {
        return deptEvaluationScoreDao.getDeptEvaluationByThreeMScoreByStuid(stuid);
    }

    @Override
    public Map<String, Object> getDeptEvaluationByOneScoreByStuid(int stuid) {
        return deptEvaluationScoreDao.getDeptEvaluationByOneScoreByStuid(stuid);
    }

    @Override
    public Map<String, Object> getDeptEvaluationByTwoScoreByStuid(int stuid) {
        return deptEvaluationScoreDao.getDeptEvaluationByTwoScoreByStuid(stuid);
    }

    @Override
    public Map<String, Object> getDeptEvaluationByThreeScoreByStuid(int stuid) {
        return deptEvaluationScoreDao.getDeptEvaluationByThreeScoreByStuid(stuid);
    }
}
