package com.kingnod.etraining.activity.service.impl;

import org.springframework.context.annotation.Lazy;

@org.springframework.stereotype.Service
@Lazy(false)
public class TrainingPlanServiceImpl /*implements TrainingPlanService, TrainingPlanItemService, TrainingPlanItemCostService, InitializingBean*/ {

	/*@Autowired
	protected TrainingPlanDAO trainingPlanDAO;
	@Autowired
	protected TrainingPlanItemDAO trainingPlanItemDAO;
	@Autowired
	protected TrainingPlanItemCostDAO trainingPlanItemCostDAO;

	@Autowired
	protected RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;
	@Autowired
	protected WorkFlowApprovalService workFlowApprovalService;
	@Autowired
	protected RepositoryService repositoryService;
	@Autowired
	protected WorkflowTaskService workflowTaskService;
	@Autowired
	protected WokflowBusinessDAO wokflowBusinessDAO;

	// 将邮件页面的参数按照map的形式放入
	private Map<String, String> parameters = new HashMap<String, String>();

	public TrainingPlan getTrainingPlan(Long id) {
		return trainingPlanDAO.get(id);
	}

	public int saveTrainingPlan(TrainingPlan trainingPlan) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) trainingPlan;
		if (null != idEntity.getId() && null != trainingPlanDAO.get(idEntity.getId())) {
			count = trainingPlanDAO.update(trainingPlan);
		} else {
			count = trainingPlanDAO.insert(trainingPlan);
		}
		return count;
	}

	public int deleteTrainingPlan(TrainingPlan trainingPlan) {
		return trainingPlanDAO.delete(trainingPlan);
	}

	public int deleteTrainingPlanByIds(Long[] ids) {
		return trainingPlanDAO.deleteById(ids);
	}

	public PagingResult<TrainingPlan> findTrainingPlan(Criteria criteria) {
		return trainingPlanDAO.findPagingResult(criteria);
	}

	public TrainingPlanItem getTrainingPlanItem(Long id) {
		return trainingPlanItemDAO.get(id);
	}

	public int saveTrainingPlanItem(TrainingPlanItem trainingPlanItem) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) trainingPlanItem;
		if (null != idEntity.getId() && null != trainingPlanItemDAO.get(idEntity.getId())) {
			count = trainingPlanItemDAO.update(trainingPlanItem);
			TrainingPlan trainingPlan=getTrainingPlan(trainingPlanItem.getTrainingPlanId());
			trainingPlan.setLearnerNumber(sumLearnerNumberByCriteria(trainingPlanItem.getTrainingPlanId()));
			trainingPlanDAO.update(trainingPlan);
		} else {
			count = trainingPlanItemDAO.insert(trainingPlanItem);
			TrainingPlan trainingPlan=getTrainingPlan(trainingPlanItem.getTrainingPlanId());
			trainingPlan.setLearnerNumber(sumLearnerNumberByCriteria(trainingPlanItem.getTrainingPlanId()));
			trainingPlanDAO.update(trainingPlan);
		}
		return count;
	}

	public int deleteTrainingPlanItem(TrainingPlanItem trainingPlanItem) {
		return trainingPlanItemDAO.delete(trainingPlanItem);
	}

	public int deleteTrainingPlanItemByIds(Long[] ids) {
		return trainingPlanItemDAO.deleteById(ids);
	}

	public PagingResult<TrainingPlanItem> findTrainingPlanItem(Criteria criteria) {
		return trainingPlanItemDAO.findPagingResult(criteria);
	}

	public TrainingPlanItemCost getTrainingPlanItemCost(Long id) {
		return trainingPlanItemCostDAO.get(id);
	}

	public int saveTrainingPlanItemCost(TrainingPlanItemCost trainingPlanItemCost) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) trainingPlanItemCost;
		if (null != idEntity.getId() && null != trainingPlanItemCostDAO.get(idEntity.getId())) {
			count = trainingPlanItemCostDAO.update(trainingPlanItemCost);
		} else {
			count = trainingPlanItemCostDAO.insert(trainingPlanItemCost);
		}
		return count;
	}

	public int deleteTrainingPlanItemCost(TrainingPlanItemCost trainingPlanItemCost) {
		return trainingPlanItemCostDAO.delete(trainingPlanItemCost);
	}

	public int deleteTrainingPlanItemCostByIds(Long[] ids) {
		return trainingPlanItemCostDAO.deleteById(ids);
	}

	public PagingResult<TrainingPlanItemCost> findTrainingPlanItemCost(Criteria criteria) {
		return trainingPlanItemCostDAO.findPagingResult(criteria);
	}

	*//**
	 * 启动培训计划流程
	 *//*
	public void release(Long id) {
		TrainingPlan trainingPlan = trainingPlanDAO.get(id);
		if ("P".equals(trainingPlan.getStatus())) {
			trainingPlan.setStatus("C");
			UserAccount userDetails = (UserAccount) SecurityUtils.getCurrentUser();
			// 启动流程
			ProcessInstance processInstance = workflowTaskService.startProcess(ActivityConstant.WORK_FLOW_TYPE, String.valueOf(id), "WorkFlowTest",
					String.valueOf(userDetails.getId()));
			WokflowBusiness wokflowBusiness = new WokflowBusiness();
			wokflowBusiness.setBusinessType(ActivityConstant.WORK_FLOW_TYPE);
			wokflowBusiness.setBusinessId(String.valueOf(id));
			wokflowBusiness.setWorkflowId(processInstance.getId());
			wokflowBusinessDAO.insert(wokflowBusiness);
			trainingPlanDAO.update(trainingPlan);
			HtmlToPdfReport htmlPdf=new HtmlToPdfReport();
			htmlPdf.htmlToPdf(RepotConstant.HTML_SRC+"?id="+id, ActivityConstant.WORK_FLOW_TYPE+"_"+id+".pdf");
		}
	}

	public void operateTask(String taskId,String approvalOpinion,String remarks,String approvalType) {
		UserAccount userDetails = (UserAccount) SecurityUtils.getCurrentUser();
		String[] array = new String[] {"binfeng@kingnode.com" };
		Task task = null;//taskService.createTaskQuery().taskId(taskId).singleResult();
		workflowTaskService.operateTask(String.valueOf(userDetails.getId()), taskId);
		WorkFlowApproval workFlowApproval=new WorkFlowApproval();
		workFlowApproval.setTaskKey(task.getTaskDefinitionKey());
		workFlowApproval.setApprovalPeople(String.valueOf(userDetails.getId()));
		Date date=new Date();
		workFlowApproval.setApprovalDatetime(date);
		workFlowApproval.setApprovalType(approvalType);
		workFlowApproval.setApprovalOpinion(approvalOpinion);
		workFlowApproval.setWorkflowId(task.getProcessInstanceId());
		workFlowApproval.setRemarks(remarks);
		workFlowApproval.setFilePath("C://aa.text");
		CriteriaBuilder cb = Cnd.builder(WokflowBusiness.class);
		cb.andEQ("workflowId", task.getProcessInstanceId()).andEQ("businessType", ActivityConstant.WORK_FLOW_TYPE);
		List<WokflowBusiness> wokflowBusinessList = wokflowBusinessDAO.findByCriteria(cb.buildCriteria());
		boolean b=workflowTaskService.endFlow(wokflowBusinessList.get(0).getWorkflowId());
		workFlowApprovalService.saveWorkFlowApproval(workFlowApproval);
		workflowTaskService.sendMail(task, null, userDetails.getEmail(), array);
		if(b){
			TrainingPlan trainingPlan = trainingPlanDAO.get(Long.valueOf(wokflowBusinessList.get(0).getBusinessId()));
			trainingPlan.setStatus("R");
			trainingPlanDAO.update(trainingPlan);
		}
		
	}

	public List<MyTask> selectTask() {
		UserAccount userDetails = (UserAccount) SecurityUtils.getCurrentUser();
		List<Task> taskList = null;
		List<Task> taskList1 = workflowTaskService.selectTask(String.valueOf(userDetails.getId()));
		List<Task> taskList2 = workflowTaskService.selectTaskGroup(String.valueOf(userDetails.getId()), "7");
		if (taskList1.size() <= 0) {
			taskList = taskList2;
		} else if (taskList2.size() <= 0) {
			taskList = taskList1;
		}
		List<MyTask> myTaskList = new ArrayList<MyTask>();
		for (Task task : taskList1) {
			MyTask myTask = new MyTask();
			CriteriaBuilder cb = Cnd.builder(WokflowBusiness.class);
			cb.andEQ("workflowId", task.getExecutionId());
			List<WokflowBusiness> wokflowBusinessList = wokflowBusinessDAO.findByCriteria(cb.buildCriteria());
			if(!"".equals(wokflowBusinessList)){
			myTask.setId(task.getId());
			myTask.setName(task.getName());
			myTask.setDescription(task.getDescription());
			myTask.setPriority(task.getPriority());
			myTask.setOwner(task.getOwner());
			myTask.setAssignee(task.getAssignee());
			myTask.setDelegationState(task.getDelegationState());
			myTask.setProcessInstanceId(task.getProcessInstanceId());
			myTask.setExecutionId(task.getExecutionId());
			if ("TrainingPlan".equals(wokflowBusinessList.get(0).getBusinessType())) {
				myTask.setTypeName("培训计划");
			}
			TrainingPlan trainingPlan = this.getTrainingPlan(Long.valueOf(wokflowBusinessList.get(0).getBusinessId()));
			myTask.setCreateDate(trainingPlan.getCreateDate());
			myTask.setBusinessName(trainingPlan.getName());
			myTask.setProcessDefinitionId(task.getProcessDefinitionId());
			myTask.setCreateTime(task.getCreateTime());
			myTask.setTaskDefinitionKey(task.getTaskDefinitionKey());
			myTask.setDueDate(task.getDueDate());
			myTask.setParentTaskId(task.getParentTaskId());
			myTaskList.add(myTask);
			}
		}
		return myTaskList;
	}

	*//**
	 * 查询当前流程的审批信息
	 * 
	 * @param id
	 *//*
	public List<HistoryEntity> viewTask(String id) {
		CriteriaBuilder cb = Cnd.builder(WokflowBusiness.class);
		cb.andEQ("businessId", id).andEQ("businessType", ActivityConstant.WORK_FLOW_TYPE);
		List<WokflowBusiness> wokflowBusinessList = wokflowBusinessDAO.findByCriteria(cb.buildCriteria());
		List<HistoryEntity> historyEntityList = null;
		if (wokflowBusinessList.size() > 0) {
			for (WokflowBusiness wokflowBusiness : wokflowBusinessList) {
				historyEntityList = workflowTaskService.getWorkflowRecordList(wokflowBusiness.getWorkflowId());
			}
		}
		return historyEntityList;
	}

	public InputStream showImg(String name) {
		InputStream is = workflowTaskService.showImg("WorkFlowTest");
		return is;
	}

	public ActivityImpl traceProcess(Long id) {
		CriteriaBuilder cb = Cnd.builder(WokflowBusiness.class);
		cb.andEQ("businessId", id).andEQ("businessType", ActivityConstant.WORK_FLOW_TYPE);
		List<WokflowBusiness> wokflowBusinessList = wokflowBusinessDAO.findByCriteria(cb.buildCriteria());
		ActivityImpl actImpl = null;
		if (wokflowBusinessList != null) {
			actImpl = workflowTaskService.traceProcess(wokflowBusinessList.get(0).getWorkflowId(), "WorkFlowTest");
		}
		return actImpl;
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public List<HistoryEntity> heTaskUser() {
		UserAccount userDetails = (UserAccount) SecurityUtils.getCurrentUser();
		List<HistoryEntity> list = workflowTaskService.heTaskUser(String.valueOf(userDetails.getId()));
		return list;
	}

	public int countByTrainingPlanItem(Long id) {
		CriteriaBuilder cb = Cnd.builder(TrainingPlanItem.class);
		cb.andEQ("trainingPlanId", id);
		 int i=trainingPlanItemDAO.countByCriteria(cb.buildCriteria());
		return i;
	}
	
	public List<TrainingPlanItem> findByCriteria(Long id){
		CriteriaBuilder cb = Cnd.builder(TrainingPlanItem.class);
		cb.andEQ("trainingPlanId", id);
		List<TrainingPlanItem> trainingPlanItemList=trainingPlanItemDAO.findByCriteria(cb.buildCriteria());
		return trainingPlanItemList;
		
	}

	public int sumCostByCriteria(Long id) {
		CriteriaBuilder cb = Cnd.builder(TrainingPlanItem.class);
		cb.andEQ("trainingPlanId", id);
		return trainingPlanItemDAO.sumCostByCriteria(cb.buildCriteria());
	}
	
	public int sumLessonsByCriteria(Long id) {
		CriteriaBuilder cb = Cnd.builder(TrainingPlanItem.class);
		cb.andEQ("trainingPlanId", id);
		return trainingPlanItemDAO.sumLessonsByCriteria(cb.buildCriteria());
	}
	
	public int sumLearnerNumberByCriteria(Long id) {
		CriteriaBuilder cb = Cnd.builder(TrainingPlanItem.class);
		cb.andEQ("trainingPlanId", id);
		return trainingPlanItemDAO.sumLearnerNumberByCriteria(cb.buildCriteria());
	}*/
	
	
}
