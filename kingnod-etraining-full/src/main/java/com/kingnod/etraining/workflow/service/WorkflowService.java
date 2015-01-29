package com.kingnod.etraining.workflow.service;

import org.activiti.engine.runtime.ProcessInstance;

/**
 * 工作流相关服务
 * @author binfeng
 *
 */
public interface WorkflowService {

	/**
	 * 启动一个流程
	 * @param processDefinitionKey 流程定义文件的key
	 * @param businessKey 业务对象id
	 * @param type 业务对象类型
	 * @return 流程实例对象
	 */
	<K> ProcessInstance start(String processDefinitionKey, String businessKey, Class<K> type);
	
}
