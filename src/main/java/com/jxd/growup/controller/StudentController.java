package com.jxd.growup.controller;

import com.jxd.growup.dao.IScoreDao;
import com.jxd.growup.model.Student;
import com.jxd.growup.service.IDeptAppraSetScoreService;
import com.jxd.growup.service.IScoreService;
import com.jxd.growup.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName StudentController
 * @Description: TODO
 * @Author nsj
 * @Date 2021/1/2
 **/
@RestController
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IScoreService scoreService;
    @Autowired
    private IDeptAppraSetScoreService deptAppraSetScoreService;
    @PostMapping("/updStuByStuid")
    public String updStuByStuid(@RequestBody Student student){
       if (studentService.updateById(student)){
           return "success";
       }else {
           return "fail";
       }
    }
    @PostMapping(value="uploadImg",produces = "text/html;charset=utf-8")
    public String upload(@RequestParam("file1") MultipartFile imgfile) {
        //指定存储路径
        String savePath = "D:\\Users\\86159\\web-growsys\\src\\assets\\img";
        //创建存储文件夹
        //创建文件对象
        File file = new File(savePath);
        if(!file.exists() || !file.isDirectory()){
            //当文件不存在或者不是目录时，创建物理文件夹
            file.mkdir();
        }

        //处理文件名，保证不会出现重名的现象
        //获取原文件名称
        String fileName = imgfile.getOriginalFilename();
        //添加前缀：UUID+文件名的形式
        String name_new = UUID.randomUUID() + "_" + fileName;

        //存储文件
        //针对图片文件创建java中的file对象
        File newfile = new File(savePath,name_new);

        try {
            //将spring接收的文件对象转换为普通的java的文件对象
            //将文件以指定的文件名存储到指定目录下
            imgfile.transferTo(newfile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回src可以引用的存储路径以及文件名称
        //    String srcPath = "'@/assets/img/" + name_new + "'";
        //    System.out.println(name_new);
//        int end = name_new.indexOf(".");
//        String srcPath = name_new.substring(0,end);
        //    System.out.println(srcPath);
        return name_new;
    }
    @PostMapping("/isUpdStu")
    public Map<String,Object> isUpdStu(@RequestBody String stuid){
        Student student = studentService.getById(stuid);
        Map<String,Object> map = new HashMap<>();
        if (student.getCardid() != null){
            map.put("return","1");
            map.put("data",student);
        }else {
            map.put("return","2");
            map.put("data",student);
        }
        return map;
    }
    @PostMapping("/GetAllAppra")
    public Map<String,Object> GetAllAppra(@RequestBody String userName){
        Map<String,Object> map = new HashMap<>();
        String [] userNames = userName.split("=");
        int stuid = Integer.parseInt(userNames[0]);
        if (scoreService.getScoreByStuId(stuid).size()>0 ){
           map.put("count","200");
           map.put("schoolData",scoreService.getScoreByStuId(stuid));
           map.put("threeMonthData",deptAppraSetScoreService.getDeptEvaluationByThreeMScoreByStuid(stuid));
           map.put("oneYearData",deptAppraSetScoreService.getDeptEvaluationByOneScoreByStuid(stuid));
           map.put("twoYearData",deptAppraSetScoreService.getDeptEvaluationByTwoScoreByStuid(stuid));
           map.put("threeYearData",deptAppraSetScoreService.getDeptEvaluationByThreeScoreByStuid(stuid));
        }else {
            map.put("count","500");
        }

        return map;
    }
}
