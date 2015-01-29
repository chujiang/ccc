package com.kingnod.etraining.exam.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "questionId", type = java.lang.Long.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "QUESTION_ID"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "answerIndex", type = java.lang.Long.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "ANSWER_INDEX"), 
  @SelectColumnMapping(property = "itemSeq", type = java.lang.Long.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "ITEM_SEQ"), 
  @SelectColumnMapping(property = "itemContent", type = java.lang.String.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "ITEM_CONTENT"), 
  @SelectColumnMapping(property = "correct", type = java.lang.Boolean.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "CORRECT"), 
  @SelectColumnMapping(property = "score", type = java.lang.Float.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "SCORE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "itemContent2", type = java.lang.String.class, table = "EXM_QUESTION_ANSWER", tableAlias = "A", column = "ITEM_CONTENT2")
})

    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
public class QuestionAnswer implements IdEntity<Long>, RecordStatus<Long>, Serializable {
private static final long serialVersionUID=2471593913983222663L;
private Integer right;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Long id;

    /**
     * 试题ID<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.QUESTION_ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Long questionId;

    /**
     * 试题答案类型，R:单选， C：多选， T：填空， A：多行， B: 判断<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.TYPE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private String type;

    /**
     * 表示试题的第几个题问<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.ANSWER_INDEX
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Long answerIndex;

    /**
     * 试题答案选项顺序<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_SEQ
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Long itemSeq;

    /**
     * 试题答案选项内容<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private String itemContent;

    /**
     * 是否是正确答案<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.CORRECT
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Boolean correct;

    /**
     * 答对得分<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.SCORE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Float score;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.RECORD_STATUS
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.CREATOR_ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.CREATE_DATE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATER_ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_DATE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private Date updateDate;

    /**
     * 试题答案选项内容的扩充，当答案内容过长时，用该字段存储数据<br/>
     * 对应数据库字段 ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT2
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private String itemContent2;

public Integer getRight(){
  return right;
}
public void setRight(Integer right){
  this.right=right;
}

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ID
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 试题ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.QUESTION_ID
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.QUESTION_ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Long getQuestionId() {
        return questionId;
    }

    /**
     *  设置: 试题ID<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.QUESTION_ID
     *
     * @param questionId 试题ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * 返回: 试题答案类型，R:单选， C：多选， T：填空， A：多行， B: 判断<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.TYPE
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.TYPE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public String getType() {
        return type;
    }

    /**
     *  设置: 试题答案类型，R:单选， C：多选， T：填空， A：多行， B: 判断<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.TYPE
     *
     * @param type 试题答案类型，R:单选， C：多选， T：填空， A：多行， B: 判断
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 返回: 表示试题的第几个题问<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ANSWER_INDEX
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.ANSWER_INDEX
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Long getAnswerIndex() {
        return answerIndex;
    }

    /**
     *  设置: 表示试题的第几个题问<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ANSWER_INDEX
     *
     * @param answerIndex 表示试题的第几个题问
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setAnswerIndex(Long answerIndex) {
        this.answerIndex = answerIndex;
    }

    /**
     * 返回: 试题答案选项顺序<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_SEQ
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_SEQ
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Long getItemSeq() {
        return itemSeq;
    }

    /**
     *  设置: 试题答案选项顺序<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_SEQ
     *
     * @param itemSeq 试题答案选项顺序
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setItemSeq(Long itemSeq) {
        this.itemSeq = itemSeq;
    }

    /**
     * 返回: 试题答案选项内容<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public String getItemContent() {
        return itemContent;
    }

    /**
     *  设置: 试题答案选项内容<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT
     *
     * @param itemContent 试题答案选项内容
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }

    /**
     * 返回: 是否是正确答案<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.CORRECT
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.CORRECT
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Boolean getCorrect() {
        return correct;
    }

    /**
     *  设置: 是否是正确答案<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.CORRECT
     *
     * @param correct 是否是正确答案
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    /**
     * 返回: 答对得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.SCORE
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.SCORE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Float getScore() {
        return score;
    }

    /**
     *  设置: 答对得分<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.SCORE
     *
     * @param score 答对得分
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.RECORD_STATUS
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.RECORD_STATUS
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_COUNT
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_COUNT
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.CREATOR_ID
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.CREATOR_ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.CREATE_DATE
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.CREATE_DATE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATER_ID
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATER_ID
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_DATE
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_DATE
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 试题答案选项内容的扩充，当答案内容过长时，用该字段存储数据<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT2
     *
     * @返回  ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT2
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public String getItemContent2() {
        return itemContent2;
    }

    /**
     *  设置: 试题答案选项内容的扩充，当答案内容过长时，用该字段存储数据<br>
     * 对应数据库字段: ETRAINING_0426.EXM_QUESTION_ANSWER.ITEM_CONTENT2
     *
     * @param itemContent2 试题答案选项内容的扩充，当答案内容过长时，用该字段存储数据
     *
     * @mbggenerated 2012-05-02 19:18
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public void setItemContent2(String itemContent2) {
        this.itemContent2 = itemContent2 == null ? null : itemContent2.trim();
    }
}