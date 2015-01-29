package com.kingnod.etraining.report.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.LongIdEntity;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.SpringUtils;
/**
 * 考试统计报表信息实体对象
 * @author Sam
 *
 */
@SelectColumnMappings({
  @SelectColumnMapping(property = "examinationId", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "EXAMINATION_ID"), 
  @SelectColumnMapping(property = "examinationName", type = java.lang.String.class, table = "", tableAlias = "A", column = "EXAMINATION_NAME"), 
  @SelectColumnMapping(property = "paperName", type = java.lang.String.class, table = "", tableAlias = "A", column = "PAPER_NAME"), 
  @SelectColumnMapping(property = "paperTotalScore", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "PAPER_TOTAL_SCORE"), 
  @SelectColumnMapping(property = "atyTime", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "ATY_TIME"), 
  @SelectColumnMapping(property = "scoringType", type = java.lang.String.class, table = "", tableAlias = "A", column = "SCORING_TYPE"), 
  @SelectColumnMapping(property = "passScore", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "PASS_SCORE"), 
  @SelectColumnMapping(property = "startDate", type = java.util.Date.class, table = "", tableAlias = "A", column = "START_DATE"), 
  @SelectColumnMapping(property = "allRegisters", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "ALL_REGISTERS"), 
  @SelectColumnMapping(property = "examedCount", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "EXAMED_COUNT"), 
  @SelectColumnMapping(property = "passCount", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "PASS_COUNT"),
  @SelectColumnMapping(property = "avgScore", type = java.math.BigDecimal.class, table = "", tableAlias = "A", column = "AVG_SCORE"),
  @SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "", tableAlias = "A", column = "SITE_ID")
})

@com.kingnod.core.annotation.Generated("2012-05-22 20:17")
public class ExaminationStat extends LongIdEntity{

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_ID
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private BigDecimal examinationId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_NAME
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private String examinationName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.PAPER_NAME
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private String paperName;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.PAPER_TOTAL_SCORE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private BigDecimal paperTotalScore;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.ATY_TIME
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private BigDecimal atyTime;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.SCORING_TYPE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private String scoringType;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.PASS_SCORE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private BigDecimal passScore;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.START_DATE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private Date startDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.ALL_REGISTERS
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private BigDecimal allRegisters;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.EXAMED_COUNT
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private BigDecimal examedCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0508.TTTTTTTTTTT.PASS_COUNT
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    private BigDecimal passCount;
    
    
    private BigDecimal avgScore;
    
    private Long siteId;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_ID
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_ID
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public BigDecimal getExaminationId() {
        return examinationId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_ID
     *
     * @param examinationId null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setExaminationId(BigDecimal examinationId) {
        this.examinationId = examinationId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_NAME
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_NAME
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public String getExaminationName() {
        return examinationName;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.EXAMINATION_NAME
     *
     * @param examinationName null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName == null ? null : examinationName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PAPER_NAME
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.PAPER_NAME
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public String getPaperName() {
        return paperName;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PAPER_NAME
     *
     * @param paperName null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PAPER_TOTAL_SCORE
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.PAPER_TOTAL_SCORE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public BigDecimal getPaperTotalScore() {
        return paperTotalScore;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PAPER_TOTAL_SCORE
     *
     * @param paperTotalScore null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setPaperTotalScore(BigDecimal paperTotalScore) {
        this.paperTotalScore = paperTotalScore;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.ATY_TIME
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.ATY_TIME
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public BigDecimal getAtyTime() {
        return atyTime;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.ATY_TIME
     *
     * @param atyTime null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setAtyTime(BigDecimal atyTime) {
        this.atyTime = atyTime;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.SCORING_TYPE
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.SCORING_TYPE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public String getScoringType() {
        return scoringType;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.SCORING_TYPE
     *
     * @param scoringType null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setScoringType(String scoringType) {
        this.scoringType = scoringType == null ? null : scoringType.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PASS_SCORE
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.PASS_SCORE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public BigDecimal getPassScore() {
        return passScore;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PASS_SCORE
     *
     * @param passScore null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setPassScore(BigDecimal passScore) {
        this.passScore = passScore;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.START_DATE
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.START_DATE
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public Date getStartDate() {
        return startDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.START_DATE
     *
     * @param startDate null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.ALL_REGISTERS
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.ALL_REGISTERS
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public BigDecimal getAllRegisters() {
        return allRegisters;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.ALL_REGISTERS
     *
     * @param allRegisters null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setAllRegisters(BigDecimal allRegisters) {
        this.allRegisters = allRegisters;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.EXAMED_COUNT
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.EXAMED_COUNT
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public BigDecimal getExamedCount() {
        return examedCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.EXAMED_COUNT
     *
     * @param examedCount null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setExamedCount(BigDecimal examedCount) {
        this.examedCount = examedCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PASS_COUNT
     *
     * @返回  ETRAINING_0508.TTTTTTTTTTT.PASS_COUNT
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public BigDecimal getPassCount() {
        return passCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0508.TTTTTTTTTTT.PASS_COUNT
     *
     * @param passCount null
     *
     * @mbggenerated 2012-05-22 20:45
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-22 20:17")
    public void setPassCount(BigDecimal passCount) {
        this.passCount = passCount;
    }

	public void setAvgScore(BigDecimal avgScore) {
		this.avgScore = avgScore;
	}

	public BigDecimal getAvgScore() {
		return avgScore;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getSiteId() {
		return siteId;
	}
	
	public String getFormattedStartDateString() {
		if (startDate == null)
			return SpringUtils.getMessage("rpt.examinationStat_nodate");
		return DateUtils.format(startDate, DateUtils.F_YYYY_MM_DD);
	}
	
	public String getScrollingTypeString() {
		String msgKey = "";
		if (StringUtils.equals(scoringType,"A")) {
			msgKey = "exm.scoringType_A";
		} else if (StringUtils.equals(scoringType,"L")) {
			msgKey = "exm.scoringType_L";
		} else {
			msgKey = "exm.scoringType_H";
		}
		return SpringUtils.getMessage(msgKey);
	}
}