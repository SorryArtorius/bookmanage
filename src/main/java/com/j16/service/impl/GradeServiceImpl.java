package com.j16.service.impl;

import com.j16.dao.GradeDao;
import com.j16.pojo.Grade;
import com.j16.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeDao dao;

    public Grade getGrade(int gradeId) {
        return dao.getGrade(gradeId);
    }

    public List<Grade> getGrades() {
        return dao.getGrades();
    }
}
