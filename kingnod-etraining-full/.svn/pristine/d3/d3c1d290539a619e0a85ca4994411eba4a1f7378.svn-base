package com.kingnod.etraining.activity.dao;

import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Examination;

@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
public interface ExaminationDAO extends EntityDAO<Examination, Long> {
	/**
	 * 根据userId 查找学员可以参加的考试
	 * 
	 * @return
	 */
	PagingResult<Examination> findUserByExamination(Criteria criteria);

	/**
	 * 查询文件夹名称
	 * @param folderId
	 * @return
	 */
	String findFolderName(Long folderId);
	
	/**
	 * findExaminationById
	 * @param examId
	 * @return Examination
	 */
	Examination findExaminationById(Long examId);

	/**
	 * 根据userId查询已完成考试
	 * @param criteria
	 * @return
	 */
	PagingResult<Examination> findAlreadyExamByUserId(Criteria criteria);
	
	/**
	 * 获取可以阅卷的考试活动ID
	 * @param map
	 * @return Examination
	 */
	PagingResult<Examination> findAuswertungExamination(Criteria criteria);
	
	/**
	 * 根据考试ids获取已发布考试的数量，如果存在已发布考试，则无法删除
	 * @return
	 */
	int countPublishedByIds(String ids);

}