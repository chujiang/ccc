
package com.kingnod.etraining.common.export;

import java.util.List;
import java.util.Map;

/**
 * 读取Excel文件结果。
 * 
 * @author Sam
 * 
 */
public class ReadResult {
    
    protected boolean status;
    protected List readMessages;
    protected Map value;
    
    public ReadResult(boolean status, List readMessages, Map resultMap) {

        super();
        this.status = status;
        this.readMessages = readMessages;
        this.value = resultMap;
    }
    
    public boolean getStatus() {

        return status;
    }
    
    public List getReadMessages() {

        return readMessages;
    }
    
    public Map getValue() {

        return value;
    }
}
