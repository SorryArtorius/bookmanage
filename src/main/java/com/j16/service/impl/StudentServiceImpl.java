package com.j16.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j16.dao.StudentDao;
import com.j16.pojo.Student;
import com.j16.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao dao;

    public PageInfo<Student> selectStudents(int index,int page) {
        PageHelper.startPage(index, page);
        return new PageInfo<Student>(dao.selectStudents());
    }
}
