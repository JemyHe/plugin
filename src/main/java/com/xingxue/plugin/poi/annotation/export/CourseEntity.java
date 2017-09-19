package com.xingxue.plugin.poi.annotation.export;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class CourseEntity implements Serializable {
    /** 主键 */
    private String id;

    /** 课程名称 */
    @Excel(name = "课程名称", orderNum = "1", width = 25,needMerge = true)
    private String name;

    /** 老师主键 */
    @ExcelEntity(id = "absent")
    private TeacherEntity mathTeacher;

    @ExcelCollection(name = "学生", orderNum = "4")
    private List<StudentEntity> students;

    public CourseEntity(String id, String name, TeacherEntity mathTeacher, List<StudentEntity> students) {
        this.id = id;
        this.name = name;
        this.mathTeacher = mathTeacher;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherEntity getMathTeacher() {
        return mathTeacher;
    }

    public void setMathTeacher(TeacherEntity mathTeacher) {
        this.mathTeacher = mathTeacher;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
