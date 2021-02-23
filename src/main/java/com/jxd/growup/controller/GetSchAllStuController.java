package com.jxd.growup.controller;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.growup.model.*;
import com.jxd.growup.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GetSchAllStuController {
    @Autowired
    private IGetSchAllStuService schAllStuService;
    @Autowired
    private ITermService termService;
    @Autowired
    private ISchoolGetStuService schoolGetStuService;
    @Autowired
    private IInsertStuScoreService iinsertStuScoreService;
    @Autowired
    private IGetTermidDistrStuService getTermidDistrStuService;
    @Autowired
    private IGetDeptAppraOfSchService getDeptAppraOfSchService;
    @Autowired
    private InsertInfoSchtoDeptService insertInfoSchtoDeptService;

    /**
     * 获取学校评价模块的所有学生信息(学校评价功能模块)
     *
     * @param queryMap
     * @return
     */
    @PostMapping("/getSchAllStu")
    public Map<String, Object> getSchAppra(@RequestBody Map<String, String> queryMap) {
        //获取每个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String stuname = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        //班期
        String termsId = queryMap.get("termid") == null ? "" : queryMap.get("termid");
        //如果termsId为空，查询所有学生信息，否则获取该班期的学生信息
        if (termsId.equals("")) {
            return schAllStuService.getFirstSchAllStu(limit, page, stuname);
        } else {
            int termId = Integer.parseInt(termsId);
            return schAllStuService.getSchAllStu(limit, page, stuname, termId);
        }

    }

    /**
     * 获取该老师所教授的所有班期(班期下拉框)(学校评价功能模块)
     *
     * @return
     */
    @GetMapping("/getSomeTerms/{userName}")
    public Map<String, Object> getTerms(@PathVariable String userName) {
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("sch_appra_id", userName);
        Map<String, Object> map = new HashMap<>();
        map.put("data", termService.listMaps(wrapper));
        map.put("code", "200");
        return map;
    }

    /**
     * 获取登录学校评价人当前教授班期id(学校评价功能模块)
     *
     * @param userName
     * @return
     */
    public int getAllTerm(String userName) {
        int number = 0;
        AbstractWrapper wrapper = new QueryWrapper();
        Map<String, String> maps = new HashMap<>();
        maps.put("sch_appra_id", userName);
        maps.put("flag", "未结课");
        wrapper.allEq(maps);
        Term term = termService.getOne(wrapper);
        if (term != null) {
            int termid = term.getTermId();
            return termid;
        } else {
            return number;
        }

    }

    /**
     * 获取登录学校评价人当前教授班期id(学校评价功能模块)
     *
     * @param userName
     * @return
     */
    @GetMapping("/getThatTerm/{userName}")
    public int getThatTerm(@PathVariable String userName) {
        int number = 0;
        AbstractWrapper wrapper = new QueryWrapper();
        Map<String, String> maps = new HashMap<>();
        maps.put("sch_appra_id", userName);
        maps.put("flag", "未结课");
        wrapper.allEq(maps);
        Term term = termService.getOne(wrapper);
        if (term != null) {
            int termid = term.getTermId();
            return termid;
        } else {
            return number;
        }

    }

    /**
     * 获取登录学校评价人教授当前班期的学生信息(学校评价功能模块)
     *
     * @param queryMap
     * @return
     */
    @PostMapping("/getSchOneTermStu")
    public Map<String, Object> getSchOneTermStu(@RequestBody Map<String, String> queryMap) {
        //获取每个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String stuname = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        String userName = queryMap.get("userName") == null ? "" : queryMap.get("userName");
        int termid = getAllTerm(userName);
        if (termid == 0) {
            Map<String, Object> map = new HashMap<>();
            String msg = "没有需要评价的学生";
            map.put(msg, "没有需要评价的学生");
            return map;
        } else {
            return schAllStuService.getSchAllStu(limit, page, stuname, termid);
        }

    }

    /**
     * 通过获取的termid和教师(评价人)的id在完成评分后进修修改班期状态和老师状态(学校评价功能模块)
     *
     * @param userName
     */
    @GetMapping("/getUpdState/{userName}")
    public void getUpdState(@PathVariable String userName) {
        int termid = getAllTerm(userName);
        if (termid != 0) {
            //分别获取该期学生数量和已评完分数的学生数量
            int stucount = schAllStuService.getStuCount(termid);
            int scoreStuCount = schAllStuService.getFromTermStudentCount(termid);
            //如果学生数量和评完分的学生数量一致则进行更改，否则不做处理
            if (stucount == scoreStuCount && stucount != 0) {
                schAllStuService.updTermState(termid);
                schAllStuService.updTeacherState(userName);
            }
        }

    }

    /**
     * 评分时，获取还未评分(或即将评分)学生的该条信息(学校评价功能模块)
     *
     * @param stuid
     * @return
     */
    @GetMapping("/getOneStuById/{stuid}")
    public Map<String, Object> getOneStuById(@PathVariable String stuid) {
        Map<String, Object> map = new HashMap<>();
        map = schAllStuService.getOneTomark(stuid);
        return map;
    }

    /**
     * 获取学生的基本信息(学校评价功能模块)
     *评分时上方表的学生信息
     * @param stuid
     * @return
     */
    @PostMapping("/SchoolGetStu")
    public Student SchoolGetStu(@RequestBody String stuid) {
        return schoolGetStuService.getById(stuid);
    }

    /**
     * 将评的分数插入到score表中(学校评价功能模块)
     *
     * @param score
     * @return
     */
    @PostMapping("/tocommit")
    public String insertStuScore(@RequestBody Score score) {
        if (iinsertStuScoreService.updmarkedScore(score)) {
            return "success";
        } else {
            return "fail";
        }

    }

    /**
     * 当分配部门时获取termid(通过学校评价人id)(学校评价功能模块)
     *
     * @return
     */
    // @GetMapping("/getTermidDistrStu/{userName}")
    public String getTermidDistrStu(String userName) {
        String termid = getTermidDistrStuService.getTermidDistrStu(userName);
        return termid;
    }

    /**
     * 分配部门功能：获取当前班期所有学生信息(学校评价功能模块)
     *
     * @param queryMap
     * @return
     */
    @PostMapping("/getAllStuDistrStu")
    public Map<String, Object> getAllStuDistrStu(@RequestBody Map<String, String> queryMap) {
        //获取每个查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String stuname = queryMap.get("filter") == null ? "" : queryMap.get("filter");
        String userName = queryMap.get("userName") == null ? "" : queryMap.get("userName");
        String termid = getTermidDistrStu(userName);
        //int termid = Integer.parseInt(termids);
        return schAllStuService.getSchAllStuDistri(limit, page, stuname, termid);
    }


    //获取部门评价人信息
    //部门的获取用的是DeptController中的(/getDept)
    @GetMapping("/getDeptAppraToSch/{deptid}")
    public List<DeptAppra> getDeptAppraToSch(@PathVariable String deptid) {
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("deptid", deptid);
        return getDeptAppraOfSchService.list(wrapper);
    }

    /**
     * 分配部门功能向三个表修改或增加student,dept_evolution_all,dept_evolution_score(学校评价功能模块)
     *
     * @param stuid
     * @param deptid
     * @param deptAppraid
     * @return
     */
    @GetMapping("/insertInfoSchtoDept/{stuid}/{deptid}/{deptAppraid}")
    public String insertInfoSchtoDept(@PathVariable String stuid, @PathVariable String deptid, @PathVariable String deptAppraid) {
        insertInfoSchtoDeptService.updStuSchtoDept(stuid, deptid);
        insertInfoSchtoDeptService.insertStuSchtoDept(stuid, deptAppraid);

        List<DeptEvaluationScore> list = new ArrayList<>();
        DeptEvaluationScore deptEvaluationScore = new DeptEvaluationScore();
        DeptEvaluationScore deptEvaluationScore2 = new DeptEvaluationScore();
        DeptEvaluationScore deptEvaluationScore3 = new DeptEvaluationScore();
        DeptEvaluationScore deptEvaluationScore4 = new DeptEvaluationScore();
        int stuidTwo = Integer.parseInt(stuid);
        deptEvaluationScore.setStuid(stuidTwo);
        deptEvaluationScore2.setStuid(stuidTwo);
        deptEvaluationScore3.setStuid(stuidTwo);
        deptEvaluationScore4.setStuid(stuidTwo);
        int deptAppraidTwo = Integer.parseInt(deptAppraid);
        deptEvaluationScore.setDeptAppraid(deptAppraidTwo);
        deptEvaluationScore2.setDeptAppraid(deptAppraidTwo);
        deptEvaluationScore3.setDeptAppraid(deptAppraidTwo);
        deptEvaluationScore4.setDeptAppraid(deptAppraidTwo);
        deptEvaluationScore.setDateid(0);
        deptEvaluationScore2.setDateid(1);
        deptEvaluationScore3.setDateid(2);
        deptEvaluationScore4.setDateid(3);

        list.add(deptEvaluationScore);
        list.add(deptEvaluationScore2);
        list.add(deptEvaluationScore3);
        list.add(deptEvaluationScore4);
        insertInfoSchtoDeptService.addByBatch(list);
        boolean flag = true;
        if (flag) {
            return "success";
        } else {
            return "fail";
        }

    }


}
