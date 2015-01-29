package com.kingnod.etraining.common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.common.service.AttachmentService;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AttachmentService attachmentService;

	public UploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		attachmentService.uploadAttachment(request, response);
	}

	public void init() throws ServletException {
		super.init();
		attachmentService = SpringUtils.getBean(AttachmentService.class);
	}
}
