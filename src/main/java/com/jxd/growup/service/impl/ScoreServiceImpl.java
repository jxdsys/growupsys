package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IScoreDao;
import com.jxd.growup.model.Score;
import com.jxd.growup.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName ScoreServiceImpl
 * @Description: TODO
 * @Author nsj
 * @Date 2021/1/7
 **/
@Service
public class ScoreServiceImpl extends ServiceImpl<IScoreDao, Score> implements IScoreService {
    @Autowired
    private IScoreDao scoreDao;
    @Override
    public Map<String, Object> getScoreByStuId(int stuid) {
        return scoreDao.getScoreByStuId(stuid);
    }
}
