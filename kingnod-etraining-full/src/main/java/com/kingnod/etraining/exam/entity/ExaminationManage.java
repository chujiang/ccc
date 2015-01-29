package com.kingnod.etraining.exam.entity;

public class ExaminationManage {
	
	private Long exminationId;
	private String exminationName;
	private Integer questionCount;
	
	public ExaminationManage(){}
	public ExaminationManage(Long exminationId, String exminationName,
			Integer questionCount) {
		super();
		this.exminationId = exminationId;
		this.exminationName = exminationName;
		this.questionCount = questionCount;
	}
	public Long getExminationId() {
		return exminationId;
	}
	public String getExminationName() {
		return exminationName;
	}
	public Integer getQuestionCount() {
		return questionCount;
	}
	public void setExminationId(Long exminationId) {
		this.exminationId = exminationId;
	}
	public void setExminationName(String exminationName) {
		this.exminationName = exminationName;
	}
	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

}
