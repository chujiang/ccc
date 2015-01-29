/**
 * 
 */
package com.kingnod.etraining.common.ui.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.kingnod.etraining.common.ui.components.File;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author liuxiaobin
 */
public class FileTag extends BaseUITag{

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = -2154950640215144864L;

  protected String accept;
  protected String size;
  
  @Override
  public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
    return new File(stack,req,res);
  }
  
  protected void populateParams() {
    super.populateParams();
    File file = ((File) component);
    file.setAccept(accept);
    file.setSize(size);
  }

  public void setAccept(String accept) {
    this.accept = accept;
  }

  public void setSize(String size) {
    this.size = size;
  }
}
