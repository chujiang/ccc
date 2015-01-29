
package com.kingnod.etraining.common.export;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.util.Lang;
import com.kingnod.core.util.collection.CollectionUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.io.IOUtils;
import com.kingnod.core.util.web.ServletUtils;

/**
 * 抽象导出器，封装了一些基本属性，具体的导出实现由子类去实现。
 * 
 * @author Sam
 * 
 */
public abstract class AbstractExcelExporter implements ExcelExporter {
    
    @SuppressWarnings("unchecked")
    protected Map reportParams = new HashMap();
    @SuppressWarnings("unchecked")
    protected Map dataSources = new HashMap();
    protected String reportPath;
    protected String exportPath;
    protected CellMergeSetting cellSetting;
    
    public AbstractExcelExporter() {

    }
    
    public AbstractExcelExporter(String reportPath, String exportPath) {

        this.reportPath = reportPath;
        this.exportPath = exportPath;
    }
    
    @SuppressWarnings("unchecked")
    public ExcelExporter addParam(String paramName, Object paramValue) {

        reportParams.put(paramName, paramValue);
        return this;
    }
    
    @SuppressWarnings("unchecked")
    public ExcelExporter addDataSource(String dsName, List dataSource) {

        dataSources.put(dsName, dataSource);
        return this;
    }
    
    @SuppressWarnings("unchecked")
    public ExcelExporter addDataSources(Map dataSources) {

        this.dataSources.putAll(dataSources);
        return this;
    }
    
    @SuppressWarnings("unchecked")
    public ExcelExporter addParams(Map params) {

        this.reportParams.putAll(params);
        return this;
    }
    
    public ExcelExporter cellMerge(Integer uniteStartRow, Integer rowSize, List<Integer> uniteCols) {

        this.cellSetting = new CellMergeSetting(uniteStartRow, rowSize, uniteCols);
        return this;
    }
    
    /**
     * 处理数据源,不同的导出方式可能会有不同的数据源格式，子类可以重写此方法，默认情况下会将
     * List<List>结构的数据集转成List<Map>这样的结构，并且以col1、col2...这样为key
     */
    @SuppressWarnings("unchecked")
    protected void processDataSource() {

        Set keys = dataSources.keySet();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            String dsName = it.next().toString();
            List ds = (List) dataSources.get(dsName);
            ds = isListRecordType(ds) ? ListUtils.listsToMap(ds, "col") : ds;
            processDataSource(dsName, ds);
        }
    }
    
    @SuppressWarnings("unchecked")
    protected void processDataSource(String dsName, List ds) {

    }
    
    /**
     * 定义导出时一系列的步骤，具体由子类实现
     */
    public void export() throws IOException {

        processDataSource();
        processParams();
        processOther();
        doExport();
    }
    
   
    public void export(HttpServletResponse response, String exportName, boolean isCloseStream)
        throws IOException {

        export();
        File file = getExportFile();
        if (!file.exists())
            throw Lang.makeThrow("file[%s]is not exists ,can not do export！");
        OutputStream outStream = ServletUtils.buildDownloadOutputStream(response, exportName);
        export(outStream, isCloseStream);
        
    }
    
    public void export(OutputStream outStream, boolean isCloseStream) throws IOException {

        export();
        File file = getExportFile();
        if (!file.exists())
            throw Lang.makeThrow("file[%s]is not exists ,can not do export！");
        InputStream inStream = IOUtils.fileIn(file);
        try {
            IOUtils.copy(inStream, outStream);
        } finally {
            if (isCloseStream)
            	IOUtils.close(outStream);
            IOUtils.close(inStream);
        }
    }
    
    /**
     * 获取导出后的文件，必须在执行export()之后，否则文件会不存在
     * 
     * @return
     */
    protected File getExportFile() {

        return new File(exportPath);
    }
    
    /**
     * 真正执行执行导出的方法，子类必须实现此方法
     * 
     * @throws IOException
     */
    protected abstract void doExport() throws IOException;
    
    /**
     * 回调接口
     */
    protected void processOther() {

    }
    
    /**
     * 处理参数
     */
    protected void processParams() {

    }
    
    @SuppressWarnings("unchecked")
    protected boolean isListRecordType(Collection ds) {

        if (CollectionUtils.isEmpty(ds))
            return false;
        Object record = CollectionUtils.first(ds);
        return (record instanceof List);
    }
    
    public String getExportPath() {

        return exportPath;
    }
    
    public ExcelExporter setExportPath(String exportPath) {

        this.exportPath = exportPath;
        return this;
    }
    
    public String getReportPath() {

        return reportPath;
    }
    
    public ExcelExporter setReportPath(String reportPath) {

        this.reportPath = reportPath;
        return this;
    }
}
