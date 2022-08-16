package com.j16.dao;

import com.j16.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectStudents();

    int deleteStudent(int studentNo);


    int deleteStudents(List list);


    List<Student> fuzzyQueryStudent(Map map);
}
