package com.xingxue.plugin.poi.annotation;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class TestStudentEntity {

    public static void main(String[] args) {
        List<StudentEntity> studentEntities = initParams();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                StudentEntity .class, studentEntities);
        System.out.println(workbook);
    }


    private static List<StudentEntity> initParams(){
        List<StudentEntity> list = new ArrayList<StudentEntity>();
        Date now = new Date();
        StudentEntity se = new StudentEntity("1","何",1,now,now);
        StudentEntity se1 = new StudentEntity("2","何1",0,now,now);
        StudentEntity se2 = new StudentEntity("3","何2",1,now,now);
        list.add(se);
        list.add(se1);
        list.add(se2);
        return list;
    }
}
