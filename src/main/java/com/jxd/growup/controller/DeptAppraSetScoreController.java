package com.jxd.growup.controller;

import com.jxd.growup.dao.IStudentDao;
import com.jxd.growup.model.DeptEvaluationAll;
import com.jxd.growup.model.DeptEvaluationScore;
import com.jxd.growup.model.Student;
import com.jxd.growup.service.IDeptEvaluationAllService;
import com.jxd.growup.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeptAppraSetScoreController {
    @Autowired
    private IDeptEvaluationAllService deptEvaluationAllService;
    @Autowired
    private IStudentService studentService;

    //查询未评分员工数据
    @PostMapping("/getEmpInfo")
    public Map<String, Object> getAllEmpInfo(@RequestBody Map<String, String> queryMap) {
        //获取到每一个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        String userName = queryMap.get("userName");
        if (userName != null && !userName.equals("")) {
            int deptAppraid = Integer.parseInt(userName);
            return deptEvaluationAllService.selectEmpList(limit, page, ename, deptAppraid);
        } else {
            Map<String, Object> map = new HashMap<>();
            return map;
        }

    }

    //查询已评分员工数据
    @PostMapping("/getAllEmpInfo")
    public Map<String, Object> selectAllEmpList(@RequestBody Map<String, String> queryMap) {
        //获取到每一个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        String userName = queryMap.get("userName");
        if (userName != null && !userName.equals("")) {
            int deptAppraid = Integer.parseInt(userName);
            return deptEvaluationAllService.selectAllEmpList(limit, page, ename, deptAppraid);
        } else {
            Map<String, Object> map = new HashMap<>();
            return map;
        }

    }

    //查询部门总表的员工信息，根据登录着的姓名查询
    @PostMapping("/getOneDept")
    public Map<String, String> getOneDept(@RequestBody String userName) {
        Map<String, String> map = new HashMap<>();
        if (userName != "") {
            map.put("dept", deptEvaluationAllService.getOneDept(userName));
            map.put("staus", "200");
            return map;
        } else {
            map.put("data", "");
            map.put("staus", "500");
            return map;
        }
    }

    ///getEmpInfoById查询学生信息
    @PostMapping("/getEmpInfoById")
    public Student getEmpInfoById(@RequestBody String stuid) {
        Student student = new Student();
        if (!"".equals(stuid)) {
            student = studentService.getById(stuid);
            return student;
        } else {
            return student;
        }
    }

    //getEmpDeptInfoById查询学生所属部门，以及评价人
    @PostMapping("/getEmpDeptInfoById")
    public Map<String, String> getEmpDeptInfoById(@RequestBody String stuid) {
        Map<String, String> map = new HashMap<>();
        if (!"".equals(stuid)) {
            //返回
            return deptEvaluationAllService.getEmpDeptInfoById(stuid);
        } else {
            return map;
        }
    }

    //updateScore保存成绩
    @PostMapping("/updateScore")
    public String updateScore(@RequestBody Map<String, String> scoreMap) {
        //获取到每一个查询参数
        int ability = Integer.parseInt(scoreMap.get("ability"));
        int stuid = Integer.parseInt(scoreMap.get("stuid"));
        int disposition = Integer.parseInt(scoreMap.get("disposition"));
        int activity = Integer.parseInt(scoreMap.get("activity"));
        int dateid = Integer.parseInt(scoreMap.get("dateid"));
        int score = Integer.parseInt(scoreMap.get("score"));
        int moralQuality = Integer.parseInt(scoreMap.get("moralQuality"));
        int communication =Integer.parseInt(scoreMap.get("communication"));
        String estimated =scoreMap.get("estimated");
        //封装成两个实体类
        DeptEvaluationScore deptEvaluationScore = new DeptEvaluationScore();
        deptEvaluationScore.setAbility(ability);
        deptEvaluationScore.setActivity(activity);
        deptEvaluationScore.setDateid(dateid);
        deptEvaluationScore.setCommunication(communication);
        deptEvaluationScore.setDisposition(disposition);
        deptEvaluationScore.setMoralQuality(moralQuality);
        deptEvaluationScore.setStuid(stuid);
        DeptEvaluationAll deptEvaluationAll =new DeptEvaluationAll();
        deptEvaluationAll.setStuid(stuid);
        if (deptEvaluationAllService.updateScore(deptEvaluationScore)){
            if (dateid == 0) {
                deptEvaluationAll.setScore0(score);
                deptEvaluationAll.setEstimatedfirst(estimated);
                if (deptEvaluationAllService.updateAllScoreFirst(deptEvaluationAll)){
                    return "success";
                }
            } else if (dateid == 1) {
                deptEvaluationAll.setScore1(score);
                deptEvaluationAll.setEstimatedone(estimated);
                if (deptEvaluationAllService.updateAllScoreOneYear(deptEvaluationAll)){
                    return "success";
                }
            } else if (dateid == 2) {
                deptEvaluationAll.setScore2(score);
                deptEvaluationAll.setEstimatedtwo(estimated);
                if (deptEvaluationAllService.updateAllScoreTwoYear(deptEvaluationAll)){
                    return "success";
                }
            } else if (dateid == 3) {
                deptEvaluationAll.setScore3(score);
                deptEvaluationAll.setEstimatedthird(estimated);
                if (deptEvaluationAllService.updateAllScoreThridYear(deptEvaluationAll)){
                    return "success";
                }
            }
        }
        return "fail";
    }

    @GetMapping("/selectEmpScore/{stuid}/{timeida}")
    public Map<String ,Object > selectEmpscore(@PathVariable String stuid ,
                                               @PathVariable String timeida){
        Map<String ,String > map = new HashMap<>();
        int studentid = Integer.parseInt(stuid);
        int dateid = Integer.parseInt(timeida);
        return deptEvaluationAllService.selectEmpScore(studentid,dateid);
    }

}
