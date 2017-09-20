package com.xingxue.plugin.poi.entity;

import cn.afterturn.easypoi.excel.entity.ImportParams;

import java.io.File;

/**
 * Created by Administrator on 2017/9/20.
 * 读取excel用到的所有参数
 */
public class ImportParam {

    //标题行数
    private int titleRows;

    //表头行数
    private int headRows;

    //读取行数
    private int readRows;

    //要映射的实体类的class
    private Class<?> clazz;

    //文件名称
    private String fileName;

    //文件地址file
    private File file;

    //easypoi需要用到的导入实体
    private ImportParams importParams;


    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ImportParams getImportParams() {
        return importParams;
    }

    public void setImportParams(ImportParams importParams) {
        this.importParams = importParams;
    }

    public int getTitleRows() {
        return titleRows;
    }

    public void setTitleRows(int titleRows) {
        this.titleRows = titleRows;
    }

    public int getHeadRows() {
        return headRows;
    }

    public void setHeadRows(int headRows) {
        this.headRows = headRows;
    }

    public int getReadRows() {
        return readRows;
    }

    public void setReadRows(int readRows) {
        this.readRows = readRows;
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ImportParam() {
    }

    public ImportParam(int titleRows, int headRows, int readRows , String fileName,Class<?> clazz) {
        ImportParams importParam = new ImportParams();
        importParam.setHeadRows(headRows);
        importParam.setReadRows(readRows);
        importParam.setTitleRows(titleRows);
        this.importParams = importParam;
        this.fileName = fileName;
        File file = new File(fileName);
        this.file = file;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "ImportParam{" +
                "titleRows=" + titleRows +
                ", headRows=" + headRows +
                ", readRows=" + readRows +
                ", clazz=" + clazz +
                ", fileName='" + fileName + '\'' +
                ", file=" + file +
                ", importParams=" + importParams +
                '}';
    }
}
