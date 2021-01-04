package com.jxd.growup.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.growup.model.Dept;
import com.jxd.growup.model.DeptAppra;
import com.jxd.growup.model.Job;
import com.jxd.growup.service.IDeptAppraService;
import com.jxd.growup.service.IDeptService;
import com.jxd.growup.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class DeptController {
    //注入部门评价人组件
    @Autowired
    private IDeptAppraService deptAppraService;
    //注入部门组件
    @Autowired
    private IDeptService deptService;
    //注入职务组件
    @Autowired
    private IJobService jobService;

    //分页查询所有部门评价人的信息
    @PostMapping("/getDeptAppra")
    public Map<String ,Object > getDeptAppras(@RequestBody Map<String ,String> queryMap){
        //获取到每一个查询参数
        int limit =Integer.parseInt(queryMap.get("limit"));
        int page =Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("filter")== null ? "" :queryMap.get("filter");
        return  deptAppraService.selectDeptAppraWithDeptAndJob(limit,page,ename);
    }
    //获取部门列表
    @GetMapping("/getDept")
    public List<Dept> getDepts(){
        List<Dept> list = deptService.list();
        return deptService.list();
    }
    //获取职务列表
    @GetMapping("/getJob")
    public  List<Job> getJobs(){
        List<Job> list =jobService.list();
        return jobService.list();
    }
    //新增或修改评价人信息
    @PostMapping("/addDeptAppra")
    public String addDeptAppra(@RequestBody DeptAppra deptAppra){
        if(deptAppraService.saveOrUpdate(deptAppra)){
            return "success";
        }else{
            return "fail";
        }
    }
    //根据id查询评价人信息
    @GetMapping("/getDeptAppraById/{dept_appraid}")
    public DeptAppra getDeptAppraById(@PathVariable int dept_appraid){
        return deptAppraService.getById(dept_appraid);
    }
    //删除
    @PostMapping("/delDeptAppra")
    public String delDeptAppra(@RequestBody List<Integer> dept_appraids){
        if(deptAppraService.removeByIds(dept_appraids)){
            return "success";
        }else{
            return "fail";
        }
    }
    //分页查询所有部门的信息
    @PostMapping("/getDeptList")
    public Map<String ,Object > getDeptList(@RequestBody Map<String ,String> queryMap){
        //获取到每一个查询参数
        int limit =Integer.parseInt(queryMap.get("limit"));
        int page =Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("filter")== null ? "" :queryMap.get("filter");
        return  deptService.selectDeptList(limit,page,ename);
    }
    //根据id查询部门信息
    @GetMapping("/getDeptById/{deptid}")
    public Dept getDeptById(@PathVariable int deptid){
        return deptService.getById(deptid);
    }
    //新增或修改部门信息
    @PostMapping("/addDept")
    public String addDept(@RequestBody Dept dept){
        if(deptService.saveOrUpdate(dept)){
            return "success";
        }else{
            return "fail";
        }
    }
    //删除部门
    @PostMapping("/delDept")
    public String delDept(@RequestBody List<Integer> deptids){
        if(deptService.removeByIds(deptids)){
            return "success";
        }else{
            return "fail";
        }
    }


}
