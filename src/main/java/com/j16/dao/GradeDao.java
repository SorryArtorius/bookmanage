package com.j16.dao;

import com.j16.pojo.Grade;

import java.util.List;

public interface GradeDao {

    Grade getGrade(int gradeId);


    /**
     * 查找所有年级信息
     * @return
     */
    List<Grade> getGrades();
}
