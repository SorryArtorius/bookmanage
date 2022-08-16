package com.j16.controller;


import com.alibaba.fastjson.JSON;
import com.j16.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "grade", produces = "application/json;charset=utf-8")
public class GradeController {

    @Autowired
    GradeService gradeService;


    @GetMapping(value = "getGrades")
    public String getGrades() {
        return JSON.toJSONString(gradeService.getGrades());
    }
}
