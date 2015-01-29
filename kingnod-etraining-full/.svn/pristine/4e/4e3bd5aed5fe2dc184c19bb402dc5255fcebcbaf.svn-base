
package com.kingnod.etraining.common.ui.servlet;

import java.io.Serializable;
import java.util.Map;
/**
 *  客户端发送过来的下拉框联运请求参数
 * 
 * @author Sam
 *
 */
public class SelectChainParam implements Serializable {
    
    private static final long serialVersionUID = -3739675911005523633L;
    private String id;
    private String dictName;
    @SuppressWarnings("unchecked")
    private Map params;
    
    public String getDictName() {

        return dictName;
    }
    
    public void setDictName(String dictName) {

        this.dictName = dictName;
    }
    
    @SuppressWarnings("unchecked")
    public Map getParams() {

        return params;
    }
    
    @SuppressWarnings("unchecked")
    public void setParams(Map params) {

        this.params = params;
    }
    
    public void setId(String id) {

        this.id = id;
    }
    
    public String getId() {

        return id;
    }
    
    public String toString() {

        return String.format("dictName:%s,id:%s,params:%s", dictName, id, params);
    }
}
