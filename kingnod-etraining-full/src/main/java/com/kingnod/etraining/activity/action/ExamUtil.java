/**
 * 
 */
package com.kingnod.etraining.activity.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.security.entity.UserAccount;

/**
 * @author 刘小彬
 * 
 *         在线考试活动的工具类
 */
public final class ExamUtil {
	
	private ExamUtil(){}

	private static Map<String, String> scorMap = new HashMap<String, String>();// 计分方式

	private static Map<String, String> displayMap = new HashMap<String, String>();// 是否显示成绩

	private static Map<String, String> periodTypeMap = new HashMap<String, String>();// 时间类别
	
	private static Map<String, String> examHistoryStatusMap = new HashMap<String,String>();// 考试记录的状态
	
	private static Map<String, String> examRestraintStatusMap = new HashMap<String,String>();// 考试限制
	
	private static Map<String, String> testGroupTypeMap = new HashMap<String,String>();// 考试限制
	
	private static List<String> testGroupSeq = new ArrayList<String>();//测试区顺序

	static {
		scorMap.put("H", "最高得分");
		scorMap.put("L", "最后得分");
		scorMap.put("A", "平均得分");
		scorMap.put("D", "自定义得分");

		displayMap.put("N", "不显示成绩");
		displayMap.put("Y", "显示成绩");
		displayMap.put("A", "显示所有人成绩");

		periodTypeMap.put("N", "每天");
		periodTypeMap.put("W", "每周");
		periodTypeMap.put("D", "每月");
		periodTypeMap.put("S", "特定");
		
		examHistoryStatusMap.put(ExamConstant.EXAM_QUES_STATUS_N, "未考试");
		examHistoryStatusMap.put(ExamConstant.EXAM_QUES_STATUS_S, "考试中");
		examHistoryStatusMap.put(ExamConstant.EXAM_QUES_STATUS_E, "考试结束");
		examHistoryStatusMap.put(ExamConstant.EXAM_QUES_STATUS_A, "阅卷中");
		examHistoryStatusMap.put(ExamConstant.EXAM_QUES_STATUS_R, "阅卷结束");
		examHistoryStatusMap.put(ExamConstant.EXAM_QUES_STATUS_D, "审核中");
		examHistoryStatusMap.put(ExamConstant.EXAM_QUES_STATUS_P, "审核结束");
		
		examRestraintStatusMap.put(ExamConstant.EXAM_RESTRAINT_STATUS_N, "无");
		examRestraintStatusMap.put(ExamConstant.EXAM_RESTRAINT_STATUS_D, "每天");
		examRestraintStatusMap.put(ExamConstant.EXAM_RESTRAINT_STATUS_W, "每周");
		examRestraintStatusMap.put(ExamConstant.EXAM_RESTRAINT_STATUS_M, "每月");
		
		testGroupTypeMap.put("R", "单选题");
		testGroupTypeMap.put("C", "多选题");
		testGroupTypeMap.put("B", "判断题");
		testGroupTypeMap.put("T", "填空题");
		testGroupTypeMap.put("A", "简答题");
		testGroupTypeMap.put("U", "无限制");
		
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_R);//单选
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_C);//多选
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_B);//判断
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_T);//填空
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_A);//简答
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_Z);//组合题
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_U);//无限制
		testGroupSeq.add("");//无限制
	}

	/**
	 * 获取测试区固定顺序
	 * @return
	 */
	public static List<String> getTestGroupSeq(){
		return testGroupSeq;
	}
	
	/**
	 * 获取考试限制
	 * @param restraint
	 * @return String
	 */
	public static String getAtyRestraint(String restraint){
		restraint = restraint == null ? "N" : restraint;
		return examRestraintStatusMap.get(restraint);
	}
	
	/**
	 * 获取计分方式，默认为最高得分
	 * 
	 * @param scorType
	 * @return String
	 */
	public static String getScoringType(String scorType) {
		String value = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(scorType)) {
			value = scorMap.get(scorType);
		}
		return StringUtils.isNotEmpty(value) ? value : scorMap.get("H");
	}

	/**
	 * 阅览试卷是，是否显示成绩
	 * 
	 * @param scorType
	 * @return String
	 */
	public static String getDisplayScore(String display) {
		String value = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(display)) {
			value = displayMap.get(display);
		}
		return StringUtils.isNotEmpty(value) ? value : displayMap.get("N");
	}

	/**
	 * 时间类别
	 * 
	 * @param scorType
	 * @return String
	 */
	public static String getPeriodType(String periodType) {
		String value = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(periodType)) {
			value = periodTypeMap.get(periodType);
		}
		return StringUtils.isNotEmpty(value) ? value : periodTypeMap.get("N");
	}

	/**
	 * 时间标记
	 * 
	 * @param scorType
	 * @return String
	 */
	public static String getAlailbleDays(String periodType) {
		String value = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(periodType)) {
			value = periodType.replaceAll("-", ",");
			if (value.lastIndexOf(",") != -1) {
				value = value.substring(0, value.length() - 1);
			}
			if (StringUtils.isNotEmpty(value)) {
				value = "(" + value + ")";
			}
		}
		return value;
	}

	/**
	 * 设置考试历史记录参数
	 * 
	 * @param examHistory
	 */
	public static void setExamDatilDate(ExamineesHistory examHistory,String totalScore) {
		if (examHistory != null) {
			examHistory.setTotalScoreStr(getTotalScore(examHistory).toString() + "/" + totalScore);// 考生等分 /试卷总分
			examHistory.setStatus(getExamHistoryStatus(examHistory.getStatus()));//设置考试记录的状态- 考试结束，阅卷中
			
			Date startDate = examHistory.getStartTime();
			Date endDate = examHistory.getEndTime();
			if (startDate != null && endDate != null) {
				DateFormat df = DateFormat.getDateInstance();
				String date = df.format(startDate);
				examHistory.setExamDate(date);

				DateFormat dfs = DateFormat.getTimeInstance();
				String startTime = dfs.format(startDate);
				String endTime = dfs.format(endDate);
				examHistory.setExamTime(startTime + " - " + endTime);
			}
		}
	}
	
	/**
	 * 格式化当前得分
	 * @param totalScore
	 * @return String
	 */
	public static String formatNumerical(Object obj){
		String toScore = "0";
		if(obj == null){
			return toScore;
		}
		toScore = obj.toString();
		if(obj instanceof Float){
			Float floatObj = (Float)obj;
			if(floatObj.toString().endsWith(".0")){
				toScore = ((Integer)floatObj.intValue()).toString();
			}
		}else if(obj instanceof Double){
			Double doubleObj = (Double)obj;
			if(doubleObj.toString().endsWith(".0")){
				toScore = ((Integer)doubleObj.intValue()).toString();
			}
		}
		return toScore;
	}
	
	/**
	 * 获取考试记录的状态
	 * @param status
	 * @return String
	 */
	public static String getExamHistoryStatus(String status){
		String statusStr = examHistoryStatusMap.get(ExamConstant.EXAM_QUES_STATUS_E);
		if(StringUtils.isNotEmpty(status)){
			statusStr = examHistoryStatusMap.get(status);
		}
		return statusStr;
	}

	/**
	 * 获取本次考试记录 - 考生得分
	 * @return Float
	 */
	public static Float getTotalScore(ExamineesHistory exmaHistory){
		Float totalScroeStr = 0.0F;
		if(exmaHistory != null){
			//totalScore是自动阅卷得分和手动阅卷得分的和
			//Float curScore = exmaHistory.getScore() == null || exmaHistory.getScore() == 0.0F ? 0.0F : exmaHistory.getScore();//自动阅卷得分
			Float totalScore = exmaHistory.getTotalscore() == null ? 0.0F : exmaHistory.getTotalscore();//手动阅卷得分
			totalScroeStr = totalScore;
		}
		return totalScroeStr;
	}
	
	/**
	 * 查阅试卷时，判断是否显示正确答案
	 * 
	 * @param exam
	 */
	public static void setExamDisplayAnswer(Examination exam) {
		if (exam != null) {
			String displayAnswer = StringUtils.isNotEmpty(exam
					.getDisplayAnswer()) ? exam.getDisplayAnswer()
					: StringUtils.EMPTY;
			exam.setDisplayAnswer(StringUtils.equals(displayAnswer,
					ExamConstant.STATUS_CONSULT_Y) ? ExamConstant.STATUS_CONSULT_ANSWER
					: ExamConstant.STATUS_CONSULT);
		}
	}
	
	/**
	 * 获取每月的开始日期或者结束日期
	 * @return Date
	 */
	public static Date getMonthDate(String type) {
		Date startDate = null;
		Date endDate = null;
		
		// 本月的第一天
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.DATE, 1);
		SimpleDateFormat simpleFormate = new SimpleDateFormat("yyyy-MM-dd");
		String startDateStr = simpleFormate.format(calendar.getTime());
		try {
			startDate = simpleFormate.parse(startDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 本月的最后一天
		Calendar calendar2 = new GregorianCalendar();
		calendar2.set(Calendar.DATE, 1);
		calendar2.roll(Calendar.DATE, -1);
		SimpleDateFormat simpleFormate2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleFormate3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String endDateStr = simpleFormate2.format(calendar2.getTime())+ " 23:59:59";
		try {
			endDate = simpleFormate3.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(StringUtils.equals(type, "S")){
			return startDate;
		}else if(StringUtils.equals(type, "E")){
			return endDate;
		}
		return null;
	}
	
	/**
	 * 将日期对象转换成固定格式日期之后,获取time
	 * 
	 * @return Long
	 */
	public static Long formatDate(Date date){
		if(date != null){
			SimpleDateFormat simFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dStr = simFormate.format(date);
			if(StringUtils.isNotEmpty(dStr)){
				try {
					Date dateNew = simFormate.parse(dStr);
					if(dateNew != null){
						return dateNew.getTime();
					}
				} catch (ParseException e) {
					return null;
				}
			}
		}
		return null;
	}

	/**
	 * 获取当前日期对象的开始时间活结束时间
	 * @param type
	 * @return Date
	 */
	public static Date getDayDate(String type){
		Date startDate = null;
		Date endDate = null;
		
		Date curDate = new Date();
		SimpleDateFormat simpleFormate3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat simpleFormate2 = new SimpleDateFormat("yyyy-MM-dd");
		
		String startDateStr = simpleFormate2.format(curDate) + " 00:00:00";
		try {
			startDate = simpleFormate3.parse(startDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String endDateStr = simpleFormate2.format(curDate) + " 23:59:59";
		try {
			endDate = simpleFormate3.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(StringUtils.equals("S", type)){
			return startDate;
		}else if(StringUtils.equals("E", type)){
			return endDate;
		}
		return null;
	}
	
	/**
	 * 本周的开始日期和结束日期
	 * 
	 * @return Date
	 */
	public static Date getWeekDate(String type) {
		Date mDate = new Date();
		DateFormat dateFormat = DateFormat
				.getDateInstance(DateFormat.DATE_FIELD);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(mDate);

		cal.set(cal.WEEK_OF_MONTH, 2);
		cal.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.MONDAY);
		String startDateStr = dateFormat.format(cal.getTime());
		Date startDate = getSimpleDate(startDateStr, "yy-MM-dd");

		cal.add(GregorianCalendar.DAY_OF_MONTH, 6);
		String endDateStr = dateFormat.format(cal.getTime()) + " 23:59:59";
		Date endDate = getSimpleDate(endDateStr, "yy-MM-dd hh:mm:ss");

		if (StringUtils.equals("S", type)) {
			return startDate;
		} else if (StringUtils.equals("E", type)) {
			return endDate;
		}
		return null;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param simpleDate
	 * @return
	 */
	public static Date getSimpleDate(String dateStr, String simpleDate) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(simpleDate);
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取计分方式对应的sqlKey
	 * @param scoreType
	 * @return String
	 */
	public static String getScoreType(String scoreType){
		String scoreingType = ExamConstant.FINDEXAMMAXSCORE;//最高分
		if(StringUtils.equals("A", scoreType)){//平均分
			scoreingType = ExamConstant.FINDEXAMAVGSCORE;
		}else if(StringUtils.equals("L", scoreType)){//最后一次分数
			scoreingType = ExamConstant.FINDEXAMLASTSCORE;
		}
		return scoreingType;
	}
	
	/**
	 * 获取当前登录用户的Id
	 * @return Long
	 */
	public Long getUserId(){
		UserAccount userAccount = (UserAccount)SecurityUtils.getCurrentUser();
		return userAccount.getId();
	}
	
	/**
	 * 获取考试记录的状态（阅卷，审核）
	 * @param historyStatus
	 * @return String
	 */
	public static String getHisStatus(String historyStatus){
		String status = StringUtils.EMPTY;
		if(StringUtils.isNotEmpty(historyStatus)){
			if(StringUtils.equals("Y", historyStatus)){
				status = "阅卷";
			}else if(StringUtils.equals("S", historyStatus)){
				status = "审核";
			}else if(StringUtils.equals("阅卷", historyStatus)){
				status = "Y";
			}else if(StringUtils.equals("审核", historyStatus)){
				status = "S";
			}
		}
		return status;
	}
}
