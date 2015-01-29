package com.kingnod.etraining.common.ui.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.opensymphony.xwork2.util.ValueStack;

public class PeriodTagBean extends BaseUIBean {

	final public static String TEMPLATE = "Period";

	protected String key;

	public PeriodTagBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	@Override
	public void evaluateExtraParams() {
		super.evaluateExtraParams();
		Period period = (Period)this.findValue(this.name);
		addParameter("periods", period);
		// key="aty.week_day_monday";
		addParameter("monday", getValue("aty.week_day_monday"));
		addParameter("tuesday", getValue("aty.week_day_tuesday"));
		addParameter("wednesday", getValue("aty.week_day_wednesday"));
		addParameter("thursday", getValue("aty.week_day_thursday"));
		addParameter("friday", getValue("aty.week_day_friday"));
		addParameter("saturday", getValue("aty.week_day_saturday"));
		addParameter("sunday", getValue("aty.week_day_sunday"));
		addParameter("FlageType_E", getValue("aty.period_FlageType_E"));
		addParameter("FlageType_S", getValue("aty.period_FlageType_S"));

		addParameter("timeType_D", getValue("aty.period_timeType_D"));
		addParameter("timeType_N", getValue("aty.period_timeType_N"));
		addParameter("timeType_S", getValue("aty.period_timeType_S"));
		addParameter("timeType_W", getValue("aty.period_timeType_W"));

		addParameter("FlagType", getValue("aty.period_FlagType"));
		addParameter("periodType", getValue("aty.period_periodType"));
		addParameter("Expression", getValue("aty.period_Expression"));
		//this.parameters.get("periods");
		addParameter("periodTime", getValue("aty.preiod_Time"));
		addParameter("periodLink", getValue("aty.period_linkTime"));
		addParameter("periodDate", getValue("aty.preiod_date"));
		// if (key != null) {
		// addParameter("monday", getValue(key));
		// }
	}

	/**
	 * 获取国际化数据
	 * 
	 * @param key
	 * @return String
	 */
	public String getValue(String key) {
		String empty = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(key)) {
			int index = key.indexOf("[");
			int index2 = key.indexOf("]");

			if (index != -1 && index2 != -1) {// 国际化数据带参数
				String tagKey = key.substring(0, index);
				String parameter = key.substring(key.indexOf("[") + 1,
						key.indexOf("]"));
				empty = TagUtils.getMessage(tagKey, empty,
						(Object[]) parameter.split(","));
			} else {
				empty = TagUtils.getMessage(key, empty);// 没有参数
			}
		}
		return empty;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
