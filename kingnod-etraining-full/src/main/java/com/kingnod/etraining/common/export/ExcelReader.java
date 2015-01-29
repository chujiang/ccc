
package com.kingnod.etraining.common.export;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * excel读取器，用于程序导入excel数据的读取。
 * 
 * @author Sam
 * 
 */
public interface ExcelReader {
    
    /**
     * 读取一个指定excel输入流并返回一个ReadResult
     * 
     * @param in excel文件输入流
     * @return
     * @throws IOException
     */
    public abstract ReadResult read(InputStream in) throws IOException;
    
    /**
     * 读取一个指定excel文件并返回一个ReadResult
     * 
     * @param importFile
     * @return
     * @throws IOException
     */
    public abstract ReadResult read(File importFile) throws IOException;
    
    /**
     * 读取一个指定路径的excel文件并返回一个ReadResult
     * 
     * @param importPath
     * @return
     * @throws IOException
     */
    public abstract ReadResult read(String importPath) throws IOException;
    
    /**
     * 设置是否忽略读取文件过程中产生的错误
     * 
     * @param skipError
     */
    public abstract void setSkipError(boolean skipError);
    
    public abstract boolean isSkipError();
    
    /**
     * 添加一个结果映射
     * 
     * @param key
     * @param value
     */
    public abstract void addResultMapping(String key, Object value);
    
    public abstract Map getResultMapping();
    
}
