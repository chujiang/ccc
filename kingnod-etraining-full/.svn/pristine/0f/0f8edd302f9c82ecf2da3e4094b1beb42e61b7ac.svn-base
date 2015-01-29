/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * Sam 20100111 增加修改历史注释<br/>
 * Sam 20120312 将Map<String, String> getRequestMap()改为Map<String, Collection<String>> getRequestMap()，因为一个资源可能会有多个权限值
 */

package com.kingnod.etraining.security;

import java.util.Collection;
import java.util.Map;

/**
 * RequestMap生成接口,由用户自行实现从数据库或其它地方查询URL-授权关系定义.
 * 
 * @author calvin
 * @author Sam
 */
public interface ResourceDetailsService {
    
    /**
     * 返回带顺序的受保护资源
     */
    public Map<String, Collection<String>> getRequestMap() throws Exception; // NOSONAR
}
