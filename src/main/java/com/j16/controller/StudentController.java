package com.j16.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.j16.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "student",produces="application/json;charset=utf-8")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping(value = "selectStudent")
    @ResponseBody
    public String selectStudent(@RequestParam("index") Integer index){
        return JSON.toJSONString(studentService.selectStudents(index,5), SerializerFeature.DisableCircularReferenceDetect);
    }
}
