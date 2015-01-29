
package com.kingnod.etraining.common.export;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.kingnod.core.util.io.IOUtils;

/**
 * 抽象excelreader，封装一些通用的属性，具体的读取方式由子类实现。
 * 
 * @author Sam
 * 
 */
public abstract class AbstractExcelReader implements ExcelReader {
    
    protected boolean skipError;
    
    protected Map resultMapping = new HashMap();
    
    /*
     * (non-Javadoc)
     * @see com.cmsz.framework.excel.ExcelReader#read(java.io.InputStream)
     */
    public abstract ReadResult read(InputStream in) throws IOException;
    
    /*
     * (non-Javadoc)
     * @see com.cmsz.framework.excel.ExcelReader#read(java.io.File)
     */
    public ReadResult read(File importFile) throws IOException {

        return read(IOUtils.fileIn(importFile));
    }
    
    /*
     * (non-Javadoc)
     * @see com.cmsz.framework.excel.ExcelReader#read(java.lang.String)
     */
    public ReadResult read(String importPath) throws IOException {

        return read(new File(importPath));
    }
    
    /*
     * (non-Javadoc)
     * @see com.cmsz.framework.excel.ExcelReader#setSkipError(boolean)
     */
    public void setSkipError(boolean skipError) {

        this.skipError = skipError;
    }
    
    /*
     * (non-Javadoc)
     * @see com.cmsz.framework.excel.ExcelReader#isSkipError()
     */
    public boolean isSkipError() {

        return skipError;
    }
    
    /*
     * (non-Javadoc)
     * @see com.cmsz.framework.excel.ExcelReader#addReadConfig(java.lang.String, java.lang.Object)
     */
    public void addResultMapping(String key, Object value) {

        this.resultMapping.put(key, value);
    }
    
    /*
     * (non-Javadoc)
     * @see com.cmsz.framework.excel.ExcelReader#getReadConfig()
     */
    public Map getResultMapping() {

        return resultMapping;
    }
    
}
