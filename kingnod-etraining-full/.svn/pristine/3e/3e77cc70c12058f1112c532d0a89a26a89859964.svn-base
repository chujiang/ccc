package com.kingnod.etraining.activity.service.impl;

import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.action.ExamUtil;
import com.kingnod.etraining.activity.dao.ActivityDetailsDAO;
import com.kingnod.etraining.activity.dao.EnrollLearnerDAO;
import com.kingnod.etraining.activity.dao.ExaminationDAO;
import com.kingnod.etraining.activity.dao.ExamineesHistoryDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.service.ExaminationService;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.dao.ExamineeQuestionDAO;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
public class ExaminationServiceImpl implements ExaminationService {

	@Autowired
	protected ExaminationDAO examinationDAO;

	@Autowired
	private ExamineesHistoryDAO examineesHistoryDAO;

	@Autowired
	private EnrollLearnerDAO enrollLearnerDAO;

	@Autowired
	private PeriodService periodService;

	@Autowired
	private ExamineeQuestionDAO examineeQuestionDAO;
	
	@Autowired
	protected ActivityDetailsDAO activityDetailsDAO;

	/**
	 * 根据Id获取考试活动
	 * 
	 * @param id
	 * @return
	 */
	public Examination getExaminationById(Long id) {
		return examinationDAO.findExaminationById(id);
	}

	/**
	 * 根据Id获取考试活动
	 */
	public Examination getExamination(Long id) {
		Examination result = examinationDAO.get(id);
		if (result != null) {
			result.setTimes(getTimes(result));// 已考次数
			Period period = new Period();
			period.setPeriodFlagId(id);
			period.setPeriodFlagType(ObjectType.A_XN.name());
			List<Period> periodList = periodService.getPeriodByFlagID(period);
			if (!ListUtils.isEmpty(periodList)) {
				result.setPeriods(periodList.get(0));// 有效日期
			}
			Paper paper = result.getPaper();
			if (paper != null && paper.getTotalScore() != null) {
				result.setTotalScore(paper.getTotalScore());// 设置总分数
			}
		}
		return result;
	}

	public int saveExamination(Examination examination) {
		int count = 0;
		Integer reexamTimes = examination.getReexamTimes();
		IdEntity<Long> idEntity = (IdEntity<Long>) examination;
		if (examination.getAtyTime() < 0) {
			throw Exceptions.createAppException("exm0030001");
		} else if (examination.getReexamTimes() < 0) {
			throw Exceptions.createAppException("exm0030002");
		} else if (null != examination.getAtyRestraintTimes() && examination.getAtyRestraintTimes() < 0) {
			throw Exceptions.createAppException("exm0030003");
		} else if (null != examination.getReexamTimeInterval() && examination.getReexamTimeInterval() < 0) {
			throw Exceptions.createAppException("exm0030004");
		} else if (null != examination.getRequiredAnswerCount() && examination.getRequiredAnswerCount() < 0) {
			throw Exceptions.createAppException("exm0030005");
		} else if (null != examination.getOverdueTime() && examination.getOverdueTime() < 0) {
			throw Exceptions.createAppException("exm0030006");
		} else if (!"".equals(examination.getDisplayQuestionNumber()) && null != examination.getDisplayQuestionNumber()
				&& Long.valueOf(examination.getDisplayQuestionNumber()) < 0) {
			throw Exceptions.createAppException("exm0030007");
		} else {
			CriteriaBuilder cb = Cnd.builder(Examination.class);
			cb.andEQ("name", examination.getName());
			int nameCount=0;
			if(null!=examination.getId()){
				cb.andNotEQ("id", examination.getId());
				nameCount=examinationDAO.countByCriteria(cb.buildCriteria());
			}else{
				nameCount = examinationDAO.countByCriteria(cb.buildCriteria());
			}
			if(nameCount > 0) { //活动名称是否已经存在
				throw Exceptions.createAppException("aty001006");
			}
			if (null != idEntity.getId() && null != examinationDAO.get(idEntity.getId())) {
				if (null == reexamTimes || 0 == reexamTimes) {// 如果考试次数为空
					examination.setReexamTimes(1);
				}
				count = examinationDAO.update(examination);
			} else {
				if (null == reexamTimes || 0 == reexamTimes) {// 如果考试次数为空
																// 则默认设置考试次数为 1次
					examination.setReexamTimes(1);
				}
				examination.setPublishStatus(ExamConstant.STATUS_P); // setter  默认为未发布状态
				count = examinationDAO.insert(examination);
			}
			
			if (count > 0) {
				if (null != examination.getPeriods()) {
					Period period = periodService.getPeriodByFlagId(examination.getId(), ObjectType.A_XN);
					if (period != null) {
						examination.getPeriods().setId(period.getId());
					}
					examination.getPeriods().setPeriodFlagId(examination.getId());
					examination.getPeriods().setPeriodFlagType(ObjectType.A_XN.name());
					periodService.savePeriod(examination.getPeriods());
				}
			}
		}
		return count;
	}

