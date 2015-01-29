package com.kingnod.etraining.common.ui.components;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.Converts;
import com.kingnod.etraining.common.service.SysParameterService;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 日期组件类
 * @author Huang
 *
 */
public class DatePicker extends TextField{
	
	protected String defined;
	protected boolean useButton;
	protected String ctxPath;
	protected String dateFmt; 
	protected Object date;

	public DatePicker(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);		
	}
	

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        if (defined != null) {
            addParameter("defined", findString(defined));
        }
        if (ctxPath != null) {
        	addParameter("ctxPath", findString(ctxPath));
        }
        
        addParam("useButton",useButton);
         
        String fmt = StringUtils.nvl(dateFmt,SysParameterUtils.getString(SysParameterService.SYS_DATE_FORMAT));
        String nameValue = "";
        if (date != null) {
        	if (date instanceof Date) 
        		nameValue = DateUtils.format((Date)date, fmt);
        	else if (date instanceof String)
        		nameValue = (String)date;
        } else {
    		Object dateValue = getParameters().get("nameValue");
				
    		if ( dateValue instanceof String ) {
    			dateValue = findValue(dateValue.toString());
    			if (dateValue != null)
    				nameValue = (String) dateValue;
    			else 
    				addParameter("nameValue","");
    		} else if (dateValue instanceof Date){
    			dateValue = DateUtils.format((Date)dateValue, fmt);
    			nameValue = (String) dateValue;
    		}
        }        
        addParam("nameValue",nameValue);

		
    }

	public String getDefined() {
		return defined;
	}
	
    protected Class getValueClassType() {
        return Date.class;
    }

	public void setDefined(String defined) {
		this.defined = defined;
	}
	
	@Override
	protected String getDefaultTemplate() {
		return "datepicker";
	}

	public boolean getUseButton() {
		return useButton;
	}


	public void setUseButton(boolean useButton) {
		this.useButton = useButton;
	}


	public String getCtxPath() {
		return ctxPath;
	}


	public void setCtxPath(String ctxPath) {
		this.ctxPath = ctxPath;
	}


	public String getDateFmt() {
		return dateFmt;
	}


	public void setDateFmt(String dateFmt) {
		this.dateFmt = dateFmt;
	}


	public Object getDate() {
		return date;
	}


	public void setDate(Object date) {
		this.date = date;
	}

	 

}
