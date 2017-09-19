package com.xingxue.plugin.poi.annotation.import1;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.xingxue.plugin.poi.annotation.export.CourseEntity;
import com.xingxue.plugin.poi.annotation.export.StudentEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */
public class Test {

    public static void main(String[] args) {
        ImportParams params = new ImportParams();

        long start = new Date().getTime();
        List<StudentEntity> list = ExcelImportUtil.importExcel(
                new File("test.xlsx"),
                StudentEntity.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }
}
