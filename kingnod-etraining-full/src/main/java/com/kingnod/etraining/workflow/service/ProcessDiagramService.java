package com.kingnod.etraining.workflow.service;

import java.io.InputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 流程图服务
 * @author binfeng
 *
 */
@Service
public class ProcessDiagramService {
	
	@Autowired
	private RepositoryService repositoryService;
	
	public InputStream getProcessDiagram(String processDefinitionId){
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
					.processDefinitionId(processDefinitionId)
					.singleResult();
		return repositoryService.getResourceAsStream(
					pd.getDeploymentId(),
					pd.getDiagramResourceName());
	}

}
