package com.kingnod.etraining.common.ui.tags;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.components.Component;

import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.common.service.SysParameterService;
import com.kingnod.etraining.common.ui.components.DatePicker;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 日期选择器
 * @author Huanghaibing
 *
 */
public class DatePickerTag extends TextFieldTag {
	 
	private static final long serialVersionUID = -5184645031557004009L;
	private String defined;
	private String wdate;
	private String triggerType;//focus,click
	private String useButton;//true=使用图标
	private String dateFmt;//日期格式
	

    protected void populateParams() {
        super.populateParams();
        DatePicker datePicker = ((DatePicker) component); 
        datePicker.setDefined(getDefined());
        datePicker.setUseButton(StringUtils.isTrue(useButton));
        datePicker.setCtxPath(TagUtils.getContextPath(pageContext));
        datePicker.setDateFmt(dateFmt);
        datePicker.setDate(value);
    }
    
    

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new DatePicker(stack, req, res);
    }

	public String getDefined() { 
		dateFmt = (dateFmt == null || dateFmt.equals("")) ? SysParameterUtils.getString(SysParameterService.SYS_DATE_FORMAT) : dateFmt;
		Map m = MapUtils.mapByAarray("dateFmt",dateFmt);
		defined = JSONObject.fromObject(m).toString();
		return defined;
	}

	public void setDefined(String defined) {
		this.defined = defined;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getUseButton() {
		return useButton;
	}

	public void setUseButton(String useButton) {
		this.useButton = useButton;
	}

	public String getDateFmt() {
		return dateFmt;
	}

	public void setDateFmt(String dateFmt) {
		this.dateFmt = dateFmt;
	}
 
    
}