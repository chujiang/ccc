package com.kingnod.etraining.activity.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.entity.TrainingPlan;
import com.kingnod.etraining.activity.entity.TrainingPlanItem;
import com.kingnod.etraining.activity.entity.WorkFlowApproval;
import com.kingnod.etraining.activity.service.TrainingPlanItemService;
import com.kingnod.etraining.activity.service.TrainingPlanService;
import com.kingnod.etraining.activity.service.WorkFlowApprovalService;
import com.kingnod.etraining.workflow.entity.HistoryEntity;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "training-plan", "namespace", "/aty" }),
		@Result(name = "costPieChart", location = "/WEB-INF/content/aty/trainingPlanReports_costPieChart.jsp"),
		@Result(name = "implementChart", location = "/WEB-INF/content/aty/trainingPlanReports_implementChart.jsp"),
		@Result(name = "viewWorkFlow", location = "/WEB-INF/content/aty/trainingPlan_workflow.jsp"),
		@Result(name = "trainingPlanPdf", location = "/WEB-INF/content/aty/trainingPlan-pdf.jsp") })
@com.kingnod.core.annotation.Generated("2012-02-08 15:35")
public class TrainingPlanAction extends FilterableEntityAction<TrainingPlan, Long> {

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-08 15:35")
	private TrainingPlanService trainingPlanService;
	@Autowired
	private TrainingPlanItemService trainingPlanItemService;
	@Autowired
	private WorkFlowApprovalService workFlowApprovalService;

	@com.kingnod.core.annotation.Generated("2012-02-08 15:35")
	public String filterDefines() {
		return "aty.trainingPlanFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-08 15:35")
	protected Object getEntityService() {
		return this.trainingPlanService;
	}

	private String folderId;

	private String dictType;

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String release() throws Exception {
		entity.setStatus(TrainingPlan.STATUS_CHECKING);
		return super.save();
	}

	public String costPieChart() {
		return "costPieChart";

	}

	public String implementChart() {
		return "implementChart";
	}

	public String releases() {
		trainingPlanService.release(entity.getId());
		return EntityAction.RELOAD;
	}

	public String viewWorkFlow() {
		List<HistoryEntity> pager = trainingPlanService.viewTask(String.valueOf(entity.getId()));
		ActivityImpl actImpl = trainingPlanService.traceProcess(entity.getId());
		List<WorkFlowApproval> workFlowApprovalList = workFlowApprovalService.workFlowApprovalList(pager.get(0).getExecutionId());
		String urlpdf = SysParameterUtils.getString("sys.attachment_location");
		request.setAttribute("pdfurl", urlpdf + "/" + ActivityConstant.WORK_FLOW_TYPE + "_" + entity.getId() + ".pdf");
		request.setAttribute("coordinateObj", actImpl);
		request.setAttribute("page", pager);
		request.setAttribute("workFlowApprovalList", workFlowApprovalList);
		return "viewWorkFlow";
	}

	public void showImg() throws IOException {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpg;charset=utf-8;");
		InputStream is = trainingPlanService.showImg("WorkFlowTest");
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = is.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}

		response.flushBuffer();
	}

	public String showLearnerTask() {
		trainingPlanService.release(entity.getId());
		return "learnerTask";

	}

	public String trainingPlanPdf() {
		TrainingPlan trainingPlan = trainingPlanService.getTrainingPlan(entity.getId());
		int count = trainingPlanItemService.countByTrainingPlanItem(entity.getId());
		int sumCost = trainingPlanItemService.sumCostByCriteria(entity.getId());
		int sumLessons = trainingPlanItemService.sumLessonsByCriteria(entity.getId());
		int sumLearnerNumber = trainingPlanItemService.sumLearnerNumberByCriteria(entity.getId());
		List<TrainingPlanItem> trainingPlanItemList = trainingPlanItemService.findByCriteria(entity.getId());
		String organizationName = SysParameterUtils.getString("sys._company_or_organization_name");
		String sysTime = SysParameterUtils.getString("sys.date_format");
		String startTimeStr = DateUtils.format(trainingPlan.getStartTime(), sysTime);
		String endTimeStr = DateUtils.format(trainingPlan.getEntTime(), sysTime);
		request.setAttribute("startTimeStr", startTimeStr);
		request.setAttribute("endTimeStr", endTimeStr);
		request.setAttribute("organizationName", organizationName);
		request.setAttribute("trainingPlan", trainingPlan);
		request.setAttribute("count", count);
		request.setAttribute("sumCost", sumCost);
		request.setAttribute("sumLessons", sumLessons);
		request.setAttribute("sumLearnerNumber", sumLearnerNumber);
		request.setAttribute("trainingPlanItemList", trainingPlanItemList);
		return "trainingPlanPdf";
	}

	public String dowFile() {
		try {
			String url = request.getParameter("url");
			String id = request.getParameter("id");
			String urlpdf = SysParameterUtils.getString("sys.attachment_location");
			if (url == null) {
				url = urlpdf + "/" + ActivityConstant.WORK_FLOW_TYPE + "_" + entity.getId() + ".pdf";
			}
			String outputFile = url;
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			OutputStream fos = null;
			InputStream fis = null;
			try {
				// response.setContentType("application/x-msword");
				response.setHeader("Content-disposition", "attachment;filename=" + "TrainingPlan_22.pdf");
				fis = new FileInputStream(outputFile);
				bis = new BufferedInputStream(fis);
				fos = response.getOutputStream();
				bos = new BufferedOutputStream(fos);
				int bytesRead = 0;
				byte[] buffer = new byte[5 * 1024];
				while ((bytesRead = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
				}
				bos.close();
				bis.close();
				fos.close();
				fis.close();

			} catch (IOException e) {
				response.reset();
				e.printStackTrace();
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
					if (bos != null) {
						bos.close();
					}
					if (fis != null) {
						fis.close();
					}
					if (bis != null) {
						bis.close();
					}
				} catch (IOException e) {

					System.err.print(e);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}