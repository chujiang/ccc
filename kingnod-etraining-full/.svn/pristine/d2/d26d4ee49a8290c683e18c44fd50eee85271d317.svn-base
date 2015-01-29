/**
 * 
 */
package com.kingnod.etraining.common.ui.components;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 * js中引用国际化字段
 */
public class JsMsgRef extends BaseUIBean{

  final public static String TEMPLATE = "jsMsgRef";
  
  protected String var;
  protected String value;
  
  public JsMsgRef(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  protected String getDefaultTemplate() {
    return TEMPLATE;
  }
  
  @Override
  public void evaluateExtraParams() {
    super.evaluateExtraParams();
    if (var != null) {
      addParameter("var", findString(var));
    }
    
    if (value != null) {
      addParameter("mapValr", JSONObject.fromObject(getValue(value)).toString());
      //addParameter("mapVal", getValue(value));
    }
  }

  public Map<String, String> getValue(String value){
    Map<String,String> map = new HashMap<String,String>();
    if(StringUtils.isNotEmpty(value)){
      Map<String,Object[]> mapPar = new HashMap<String,Object[]>();
      String[] regex = value.split(";");//org.userFullName{a:b:c};   org.userFullName
      for (String str : regex) {
        if(str.indexOf("[") != -1 && str.indexOf("]") != -1){
          String key = str.substring(0,str.indexOf("["));
          String parameter = str.substring(str.indexOf("[")+1,str.indexOf("]"));
          mapPar.put(key, parameter.split(","));
        }else{
          mapPar.put(str, new Object[0]);
        }
      }
      
      for(Map.Entry<String, Object[]> entry : mapPar.entrySet()){
        //String cc = TagUtils.getMessage(entry.getKey(), StringUtils.EMPTY);//不带参数
        String proName = TagUtils.getMessage(entry.getKey(), StringUtils.EMPTY, entry.getValue());//带参数
        if(StringUtils.isNotEmpty(proName) && entry.getKey() != proName){
          map.put(entry.getKey(),proName);
        }
      }
    }
    return map;
  }
  
  public void setVar(String var) {
    this.var = var;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
