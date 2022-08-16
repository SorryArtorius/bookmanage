package com.j16.service;

import com.github.pagehelper.PageInfo;
import com.j16.pojo.Student;

import java.util.List;

public interface StudentService {

    PageInfo<Student> selectStudents(int index,int page);
}
