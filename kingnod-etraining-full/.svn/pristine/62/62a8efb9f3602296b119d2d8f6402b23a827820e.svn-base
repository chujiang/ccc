package com.kingnod.etraining.common;

import org.apache.commons.lang.xwork.StringUtils;

public enum ObjectType {
	
	//########组织管理模块################################################################
	/**
	 * 站点： SITE
	 */
	O_OS, 
	/**
	 * 组织: ORG
	 */
	O_OO, 
	/**
	 * 用户：USER
	 */
	O_OU, 
	/**
	 * 用户属性: USER PROPERTIES
	 */
	O_UP,
	/**
	 * 用户组：USER GROUP
	 */
	O_OG, 
	/**
	 * 角色：USER ROLE
	 */
	O_OR, 
	
	//########资源管理模块################################################################
	/**
	 * 站点： SITE
	 */
	R_OS,
	/**
	 * 资源文件夹：RESOURCE FOLDER
	 */
	R_FF, 
	/**
	 * 匹配所有类型的资源文件夹
	 */
	R__F,
	
	///=====课程管理模块
	/**
	 * 匹配所有的课程对象类型
	 */
	R_C_,
	/**
	 * 课程模块
	 */
	R_CM,
	/**
	 * 课程: COURSE
	 */
	R_CO, 
	/**
	 * SCORM课程：SCORM COURSE
	 */
	R_CS,
	/**
	 * 非SCORM课程：NOT SCORM COURSE
	 */
	R_CN,
	/**
	 * 课程文件夹: COURSE FOLDER
	 */
	R_CF,
	/**
	 * SCORM课程TITLE
	 */
	R_CT,
	/**
	 * SCORM课程SCO
	 */
	R_CI,
	
	///=====课程体系管理模块
	/**
	 * 匹配所有的课程体系类型
	 */
	R_S_,
	/**
	 * 课程体系模块
	 */
	R_SM,
	/**
	 * 课程体系类别: COURSE SYSTEM
	 */
	R_SF,
	
	///=====题库管理模块
	/**
	 * 匹配所有题库管理对象
	 */
	R_Q_,
	/**
	 * 题库模块
	 */
	R_QM,
	/**
	 * 试题：QUESTION
	 */
	R_QU,
	/**
	 * 试题文件夹：QUESTION FOLDER
	 */
	R_QF,
	/**
	 * 试题库：QUESTION BANK;
	 */
	R_QB,
	/**
	 * 单选题库：
	 */
	R_QR,
	/**
	 * 多选题库：
	 */
	R_QD,
	/**
	 * 判断题库
	 */
	R_QP,
	/**
	 * 填空题库
	 */
	R_QT,
	/**
	 * 简答题库
	 */
	R_QJ,
	
	///=====试卷管理模块
	/**
	 * 匹配所有试卷对象类型
	 */
	R_P_,
	/**
	 * 试卷模块
	 */
	R_PM,
	/**
	 * 试卷：PAPER
	 */
	R_PP,
	/**
	 * 试卷文件夹: PAPER FOLDER
	 */
	R_PF,
	
	///=====成绩管理模块
	/**
	 * 成绩单模块
	 */
	R_AM,
	/**
	 * 成绩单：SCORE SHEET
	 */
	R_AS,
	/**
	 * 成绩管理：SCORE SHEET
	 */
	R_AL,
	/**
	 * 课程管理：SCORE SHEET
	 */
	R_AR,
	/**
	 * 成绩单文件夹：SCORE SHEET FOLDER
	 */
	R_AF,
	///=====器材管理模块
	/**
	 * 器材模块
	 */
	R_EM,
	/**
	 * 器材：equipmen
	 */
	R_EE,
	/**
	 * 器材文件夹
	 */
	R_EF,
	
	///=====讲师管理模块
	/**
	 * 讲师模块
	 */
	R_TM,
	/**
	 * 讲师:
	 */
	R_TT,
	/**
	 * 讲师文件夹
	 */
	R_TF,
	
	///=====知识点管理模块
	/**
	 * 匹配所有的知识点对象类型
	 */
	R_Z_,
	/**
	 * 知识点模块
	 */
	R_ZM,
	/**
	 * 知识点
	 */
	R_ZZ,
	/**
	 * 知识点目录
	 */
	R_ZF,
	
	///=====签到表管理模块
	/**
	 * 签到表模块
	 */
	R_BM,
	/**
	 * 签到表
	 */
	R_BB,
	/**
	 * 签到表文件夹
	 */
	R_BF,
	
	///=====场地管理模块
	/**
	 * 场地模块
	 */
	R_LM,
	/**
	 * 场地
	 */
	R_LL,
	/**
	 * 场地文件夹
	 */
	R_LF,
	
	
	//########活动管理模块################################################################
	/**
	 * 站点： SITE
	 */
	A_OS,
	
	/**
	 * 活动文件夹: ACTIVITY FOLDER
	 */
	A_FF,
	/**
	 * 匹配所有活动目录
	 */
	A__F,
	///=====在线学习管理模块
	/**
	 * 匹配所有的在线学习对象
	 */
	A_E_,
	/**
	 * 在线学习模块
	 */
	A_EM,
	/**
	 * 在线学习：ELEARNING
	 */
	A_EL,
	/**
	 * 在线学习文件夹: ELEARNING FOLDER
	 */
	A_EF,
	
	///=====在线考试管理模块
	/**
	 * 匹配所有在线考试对象
	 */
	A_X_,
	/**
	 * 在线考试模块
	 */
	A_XM,
	/**
	 * 在线考试：EXAMINATION
	 */
	A_XN,
	/**
	 * 在线考试文件夹: EXAMINATION FOLDER
	 */
	A_XF,
	
	///=====综合学习管理模块
	/**
	 * 综合学习模块
	 */
	A_IM,
	/**
	 * 综合学习
	 */
	A_IL,
	/**
	 * 综合学习文件夹
	 */
	A_IF,
	
	///=====培训计划管理模块
	/**
	 * 匹配所有的培训计划管理对象
	 */
	A_P_,
	/**
	 * 培训计划模块
	 */
	A_PM,
	/**
	 * 培训计划文件夹
	 */
	A_PF,
	/**
	 * 培训计划
	 */
	A_PT,
	
	
	//########内容服务器管理模块################################################################
	///=====内容服务器模块
	/**
	 * 内容服务器模块
	 */
	C_CM,
	/**
	 * 内容服务器文件夹
	 */
	C_CF,
	/**
	 * 内容服务器课程
	 */
	C_CC,
	
	//########报表管理模块################################################################
	///=====报表文件夹模块
	/**
	 * 报表视图站点
	 */
	P_OS,
	/**
	 * 匹配所有报表文件
	 */
	P__F,
	/**
	 * 报表文件夹
	 */
	P_FF,
	
	 /**
   * 员工课程学习统计报表
   */
	P_AF,
	
	 /**
   * 课程统计报表
   */
	P_BF,
	
	/**
	   * 员工考试统计报表
	   */
	P_CF,
	
	/**
	   * 考试统计报表
	   */
	P_DF;
	
	
	public static ObjectType[] split(String types, String separatorChars){
		if(StringUtils.isEmpty(types)){
			return new ObjectType[0];
		}
		String[] typesArray = StringUtils.split(types, separatorChars);
		ObjectType[] result = new ObjectType[typesArray.length];
		for(int i = 0; i < typesArray.length; ){
			result[i] = ObjectType.valueOf(typesArray[i].trim());
		}
		return result;
	}
	
}