	public int deleteExamination(Examination examination) {
		return examinationDAO.delete(examination);
	}

	public int deleteExaminationByIds(Long[] ids) {
		if(examinationDAO.countPublishedByIds(StringUtils.join(ids,",")) > 0) {
			throw Exceptions.createAppException("aty001008");
		}
		return examinationDAO.deleteById(ids);
	}

	public PagingResult<Examination> findExamination(Criteria criteria) {
		return examinationDAO.findPagingResult(criteria);
	}

	/**
	 * 获取已考次数，状态不为'考试中'(S)
	 * @param exam
	 * @return Integer
	 */
	public Integer findMaxByTimes(Examination exam){
		ExamineesHistory eHistory = new ExamineesHistory();
		eHistory.setExaminationId(exam.getId());
		eHistory.setUserId(getUserId());
		eHistory.setAtyPaperId(exam.getAtyPaperId());
		return examineesHistoryDAO.findMaxByTimes(eHistory);
	}
	/**
	 * 判断当前考试活动次数是否已达到，到了return true,没到return false
	 * 
	 * @param exam
	 * @return boolean
	 */
	public boolean getExaminationRestraintNumber(Examination exam) {
		if (exam != null) {
			ExamineesHistory eHistory = new ExamineesHistory();
			eHistory.setExaminationId(exam.getId());
			eHistory.setUserId(getUserId());
			eHistory.setAtyPaperId(exam.getAtyPaperId());
			Integer count = examineesHistoryDAO.findMaxByTimes(eHistory);//已考次数
			if(count == null || count == 0){
				return false;
			}
			int reexam = exam.getReexamTimes() == null ? 0 : exam.getReexamTimes();//总次数
			if (count >= reexam) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断当前时间是否超过了迟到时间，超过了return true,没超过return false
	 * 
	 * @param time
	 * @param advanceTime
	 * @return boolean
	 */
	public boolean getAdvanceTime(Time time, Long advanceTime) {
		if (advanceTime <= 0) {
			return false;
		}
		if (time != null) {
			// 考试开始时间 + 迟到时间 <
			if (getCurrTime().getTime() - time.getTime() <= advanceTime * 60000) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取最后一次考试记录
	 * @param examHistory
	 * @return Integer
	 */
	public Integer findLastByTimes(ExamineesHistory examHistory){
		return examineesHistoryDAO.findLastByTimes(examHistory);
	}
	
	/**
	 * 获取已经填写了答案的题目数量
	 * 
	 * @param exam
	 * @return Integer
	 */
	public Integer findExamAnswerQuestionCount(Examination exam) {
		ExamineesHistory eHistory = new ExamineesHistory();
		eHistory.setAtyPaperId(exam.getAtyPaperId());
		eHistory.setExaminationId(exam.getId());
		eHistory.setUserId(this.getUserId());
		Integer maxTime = findLastByTimes(eHistory);// 查询最大次数的考试记录
		eHistory.setTimes(maxTime);
		return examineeQuestionDAO.findExamAnswerQuestionCount(eHistory);// 查询当前正在考试的填写了答案的数量
	}

	/**
	 * 判断当前系统时间能不能交卷
	 * 
	 * @param examId
	 * @return boolean
	 */
	public boolean advancePutExam(Examination exam) {
		if (exam != null) {
			ExamineesHistory examineesHistory = getLastExam(exam);
			if (exam != null && examineesHistory != null) {
				System.out.println("1 "+exam.getOverdueTime());
				Long advanceTime = exam.getOverdueTime();// 提前交卷时间
				System.out.println("2 "+advanceTime);
				if (advanceTime == null || advanceTime <= 0) {
					return true;
				}
				advanceTime = advanceTime * 60000;
				System.out.println("3 "+advanceTime);

				Long endTime = ExamUtil.formatDate(examineesHistory.getEndTime());// 考试结束时间
				System.out.println("4 "+endTime);
				Long curTime = ExamUtil.formatDate(new Date());//当前系统时间
				System.out.println("5 "+curTime);
				if(endTime != null && curTime != null){
					return curTime >= endTime - advanceTime;
				}
			}
		}
		return true;
	}

	/**
	 * 设置考试活动的已考次数
	 * 
	 * @param examination
	 */
	public void setExamSurplusNumber(Examination examination) {
		if (examination != null) {
			ExamineesHistory examHistory = new ExamineesHistory();
			examHistory.setExaminationId(examination.getId());
			examHistory.setAtyPaperId(examination.getAtyPaperId());
			examHistory.setUserId(getUserId());
			Integer times = examineesHistoryDAO.findMaxByTimes(examHistory);
			times = times == null ? 0 : times;
			examination.setTimes(times);
		}
	}


	/**
	 * 获取可以参加的考试活动
	 * 
	 * @return List<Examination>
	 */
	public PagingResult<Examination> getCanExamRecord() {
		CriteriaBuilder cb = Cnd.builder(Examination.class)
		.addParam("userId", getUserId())
		.addParam("currentDate", new Date());
		PagingResult<Examination> list = examinationDAO.findUserByExamination(cb.buildCriteria());
		for (Examination examination : list.getResult()) {
			setExamSurplusNumber(examination);// 设置考试活动的已考次数
		}
		return list;
	}

	/**
	 * 获取已经结束的考试活动记录
	 * 
	 * @return List<Examination>
	 */
	public PagingResult<Examination> getAlreadyExamRecord() {
		CriteriaBuilder cb = Cnd.builder(Examination.class)
		.addParam("userId", getUserId())
		.addParam("currentDate", new Date());
		PagingResult<Examination> list = examinationDAO.findUserByExamination(cb.buildCriteria());
		for (Examination examination : list.getResult()) {
			setExamSurplusNumber(examination);// 设置考试活动的已考次数
		}
		return list;
	}

	/**
	 * 判断当前系统时间是否在两次考试的间隔时间之外，如果是return true, 否则返回false
	 * 
	 * @return boolean
	 */
	public boolean estimateReexamTimeInterval(Examination exam) {
		if (exam != null) {
			Integer reexamTime = exam.getReexamTimeInterval();// 考试时长
			if (reexamTime == null || reexamTime <= 0) {
				return true;
			}
			Long longTime = (long) reexamTime;
			longTime = longTime * 60000;

			ExamineesHistory examineesHistory = getLastExam(exam);
			if (examineesHistory != null) {
				Date endDate = examineesHistory.getEndTime();// 最后一次考试记录的结束时间
				if (endDate != null) {
					return new Date().getTime() > endDate.getTime() + longTime;
				}
			} else {
				return true;// 考试记录为空就是还没考过一次
			}
		}
		return false;
	}

	/**
	 * 当前系统时间对象的Time
	 * 
	 * @return Time
	 */
	public Time getCurrTime() {
		Date currentDate = new Date();// 当前系统日期
		DateFormat dFormat = DateFormat.getTimeInstance();
		return Time.valueOf(dFormat.format(currentDate));// 具体系统时间
	}

	/**
	 * 考试活动是否已经结束,已经结束返回true,没有结束返回false
	 * 
	 * @return boolean
	 */
	public boolean ifExamActivityEnd(Examination examination) {
		if (examination != null) {
			// 已考次数等于考试总次数就为已考活动记录
			int times = examination.getTimes();// 已考次数
			// int resNumber = examination.getAtyRestraintTimes();//考试次数
			int resNumber = 0;
			if (examination.getReexamTimes() == null) {
				examination.setReexamTimes(0);
			} else {
				resNumber = examination.getReexamTimes();
			}

			if (times >= resNumber) {
				return true;
			}

			// 判断当前日期在结束日期之后为已考活动记录
			Period period = periodService.getPeriodByFlagId(examination.getId(), ObjectType.A_XN);
			if (period != null && period.getEndDate() != null) {
				boolean a = periodService.equalsBefore(period.getEndDate(), new Date());
				// boolean b =
				// periodService.beforeTimes(period.getEndTime(),getCurrTime());
				if (!a) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 根据名称查找考试活动
	 * 
	 * @param examName
	 * @return List<Examination>
	 */
	public List<Examination> findExamByName(String examName, String examType) {
		List<Examination> listExam = new ArrayList<Examination>();
		PagingResult<Examination> list = null;
		if (StringUtils.equals(ActivityConstant.EXAM_AVAILABILITY_RECORD, examType)) {
			list = getCanExamRecord();
		} else if (StringUtils.equals(ActivityConstant.EXAM_INEFFICACY_RECORD, examType)) {
			list = getAlreadyExamRecord();
		}
		String regex = ".*" + examName + ".*";
		for (Examination examination : list.getResult()) {
			if (examination.getName().matches(regex)) {
				listExam.add(examination);
			}
		}
		return listExam;
	}

	/**
	 * 根据userId 查找学员所有的考试活动
	 * 
	 * @return
	 */
	public List<Examination> findUserByExaminationInfo() {
		long userId = this.getUserId();
		CriteriaBuilder examinationCb = Cnd.builder(Examination.class)
		.addParam("userId", userId)
		.addParam("currentDate", new Date());
		PagingResult<Examination> examList = examinationDAO.findUserByExamination(examinationCb.buildCriteria());
		List<Examination> examinationList = new ArrayList<Examination>();
		ExamineesHistory examHistory = new ExamineesHistory();
		for (Examination exam : examList.getResult()) {
			examHistory.setUserId(userId);
			examHistory.setExaminationId(exam.getId());
			examHistory.setAtyPaperId(exam.getAtyPaperId());
			ExamineesHistory examHis = examineesHistoryDAO.findListByExaminationId(examHistory);
			Integer times = 0;
			if (null != examHis) {
				times = examHis.getTimes();
				if (null == times) {
					times = 0;
				}
				// 判断当考生次数已用完的时候 更新最后一次考试试卷状态为（"E"）
				if (times == exam.getAtyRestraintTimes()) {
					examHistory.setTimes(times);
					examHistory.setStatus(ExamConstant.EXAM_QUES_STATUS_E);
					CriteriaBuilder cb = Cnd.builder(ExamineesHistory.class).andEQ("userId", userId).andEQ("atyPaperId", exam.getAtyPaperId())
							.andEQ("examinationId", exam.getId()).andEQ("id", examHis.getId());
					examineesHistoryDAO.updateByCriteria(examHistory, cb.buildCriteria());
				} else {
					if (ExamConstant.EXAM_QUES_STATUS_S.equals(examHis.getStatus())) {
						examHistory.setTimes(times);
						examHistory.setId(examHis.getId());
						examHistory.setStatus(ExamConstant.EXAM_QUES_STATUS_E);
						CriteriaBuilder cb = Cnd.builder(ExamineesHistory.class).andEQ("userId", userId).andEQ("atyPaperId", exam.getAtyPaperId())
								.andEQ("examinationId", exam.getId()).andEQ("id", examHis.getId());
						examineesHistoryDAO.updateByCriteria(examHistory, cb.buildCriteria());
					}
				}
			} else {
				times = examineesHistoryDAO.findMaxByTimes(examHistory);
				if (null == times) {
					times = 0;
				}
			}
			exam.setExamSurplusNumber(times);
			examinationList.add(exam);
		}
		return examinationList;
	}

	// 处理 得到userId
	protected long getUserId() {
		UserAccount userAccount = (UserAccount) SecurityUtils.getCurrentUser();
		return userAccount.getId();
	}

	/**
	 * 发布考试
	 * @param examination	考试对象
	 * @param isPublished	 考试是否已发布
	 */
	public int publish(Examination examination, boolean isPublished) {
		int count = 0;
		if (null != examination) {
			examination = examinationDAO.get(examination.getId());
			if (!isPublished) {
				// 判断要发布的考试，如果没有学员，或者试卷中包含有人工阅卷的题目但没有配置阅卷员，则不允许发布
				int learners = enrollLearnerDAO.countByCriteria(Cnd.builder(EnrollLearner.class).andEQ("activityId", examination.getId()).buildCriteria());
				if (learners == 0) { // 学员列表为空
					throw Exceptions.createAppException("aty001001");
				}

//				CriteriaBuilder cb = Cnd.builder(TestGroup.class);
//				cb.andEQ("readingType", "M");
//				cb.andEQ("examPaperId", examination.getAtyPaperId());
//				int groups = testGroupDAO.countByCriteria(cb.buildCriteria());
//				if (groups > 0) { // 试卷中包含有人工阅卷
//					int markers = enrollExamWorkerDAO.countByCriteria(Cnd.builder(EnrollExamWorker.class).andEQ("activityId", examination.getId())
//							.andLike("workType", "M").buildCriteria());
//					if (markers == 0) { // 阅卷员列表为空
//						throw Exceptions.createAppException("aty001003");
//					}
//				}
//				if(StringUtils.isNotEmpty(examination.getMarkingCheck())){
//					if ("Y".equals(examination.getMarkingCheck())) {
//						int marcont = enrollExamWorkerDAO.countByCriteria(Cnd.builder(EnrollExamWorker.class).andEQ("activityId", examination.getId())
//								.andLike("workType", "A").buildCriteria());
//						if (marcont == 0) {
//							throw Exceptions.createAppException("aty001007");
//						}
//					}
//				}

				examination.setPublishStatus(ExamConstant.STATUS_R);
			} else {
				examination.setPublishStatus(ExamConstant.STATUS_P);
			}
			//count = examinationDAO.updateByCriteria(examination, Cnd.builder(Examination.class).andEQ("id", examination.getId()).buildCriteria());
			count = examinationDAO.update(examination);
			
			ActivityDetails activityDetails = new ActivityDetails();
			activityDetails.setGrade(null);
			activityDetails.setOnlineNumber(null);
			activityDetails.setReleaseStauts(examination.getPublishStatus());
			activityDetails.setReleaseDate(new Date());
			count += activityDetailsDAO.updateByCriteria(activityDetails, 
					Cnd.builder(ActivityDetails.class)
					.andEQ("activityId", examination.getId()).andEQ("type", ObjectType.A_XN).andEQ("recordStatus", RecordStatus.ACTIVE)
					.buildCriteria()
			);
		}
		return count;
	}

	/**
	 * 获取当前考试活动最后一次的考试记录
	 * 
	 * @param exam
	 * @return Examination
	 */
	public ExamineesHistory getLastExam(Examination exam) {
		if (exam != null) {
			ExamineesHistory examHistory = new ExamineesHistory();
			examHistory.setUserId(getUserId());
			examHistory.setExaminationId(exam.getId());
			examHistory.setAtyPaperId(exam.getAtyPaperId());
			return examineesHistoryDAO.findMaxExaminationExamSurplusNumber(examHistory);
		}
		return null;
	}

	/**
	 * 获取当前考试活动的已考次数
	 * 
	 * @param exam
	 * @return Integer
	 */
	public Integer getTimes(Examination exam) {
		ExamineesHistory examineesHistory = getLastExam(exam);
		if (examineesHistory != null) {
			return examineesHistory.getTimes();
		}
		return 0;
	}

	/**
	 * 查询文件夹名称
	 */
	public String findFolderNameByFolderId(Long folderId) {
		return examinationDAO.findFolderName(folderId);
	}
	
	/**
	 * 获取已经结束的考试活动
	 */
	public PagingResult<Examination> findAlreadyExamByUserId(Criteria criteria) {
		PagingResult<Examination> pagingResult = examinationDAO.findAlreadyExamByUserId(criteria);
		List<Examination> examList = pagingResult.getResult();
		
		// 计算每次考试得分，计分方式：A-按平均分，H-按最高分，L-按最后一次得分
		if (ListUtils.isNotEmpty(examList)) {
			for (Examination exam : examList) {
				String scoringType = exam.getScoringType();
				Float score = 0F;
				if ("A".equals(scoringType) || "H".equals(scoringType)) {	//按平均分或最高分
					score = examineesHistoryDAO.getMaxOrAvgScore(Cnd
							.builder(ExamineesHistory.class)
							.buildCriteria()
							.addParam("scoringType", scoringType)
							.addParam("userId", getUserId())
							.addParam("examinationId", exam.getId())
							.addParam("paperId", exam.getAtyPaperId())
							);
				} else if ("L".equals(scoringType)){						//按最后一次得分
					ExamineesHistory history = examineesHistoryDAO.findByCriteria(Cnd
							.builder(Examination.class).orderBy("createDate", Order.DESC).buildCriteria()
							.addParam("userId", getUserId())
							.addParam("examinationId", exam.getId())
							.addParam("paperId", exam.getAtyPaperId())
							
							).get(0);
					score = history.getScore();
				}
				exam.setFinalScore(score);
			}
		}
		return pagingResult;
	}
	
	
	/**
	 * 获取可以阅卷的考试活动ID
	 * @param map
	 * @return Examination
	 */
	public PagingResult<Examination> findAuswertungExamination(){
		CriteriaBuilder cb = Cnd.builder(Examination.class)
		.addParam("userId", getUserId());
		return examinationDAO.findAuswertungExamination(cb.buildCriteria());
	}
	
	/**
	 * 
	 * @param courseId
	 * @param pager
	 * @return
	 */
	public PagingResult<Examination> findExaminationByPageId(Long paperId) {
    	CriteriaBuilder builder = Cnd.builder(Examination.class);
    	builder.andEQ("atyPaperId", paperId).andEQ("recordStatus", "A");
    	Criteria limit = builder.buildCriteria();
		return findExamination(limit);
	}
}