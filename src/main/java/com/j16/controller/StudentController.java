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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "student", produces = "application/json;charset=utf-8")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping(value = "selectStudent")
    @ResponseBody
    public String selectStudent(@RequestParam("index") Integer index) {
        return JSON.toJSONString(studentService.selectStudents(index, 5), SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 删除单个
     *
     * @param studentNo
     * @return
     */
    @GetMapping(value = "deleteStudent")
    @ResponseBody
    public String deleteStudent(@RequestParam("studentNo") Integer studentNo) {
        if (studentService.deleteStudent(studentNo) > 0) {
            return "true";
        } else {
            return "false";
        }

    }


    /**
     * 全选删除
     *
     * @return
     */
    @GetMapping(value = "deleteStudents")
    @ResponseBody
    public String deleteStudents(@RequestParam("studentNo") String studentNo) {
        if (studentService.deleteStudents(Arrays.asList(studentNo.split(","))) > 0) {
            return "true";
        } else {
            return "false";
        }

    }


    @GetMapping("fuzzyQueryStudent")
    @ResponseBody
    public String fuzzyQueryStudent(@RequestParam("gradeId") Integer gradeId, @RequestParam("studentName") String studentName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gradeId", gradeId);
        map.put("studentName", studentName);
        return JSON.toJSONString(studentService.fuzzyQueryStudent(map), SerializerFeature.DisableCircularReferenceDetect);
    }


}
