package com.j16.service;

import com.github.pagehelper.PageInfo;
import com.j16.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    PageInfo<Student> selectStudents(int index,int page);


    int deleteStudent(int studentNo);

    int deleteStudents(List list);


    /**
     * 模糊查询
     * @param map
     * @return
     */
    List<Student> fuzzyQueryStudent(Map map);
}
