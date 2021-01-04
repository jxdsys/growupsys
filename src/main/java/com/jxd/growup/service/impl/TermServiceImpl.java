package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.ITermDao;
import com.jxd.growup.model.Term;
import com.jxd.growup.service.ITermService;
import org.springframework.stereotype.Service;

/**
 * @ClassName TermServiceImpl
 * @Description: TODO
 * @Author nsj
 * @Date 2021/1/4
 **/
@Service
public class TermServiceImpl extends ServiceImpl<ITermDao, Term> implements ITermService {
}
