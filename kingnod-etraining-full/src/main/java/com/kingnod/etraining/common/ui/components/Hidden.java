package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.util.ValueStack;

public class Hidden extends org.apache.struts2.components.Hidden {

  public Hidden(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }
}

