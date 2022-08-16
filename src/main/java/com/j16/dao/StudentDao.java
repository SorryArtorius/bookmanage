package com.j16.dao;

import com.j16.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudents();
}
