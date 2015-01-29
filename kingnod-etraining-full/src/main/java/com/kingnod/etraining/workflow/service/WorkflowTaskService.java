package com.kingnod.etraining.workflow.service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.activity.entity.WorkFlowApproval;
import com.kingnod.etraining.activity.service.WorkFlowApprovalService;
import com.kingnod.etraining.security.entity.UserAccount;
import com.kingnod.etraining.workflow.WorkflowConstant;
import com.kingnod.etraining.workflow.entity.HistoryEntity;

/**
 * 流程任务相关服务
 * 
 * @author binfeng
 * 
 */
@Service
public class WorkflowTaskService {

	/*@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	protected WorkFlowApprovalService workFlowApprovalService;

	public Task getTaskById(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		return task;
	}

	// 审批记录
	public List<HistoryEntity> getWorkflowRecordList(
			String processInstanceId) {
		List<HistoryEntity> historyEntityList=new ArrayList<HistoryEntity>();
		HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery();
		HistoricTaskInstanceQuery query2=historyService.createHistoricTaskInstanceQuery();
		HistoricProcessInstance process = null;
		List<HistoricTaskInstance> hiTaskList=null;
		try {
			//查询启动人
			process = query.processInstanceId(processInstanceId).singleResult();
			//查询节点审批人
			hiTaskList=query2.processInstanceId(processInstanceId).list();
		} catch (Exception e) {
		}
		for (HistoricTaskInstance historicTaskInstance : hiTaskList) {
			HistoryEntity historyEntity = new HistoryEntity();
			historyEntity.setId(historicTaskInstance.getId());
			historyEntity.setProcessDefinitionId(historicTaskInstance.getProcessDefinitionId());
			historyEntity.setProcessInstanceId(historicTaskInstance.getProcessInstanceId());
			historyEntity.setExecutionId(historicTaskInstance.getExecutionId());
			historyEntity.setName(historicTaskInstance.getName());
			historyEntity.setDescription(historicTaskInstance.getDescription());
			historyEntity.setDeleteReason(historicTaskInstance.getDeleteReason());
			historyEntity.setOwner(historicTaskInstance.getOwner());
			historyEntity.setAssignee(historicTaskInstance.getAssignee());
			historyEntity.setStartTime(historicTaskInstance.getStartTime());
			historyEntity.setEndTime(historicTaskInstance.getEndTime());
			historyEntity.setDurationInMillis(historicTaskInstance.getDurationInMillis());
			historyEntity.setTaskDefinitionKey(historicTaskInstance.getTaskDefinitionKey());
			historyEntity.setPriority(historicTaskInstance.getPriority());
			historyEntity.setDueDate(historicTaskInstance.getDueDate());
			historyEntity.setParentTaskId(historicTaskInstance.getParentTaskId());
			historyEntityList.add(historyEntity);
			
		}
		return historyEntityList;

	}

	*//**
	 * 启动流程
	 * 
	 * @param processName
	 *            流程名
	 * @param pricessId
	 *            编号
	 * @param key
	 * 
	 * 
	 *//*
	public ProcessInstance startProcess(String processName, String pricessId,
			String key,String userId) {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put(processName, pricessId);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key,variableMap);		
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
		for (Task task : tasks) {
			taskService.addCandidateGroup(task.getId(), "7");
			taskService.addCandidateUser(task.getId(), userId);
		}
		return processInstance;
	}
	
	
	*//**
	 * 执行任务
	 * @param userId
	 * @param taksId
	 *//*
	public void operateTask(String userId,String taksId){
		Task task = taskService.createTaskQuery().taskId(taksId).singleResult();
		Map<String, Object> variables = new HashMap<String, Object>();
		UserAccount userDetails = (UserAccount) SecurityUtils.getCurrentUser();
		if(!"".equals(task)){
			 taskService.complete(task.getId());
		}
		if(WorkflowConstant.taskIds.containsKey(task.getParentTaskId())){
			List _taskids= WorkflowConstant.taskIds.get(task.getParentTaskId());
			if(_taskids.contains(task.getId())){
				_taskids.remove(task.getId());
			}
			if(_taskids.size() == 0){
				taskService.complete(task.getParentTaskId());
			}
		}
	}
	

	*//**
	 * 当前任务执行情况
	 * 
	 * @param processInstanceId
	 * @return
	 *//*
	public List<Execution> listExecution(String processInstanceId) {
		List<Execution> exectionList = runtimeService.createExecutionQuery()
				.processInstanceId(processInstanceId).list();
		return exectionList;
	}

	*//**
	 * 查看当前用户
	 * 
	 * @param user
	 * @return
	 *//*
	public List<Task> selectTask(String user) {
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(user).orderByTaskCreateTime().desc().list();// 用户所在组的任务
		tasks.addAll(taskService.createTaskQuery().taskCandidateUser(user).orderByTaskCreateTime().desc().list());
		for (Task task : tasks) {
			taskService.claim(task.getId(), user);// 认领任务，获得用户指定的任务
		}
		tasks = taskService.createTaskQuery().taskAssignee(user)
				.orderByTaskCreateTime().desc().list();
		return tasks;
	}
	
	*//**
	 * 查询当前用户组任务，并且把任务分派给当前用户
	 * @param user
	 * @param group
	 * @return
	 *//*
	public List<Task> selectTaskGroup(String user,String group){
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(group).orderByTaskCreateTime().desc().list(); //查询用户组所在的任务
		for (Task task : tasks) {
			taskService.claim(task.getId(), user);
		}
		return tasks;
	}
	
	public List<HistoryEntity> heTaskUser(String id ){
		List<HistoryEntity> historyEntityList=new ArrayList<HistoryEntity>();
		HistoricTaskInstanceQuery query=historyService.createHistoricTaskInstanceQuery();
		List<HistoricTaskInstance> hiTaskList=query.taskAssignee(id).list();
		for (HistoricTaskInstance historicTaskInstance : hiTaskList) {
			HistoryEntity historyEntity = new HistoryEntity();
			historyEntity.setId(historicTaskInstance.getId());
			historyEntity.setProcessDefinitionId(historicTaskInstance.getProcessDefinitionId());
			historyEntity.setProcessInstanceId(historicTaskInstance.getProcessInstanceId());
//			taskService.getVariable("314", "yijian");
			historyEntity.setExecutionId(historicTaskInstance.getExecutionId());
			historyEntity.setName(historicTaskInstance.getName());
			historyEntity.setDescription(historicTaskInstance.getDescription());
			historyEntity.setDeleteReason(historicTaskInstance.getDeleteReason());
			historyEntity.setOwner(historicTaskInstance.getOwner());
			historyEntity.setAssignee(historicTaskInstance.getAssignee());
			historyEntity.setStartTime(historicTaskInstance.getStartTime());
			historyEntity.setEndTime(historicTaskInstance.getEndTime());
			historyEntity.setDurationInMillis(historicTaskInstance.getDurationInMillis());
			historyEntity.setTaskDefinitionKey(historicTaskInstance.getTaskDefinitionKey());
			historyEntity.setPriority(historicTaskInstance.getPriority());
			historyEntity.setDueDate(historicTaskInstance.getDueDate());
			historyEntity.setParentTaskId(historicTaskInstance.getParentTaskId());
			historyEntityList.add(historyEntity);
			
		}
		return historyEntityList;
	}
	
	*//**
	 * 节点查询
	 * @param execId
	 * @return
	 *//*
	public List<Task> listTask(String execId) {
		List<Task> taskList = taskService.createTaskQuery().executionId(execId)
		.list();
		return taskList;
		
	}
	
	*//**
	 * 具体流程的任务列表
	 * @param processDefinitionId
	 * @return
	 *//*
	public List<ProcessInstance> listProcInst(String processDefinitionId) {
		List<ProcessInstance> procInstList = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionId(processDefinitionId).list();
		return procInstList;
		
	}
	
	
	*//**
	 * 查看流程图
	 * @param execId
	 * @param key
	 * @return
	 *//*
	public ActivityImpl traceProcess(String execId, String key) {
		// 最近版本的流程实例
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery().processDefinitionKey(key)
				.latestVersion().singleResult();

		ProcessDefinitionImpl pdImpl = (ProcessDefinitionImpl) processDefinition;
		String processDefinitionId = pdImpl.getId();// 流程标识

		ProcessDefinitionEntity def = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
				.getDeployedProcessDefinition(processDefinitionId);
		ActivityImpl actImpl = null;
		ExecutionEntity execution = (ExecutionEntity) runtimeService
				.createExecutionQuery().executionId(execId).singleResult();// 执行实例

		String activitiId = null;// 当前实例的执行到哪个节点
		if(execution!=null){
			activitiId = execution.getActivityId();
		}

		List<ActivityImpl> activitiList = def.getActivities();// 获得当前任务的所有节点
		for (ActivityImpl activityImpl : activitiList) {// 存在子流程的循环嵌套------目前只考虑一层嵌套
			String id = activityImpl.getId();
			if (id.equals(activitiId)) {// 获得执行到那个节点
				actImpl = activityImpl;
				break;
			} else if (activityImpl != null
					&& activityImpl.getActivities().size() > 0) {
				List<ActivityImpl> childActivity = activityImpl.getActivities();
				for (ActivityImpl _activity : childActivity) {
					String _id = _activity.getId();
					if (_id.equals(activitiId)) {// 获得执行到那个节点
						actImpl = _activity;
						break;
					}
				}
			}

		}

		return actImpl;

	}

	*//**
	 * 页面图片显示
	 * 
	 * @param name
	 * @return
	 *//*
	public InputStream showImg(String name) {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery().processDefinitionKey(name)
				.latestVersion().singleResult();
		String diagramResourceName = processDefinition.getDiagramResourceName();
		InputStream is = repositoryService.getResourceAsStream(
				processDefinition.getDeploymentId(), diagramResourceName);
		return is;
	}
	
	*//**
	 * 发送邮件
	 * @param task
	 *//*
	public void sendMail(Task task,File file,String mail,String[] array){
    	MimeMessage msg = mailSender.createMimeMessage();
    	try {
    		MimeMessageHelper helper = new MimeMessageHelper(msg, true,
            "UTF-8");
    		 helper.setTo(array);
    		 helper.setFrom(mail);
    		 helper.setSubject(task.getName());
    		 helper.setText("培训计划流程已经运行到:"+task.getName()+"-- 请及时审批");
            if(file!=null){
            	 FileSystemResource fileSource = new FileSystemResource(file
            	            .getPath());
            	 helper.addAttachment(file.getName(), fileSource);
            }
            mailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	*//**
	 * 查询流程是否结束
	 * @param procid 流程实例ID
	 * @return
	 *//*
	public boolean endFlow(String procid){
		HistoricProcessInstance historicProcessInstance=historyService.createHistoricProcessInstanceQuery().processInstanceId(procid).singleResult();
		boolean b=true;
		if(historicProcessInstance.getEndTime()==null){
			b=false;
		}else{
			b=true;
		}
		return b;
	}*/

}
