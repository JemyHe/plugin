package com.xingxue.plugin.poi.annotation.export;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class Test {

    public static void main(String[] args) {

        //导出学生excel表
        List<StudentEntity> studentEntities = initParams();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity.class, studentEntities);
        write(workbook,"test");

        //导出课程excel表
        List<CourseEntity> courseEntities = initCourseParams();
        Workbook workbook1 = ExcelExportUtil.exportExcel(new ExportParams("2412312", "测试", "测试"),
                CourseEntity.class, courseEntities);
        write(workbook1,"test1");
    }

    /**
     * 学生excel表数据组装
     * @return
     */
    private static List<StudentEntity> initParams(){
        List<StudentEntity> list = new ArrayList<StudentEntity>();
        Date now = new Date();
        StudentEntity se = new StudentEntity("1","何",1,now,now);
        StudentEntity se1 = new StudentEntity("2","何1",2,now,now);
        StudentEntity se2 = new StudentEntity("3","何2",1,now,now);
        list.add(se);
        list.add(se1);
        list.add(se2);
        return list;
    }

    /**
     * 课程数据组装
     * @return
     */
    private static List<CourseEntity> initCourseParams(){
        List<StudentEntity> studentEntities = initParams();
        TeacherEntity te = new TeacherEntity("1","徐老师");
        List<CourseEntity> courseEntities = new ArrayList<CourseEntity>();
        CourseEntity ce = new CourseEntity("1","java基础",te,studentEntities);
        CourseEntity ce1 = new CourseEntity("2","web基础",te,studentEntities);
        courseEntities.add(ce);
        courseEntities.add(ce1);
        return courseEntities;

    }

    /**
     * 导出xlsx
     * @param workbook
     */
    private static void write(Workbook workbook,String fileName){
        try {
            OutputStream out = new FileOutputStream(new File(fileName + ".xlsx"));
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
