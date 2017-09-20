package com.xingxue.plugin.poi.annotation.import1;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.xingxue.plugin.poi.entity.CourseEntity;
import com.xingxue.plugin.poi.entity.ImportParam;
import com.xingxue.plugin.poi.entity.StudentEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 *  只能读取xlsx后缀的Excel2007版本
 *  本类中的test.xlsx与test1.xlsx 是根据export包下Test.main()方法执行后导出的
 */
public class Test {

    /**
     * 读取excel数据并转化为java实体
     * @param importParam
     */
    public static void read(ImportParam importParam){
        List list = ExcelImportUtil.importExcel(
                importParam.getFile(),
                importParam.getClazz(), importParam.getImportParams());
        long start = new Date().getTime();
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }

    public static void main(String[] args) {

        //读取学生数据到学生实体类
        ImportParam studentEntityImportParam
                = new ImportParam(1,1,10,"test.xlsx",StudentEntity.class);
        Test.read(studentEntityImportParam);

        //读取课程数据到课程实体类
        ImportParam courseEntityImportParam
                = new ImportParam(2,2,10,"test1.xlsx",CourseEntity.class);
        Test.read(courseEntityImportParam);

    }





}
