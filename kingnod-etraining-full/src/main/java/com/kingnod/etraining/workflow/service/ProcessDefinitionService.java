package com.kingnod.etraining.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 流程定义相关服务
 * @author binfeng
 *
 */
@Service
public class ProcessDefinitionService {
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private HistoryService historyService;
	
	public List<Map<String, String>> getDefinitions(){
		List<Map<String, String>> ret = null;
		ProcessDefinitionQuery pdQuery = repositoryService.createProcessDefinitionQuery();
		HistoricProcessInstanceQuery hQuery = historyService.createHistoricProcessInstanceQuery();
		List<ProcessDefinition> processDefinitionList = pdQuery.orderByProcessDefinitionName().asc().list();
		ret = new Vector<Map<String,String>>();
		for (ProcessDefinition processDefinition : processDefinitionList) {
			HashMap<String, String> map = new HashMap<String, String>();
			long count = hQuery.processDefinitionId(processDefinition.getId()).count();
			map.put("id", processDefinition.getId());
			map.put("name", processDefinition.getName());
			map.put("key", processDefinition.getKey());
			map.put("deploymentId", processDefinition.getDeploymentId());
			map.put("resourceName", processDefinition.getResourceName());
			map.put("diagramResourceName", processDefinition.getDiagramResourceName());
			map.put("version", String.valueOf(processDefinition.getVersion()));
			map.put("category", processDefinition.getCategory());
			map.put("count", String.valueOf(count));
			ret.add(map);
		}
		return ret;
		
	}

}
