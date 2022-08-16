package com.j16.service;

import com.j16.pojo.Grade;

import java.util.List;

public interface GradeService {

    Grade getGrade(int gradeId);


    /**
     * 查找所有年级信息
     * @return
     */
    List<Grade> getGrades();
}
