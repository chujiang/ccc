package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;


    @com.kingnod.core.annotation.Generated("2012-02-29 10:15")
public interface QuestionTestGroupService {
void movebleQuestionTestGroup(QuestionTestGroup questionTestGroup);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 10:15")
    QuestionTestGroup getQuestionTestGroup(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 10:15")
    int saveQuestionTestGroup(QuestionTestGroup questionTestGroup);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 10:15")
    int deleteQuestionTestGroup(QuestionTestGroup questionTestGroup);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 10:15")
    int deleteQuestionTestGroupByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-29 10:15")
    PagingResult<QuestionTestGroup> findQuestionTestGroup(Criteria criteria);

    /**
     * 根据testGroupId 与  examPaperId 删除测试区与该测试区下面的试题
     * @param testGroupId
     * @param examPaperId
     * @return
     */
	Integer deletequestionTestGroupByPaperId(Long testGroupId, Long... examPaperId);

	String findFolderNameById(long folderId, String type);
	
	/**
	 * 处理批量添加
	 * @param ids
	 * @param testGroupId
	 * @param examPaperId
	 * @return
	 */
	int batchAdd(Long[] ids, Long testGroupId, Long examPaperId);
}