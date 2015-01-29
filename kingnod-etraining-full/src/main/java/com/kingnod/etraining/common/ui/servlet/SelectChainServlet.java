
package com.kingnod.etraining.common.ui.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.kingnod.core.dict.DataDict;
import com.kingnod.core.dict.DictFactory;
import com.kingnod.core.dict.DictService;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.CollectionUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.ServletUtils;

/**
 * 下拉框联动处理Servlet
 * 
 * @author Sam
 * 
 */
public class SelectChainServlet extends HttpServlet {
    
    private static final long serialVersionUID = -423509844200834022L; 
    
    public void init(ServletConfig sc) {

//        LOG.info("======================SelectChainServlet startup=============");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        process(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        process(request, response);
    }
    
    @SuppressWarnings("unchecked")
    public void process(HttpServletRequest request, HttpServletResponse response) {

        try {
            if (ServletUtils.isJsonRequest(request)) {
                List<SelectChainParam> params = populateChainParams(request);
                List<Map> results = ListUtils.newList();
                DictFactory dictFactory = SpringUtils.getBean(DictFactory.class);
                DictService dictService = dictFactory.createDictService();
                if (CollectionUtils.isNotEmpty(params)) {
                    for (SelectChainParam scp : params) {
                        DataDict dd = 
                        	dictService.getDict(getDictConfigName(scp.getDictName()), getDictName(scp.getDictName()), scp.getParams());
                        Map map = new HashMap();
                        map.put("items", dd.getItems());
                        map.put("id", scp.getId());
                        results.add(map);
                    }
                }
                renderJson(response, JSONArray.fromObject(results).toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(500);
            renderJson(response, ex.getMessage());
        }
    }
    
    private void renderJson(HttpServletResponse res,String content) {
    	ServletUtils.renderJson(res, content);
    }
    
    private String getDictConfigName(String dictName) {

        if (StringUtils.contains(dictName, "."))
            return dictName.split("\\.")[0];
        return "";
    }
    
    private String getDictName(String dictName) {

        if (StringUtils.contains(dictName, "."))
            return dictName.split("\\.")[1];
        return dictName;
    }
    
    @SuppressWarnings( {"unchecked", "deprecation" })
    private List<SelectChainParam> populateChainParams(HttpServletRequest request) {

        String jsonString = ServletUtils.readRequestBody(request);
        JSONArray jsonArr = JSONArray.fromObject(jsonString);
        List<SelectChainParam> scpList = JSONArray.toList(jsonArr, SelectChainParam.class);
        return scpList;
    }
    
//    @SuppressWarnings( {"deprecation", "unchecked" })
//    public static void main(String[] a) {
//
//        String json = "[{id:'id',params:{'dept':'10'},dictName:'common.dept'}]";
//        List<SelectChainParam> list = JSONArray.toList(JSONArray.fromObject(json),
//                SelectChainParam.class);
//        for (SelectChainParam scp : list)
//            Lang.print(scp);
//    }
    
}
