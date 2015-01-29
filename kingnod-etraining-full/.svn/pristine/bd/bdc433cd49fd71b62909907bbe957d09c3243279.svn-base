package com.kingnod.etraining.resource.dao;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.resource.entity.Trainer;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-13 12:55")
public class TrainerDAOImpl extends MybatisEntityDAO<Trainer, Long> implements TrainerDAO {

	public Trainer getTrainerById(Long id){
		return (Trainer) this.getSqlSession().selectOne("findTrainerById", id);
	}
}