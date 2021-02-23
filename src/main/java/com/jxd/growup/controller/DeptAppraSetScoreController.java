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
    //注入成绩表组件
    @Autowired
    private IDeptEvaluationAllService deptEvaluationAllService;
    //注入学生表组件
    @Autowired
    private IStudentService studentService;

    //查询未评分员工数据
    @PostMapping("/getEmpInfo")
    public Map<String, Object> getAllEmpInfo(@RequestBody Map<String, String> queryMap) {
        //获取到每一个查询参数
        int limit = Integer.parseInt(queryMap.get("limit")== null ? "": queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page") == null ? "":queryMap.get("page"));
        String ename = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        String userName = queryMap.get("userName")== null ? "" : queryMap.get("userName");
        int deptAppraid = Integer.parseInt(userName);
        return deptEvaluationAllService.selectEmpList(limit, page, ename, deptAppraid);

    }

    //查询已评分员工数据//不执行
    @PostMapping("/getAllEmpInfo")
    public Map<String, Object> selectAllEmpList(@RequestBody Map<String, String> queryMap) {
        //获取到每一个查询参数
        int limit = Integer.parseInt(queryMap.get("limit")== null ? "": queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page") == null ? "":queryMap.get("page"));
        String ename = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        String userName = queryMap.get("userName")== null ? "" : queryMap.get("userName");
        int deptAppraid = Integer.parseInt(userName);
        return deptEvaluationAllService.selectAllEmpList(limit, page, ename, deptAppraid);
    }

    //查询部门总表的员工信息，根据登录着的姓名查询
    @PostMapping("/getOneDept")
    public Map<String, String> getOneDept(@RequestBody String userName) {
        Map<String, String> map = new HashMap<>();
        if (userName != null) {
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
    public Student getEmpInfoById(@RequestBody String stuid ) {
        Student student = new Student();
        if (stuid != null) {
            student = studentService.getById(stuid);
            return student;
        } else {
            return student;
        }
    }

    //getEmpDeptInfoById查询学生所属部门，以及评价人
    @GetMapping("/getEmpDeptInfoById/{stuid}/{userName}")
    public Map<String, String> getEmpDeptInfoById(@PathVariable String stuid ,@PathVariable String userName) {
        Map<String, String> map = new HashMap<>();
        if (stuid != null && userName !=null) {
            //返回
            return deptEvaluationAllService.getEmpDeptInfoById(stuid,userName);
        } else {
            return map;
        }
    }

    //updateScore保存成绩
    @PostMapping("/updateScore")
    public String updateScore(@RequestBody Map<String, String> scoreMap) {
        //获取到每一个查询参数
        if(scoreMap.get("ability")!=null
                && scoreMap.get("stuid")!=null
                && scoreMap.get("disposition")!=null
                &&scoreMap.get("activity") !=null
                && scoreMap.get("dateid")!=null
                &&scoreMap.get("score") !=null
                && scoreMap.get("moralQuality")!=null
                && scoreMap.get("communication")!=null){
            int ability = Integer.parseInt(scoreMap.get("ability"));
            int stuid = Integer.parseInt(scoreMap.get("stuid"));
            int disposition = Integer.parseInt(scoreMap.get("disposition"));
            int activity = Integer.parseInt(scoreMap.get("activity"));
            int dateid = Integer.parseInt(scoreMap.get("dateid"));
            int score = Integer.parseInt(scoreMap.get("score"));
            int moralQuality = Integer.parseInt(scoreMap.get("moralQuality"));
            int communication = Integer.parseInt(scoreMap.get("communication"));
            String estimated = scoreMap.get("estimated")==null ? "" : scoreMap.get("estimated") ;
            //封装成两个实体类
            DeptEvaluationScore deptEvaluationScore = new DeptEvaluationScore();
            deptEvaluationScore.setAbility(ability);
            deptEvaluationScore.setActivity(activity);
            deptEvaluationScore.setDateid(dateid);
            deptEvaluationScore.setCommunication(communication);
            deptEvaluationScore.setDisposition(disposition);
            deptEvaluationScore.setMoralQuality(moralQuality);
            deptEvaluationScore.setStuid(stuid);
            DeptEvaluationAll deptEvaluationAll = new DeptEvaluationAll();
            deptEvaluationAll.setStuid(stuid);
            if (deptEvaluationAllService.updateScore(deptEvaluationScore)) {
                if (dateid == 0) {
                    //保存转正成绩
                    deptEvaluationAll.setScore0(score);
                    deptEvaluationAll.setEstimatedfirst(estimated);
                    if (deptEvaluationAllService.updateAllScoreFirst(deptEvaluationAll)) {
                        return "success";
                    }
                } else if (dateid == 1) {
                    //保存一年评价
                    deptEvaluationAll.setScore1(score);
                    deptEvaluationAll.setEstimatedone(estimated);
                    if (deptEvaluationAllService.updateAllScoreOneYear(deptEvaluationAll)) {
                        return "success";
                    }
                } else if (dateid == 2) {
                    //保存两年评价
                    deptEvaluationAll.setScore2(score);
                    deptEvaluationAll.setEstimatedtwo(estimated);
                    if (deptEvaluationAllService.updateAllScoreTwoYear(deptEvaluationAll)) {
                        return "success";
                    }
                } else if (dateid == 3) {
                    //保存三年评价
                    deptEvaluationAll.setScore3(score);
                    deptEvaluationAll.setEstimatedthird(estimated);
                    if (deptEvaluationAllService.updateAllScoreThridYear(deptEvaluationAll)) {
                        return "success";
                    }
                }
            }
        }
        return "fail";
    }
    //从后台查询分数
    @GetMapping("/selectEmpScore/{stuid}/{timeid}")
    public Map<String, Object> selectEmpScore(@PathVariable String stuid,
                                              @PathVariable String timeid) {
        Map<String, Object> map = new HashMap<>();
        if(stuid != null && timeid != null){
            int studentid = Integer.parseInt(stuid);
            int dateid = Integer.parseInt(timeid);
            //获取所有评价和和分数
            map = deptEvaluationAllService.selectEmpScore(studentid, dateid);
            if(map != null){
                //把数据封装到对应的时间的评价
                map.put("moralQuality",map.get("moral_quality"));
                if(dateid==0){
                    map.put("score",map.get("score0"));
                    map.put("estimated",map.get("estimatedfirst"));
                }
                if(dateid==1){
                    map.put("score",map.get("score1"));
                    map.put("estimated",map.get("estimatedone"));
                }
                if(dateid==2){
                    map.put("score",map.get("score2"));
                    map.put("estimated",map.get("estimatedtwo"));
                }
                if(dateid==3){
                    map.put("score",map.get("score3"));
                    map.put("estimated",map.get("estimatedthird"));
                }
                return map;
            }
            else {
                return map;
            }
        }else {
            return map;
        }
    }
}
