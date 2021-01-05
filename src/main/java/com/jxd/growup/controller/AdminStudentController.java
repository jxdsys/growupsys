package com.jxd.growup.controller;

import com.jxd.growup.model.Student;
import com.jxd.growup.service.IStudentService;
import com.jxd.growup.service.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminStudentController
 * @Description: TODO
 * @Author nsj
 * @Date 2021/1/2
 **/
@RestController
public class AdminStudentController {
    @Autowired
    private IStudentService studentService;

    /**
     * 查询学员信息
     * @param map
     * @return
     */
    @PostMapping("/stuInfo")
    public Map<String,Object> stuInfo(@RequestBody Map<String,Object> map){
        String stuName = map.get("filter") == null ? "" :  map.get("filter").toString();
        String termId = map.get("termid") == null ? "" :  map.get("termid").toString();
        String limit = map.get("limit") == null ? "" :  map.get("limit").toString();
        String page = map.get("page") == null ? "" :  map.get("page").toString();
        Map<String,Object> mapStus = studentService.selectStudentByPageAndTermId(stuName,termId,limit,page);
        return mapStus;
    }


    @Autowired
    private ITermService termService;
    @PostMapping("/getAllTerm")
    public Map<String,Object> getAllTerm(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",termService.listMaps());
        map.put("code","200");
        return map;
    }

    /**
     * 新增或者修改员工信息
     * @param map
     * @return
     */
    @PostMapping("/addOrUpdStu")
    public String addOrUpdStu(@RequestBody Map<String,Object> map){
        String stuid = map.get("stuid") == null ? "" : map.get("stuid").toString();
        String stuName = map.get("stuname") == null ? "" :  map.get("stuname").toString();
        String sex = map.get("sex") == null ? "" :  map.get("sex").toString();
        int termId = Integer.parseInt(map.get("termid") == null ? "" :  map.get("termid").toString());
        if (stuid == ""){
            Student student = new Student(stuName,sex,termId);
            boolean isAdd = studentService.save(student);
            if (isAdd = true){
                return "success";
            }else {
                return "fail";
            }
        }else {
            int stuId = Integer.parseInt(stuid);
            Student student = new Student(stuId,stuName,sex,termId);
            boolean isUpd = studentService.updateById(student);
            if (isUpd = true){
                return "success";
            }else {
                return "fail";
            }
        }

    }
    @GetMapping("/getStuById/{stuid}")
    public Student getStuById(@PathVariable String stuid){
        Map<String,Object> map = new HashMap<>();
        return studentService.getById(stuid);
    }
    @PostMapping("/delBatchStu")
    public String delBatchStu(@RequestBody List<Integer> arrstuids){
        if (studentService.removeByIds(arrstuids)){
            return "success";
        }else{
            return "fail";
        }
    }

}
