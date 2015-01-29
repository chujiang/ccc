package com.kingnod.etraining.workflow.service;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>工作留部署相关服务</p>
 * @author binfeng
 *
 */
@Service
public class DeploymentService {
	@Autowired
	private RepositoryService repositoryService;
	
	public void deploy(String name, String... classpathResource){
		DeploymentBuilder builder = repositoryService.createDeployment();
		builder.name(name);
		for(String s : classpathResource){
			builder.addClasspathResource(s);
		}
		builder.deploy();
	}
	
//	public List<Deployment> listDeployment(List<Deployment> deployment){
//		DeploymentQuery query = repositoryService.createDeploymentQuery();
//		int rowCount = (int)query.count();
//		return deployment;
//	}
	
	/**
	 * 删除流程部署
	 * @param deploymentIds
	 * @param cascade 是否级联删除相关流程
	 */
	public void delete(List<String> deploymentIds, boolean cascade){
		for(String s : deploymentIds){
			repositoryService.deleteDeployment(s, cascade);
		}
	}

}
