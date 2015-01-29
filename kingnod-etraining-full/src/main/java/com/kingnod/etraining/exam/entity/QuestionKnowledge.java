package com.kingnod.etraining.exam.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "questionId", type = java.lang.Long.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "QUESTION_ID"), 
  @SelectColumnMapping(property = "knowledgeId", type = java.lang.Long.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "KNOWLEDGE_ID"), 
  @SelectColumnMapping(property = "knowledgeName", type = java.lang.String.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "KNOWLEDGE_NAME"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "UPDATE_DATE"),
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "EXM_QUESTION_KNOWLEDGE", tableAlias = "A", column = "TYPE")
})

    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
public class QuestionKnowledge implements IdEntity<Long>, RecordStatus<Long>, Serializable {
	private static final long serialVersionUID=6766856968144355869L;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Long id;

    /**
     * 试题ID<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.QUESTION_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Long questionId;

    /**
     * 知识点ID<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Long knowledgeId;

    /**
     * 知识点名称<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_NAME
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private String knowledgeName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATOR_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATE_DATE
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATER_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Date updateDate;

    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Question question;

    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private Knowledge knowledge;
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    private String type;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.ID
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 试题ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.QUESTION_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.QUESTION_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Long getQuestionId() {
        return questionId;
    }

    /**
     *  设置: 试题ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.QUESTION_ID
     *
     * @param questionId 试题ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 返回: 知识点ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Long getKnowledgeId() {
        return knowledgeId;
    }

    /**
     *  设置: 知识点ID<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_ID
     *
     * @param knowledgeId 知识点ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setKnowledgeId(Long knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    /**
     * 返回: 知识点名称<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_NAME
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_NAME
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public String getKnowledgeName() {
        return knowledgeName;
    }

    /**
     *  设置: 知识点名称<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.KNOWLEDGE_NAME
     *
     * @param knowledgeName 知识点名称
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName == null ? null : knowledgeName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.RECORD_STATUS
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_COUNT
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATOR_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATOR_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATE_DATE
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATE_DATE
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATER_ID
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATER_ID
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_DATE
     *
     * @返回  ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.EXM_QUESTION_KNOWLEDGE.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-04-15 12:07
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Question getQuestion() {
        return question;
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setQuestion(Question question) {
        this.question = question;
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public Knowledge getKnowledge() {
        return knowledge;
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-15 12:10")
    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}