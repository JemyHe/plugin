package com.xingxue.plugin.poi.annotation.export.bigExport;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.export.ExcelBatchExportServer;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Collection;

/**
 * Created by Administrator on 2017/9/20.
 */
public class BatchExportFun1 {
    /**
     * @param entity 表格标题属性
     * @param pojoClass Excel对象Class
     * @param dataSet Excel对象数据List
     */
    public static Workbook exportBigExcel(ExportParams entity, Class<?> pojoClass,
                                          Collection<?> dataSet) {
        ExcelBatchExportServer batachServer = ExcelBatchExportServer
                .getExcelBatchExportServer(entity, pojoClass);
        return batachServer.appendData(dataSet);
    }

    /**
     * 关闭批量导出服务器
     */
    public static void closeExportBigExcel() {
        ExcelBatchExportServer batachServer = ExcelBatchExportServer.getExcelBatchExportServer(null,
                null);
        batachServer.closeExportBigExcel();
    }
}
