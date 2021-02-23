package com.jxd.growup.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.growup.dao.IStudentDao;
import com.jxd.growup.model.Student;
import com.jxd.growup.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName StudentServiceImpl
 * @Description: TODO
 * @Author nsj
 * @Date 2021/1/2
 **/
@Service
public class StudentServiceImpl extends ServiceImpl<IStudentDao,Student> implements IStudentService {
    @Autowired
    private IStudentDao studentDao;
    @Override
    public Map<String, Object> selectStudentByPageAndTermId(String stuName, String termId, String limit, String page) {
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        //构造分页对象
        Page<Map<String,Object>> pages = new Page<>(page1,limit1);
        //将分页对象传递到dao层
        Map<String,Object> map = new HashMap<>();
        //调用dao层获取数据
        if (termId == "" ){
            IPage<Map<String,Object>> result = studentDao.selectStudentByPage(pages,stuName);
            if (result!=null){
                map.put("data",result.getRecords());
                map.put("total",result.getTotal());
                map.put("pageCount",result.getPages());
                map.put("code","200");
            }else {
                map.put("code","500");
            }

        }else {
            IPage<Map<String,Object>> result = studentDao.selectStudentByPageAndTermId(pages,stuName,termId);
            if (result!=null){
                map.put("data",result.getRecords());
                map.put("total",result.getTotal());
                map.put("pageCount",result.getPages());
                map.put("code","200");
            }else {
                map.put("code","500");
            }
        }
        return map;
    }
}
