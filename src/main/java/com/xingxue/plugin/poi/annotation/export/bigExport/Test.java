package com.xingxue.plugin.poi.annotation.export.bigExport;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.xingxue.plugin.poi.entity.StudentEntity;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 * 大批量导出，数量在几万甚至上百万条
 * 一次从数据库查询这么多数据加载到内存然后写入会对我们的内存和CPU都产生压力,
 * 这个时候需要我们像分页一样处理
 * 导出分段写入Excel缓解Excel的压力
 * EasyPoi提供的方法强制使用 xssf版本的Excel
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Test.bigDataExport();
    }

    /**
     * 组装10000条数据并导出
     * @throws Exception
     */
    public static void bigDataExport() throws Exception {

        Workbook workbook = null;
        Date start = new Date();
        ExportParams params = new ExportParams("大数据测试", "测试");
        List<StudentEntity> studentEntityLisst = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {  //一百万数据量
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId("1"+i);
            studentEntity.setBirthday(new Date());
            studentEntity.setName("小明" + i);
            studentEntity.setRegistrationDate(new Date());
            studentEntity.setSex(i);
            studentEntityLisst.add(studentEntity);
            //每一千条导出一次, 分10次导出
            if(studentEntityLisst.size() == 1000){
                workbook = ExcelExportUtil.exportBigExcel(params, StudentEntity.class, studentEntityLisst);
                studentEntityLisst.clear();
            }
        }
        //关闭批量导出服务器
        ExcelExportUtil.closeExportBigExcel();
        System.out.println(new Date().getTime() - start.getTime());
        File savefile = new File("bigDataExport.xlsx");
        FileOutputStream fos = new FileOutputStream(savefile);
        workbook.write(fos);
        fos.close();
    }

}
