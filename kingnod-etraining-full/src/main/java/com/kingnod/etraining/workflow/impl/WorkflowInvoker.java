package com.kingnod.etraining.workflow.impl;

import org.activiti.engine.ProcessEngine;

/**
 * 通过参数指定命令直接执行
 * @author Administrator
 *
 */
public class WorkflowInvoker {
	
	private ProcessEngine engine;
	
	public <T> T action(WorkflowCommand<T> command){
		return command.execute(engine);
	}

	public void setEngine(ProcessEngine engine) {
		this.engine = engine;
	}

}
