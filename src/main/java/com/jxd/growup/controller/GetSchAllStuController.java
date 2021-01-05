package com.jxd.growup.controller;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.growup.service.IGetSchAllStuService;
import com.jxd.growup.service.ITermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GetSchAllStuController {
    @Autowired
    private IGetSchAllStuService schAllStuService;
    @Autowired
    private ITermService termService;

    /**
     * 获取学校评价模块的学生信息
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
        String termsId = queryMap.get("termid") == null ? "" : queryMap.get("termid");
        if (termsId.equals("")) {
            return schAllStuService.getFirstSchAllStu(limit, page, stuname);
        } else {
            int termId = Integer.parseInt(termsId);
            return schAllStuService.getSchAllStu(limit, page, stuname, termId);
        }

    }

    /**
     * 获取班期
     *
     * @return
     */
    @GetMapping("/getSomeTerms/{userName}")
    public Map<String,Object> getTerms(@PathVariable String userName) {
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("sch_appra_id",userName);
        Map<String, Object> map = new HashMap<>();
        map.put("data", termService.listMaps(wrapper));
        map.put("code","200");
        return map;
    }
}
