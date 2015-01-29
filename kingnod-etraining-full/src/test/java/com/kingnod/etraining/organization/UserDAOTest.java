package com.kingnod.etraining.organization;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.spring.SpringTxTestCase;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.entity.User;

@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class UserDAOTest extends SpringTxTestCase {

	@Autowired
	UserDAO userDAO;

	@Test
	public void testFindByCriteria() {
		CriteriaBuilder cb = Cnd.builder(User.class);
		//cb.orLike("A.FULL_NAME", "aa").orLike("A.FULL_NAME", "aa");
		cb.orGroup(Cnd.builder(User.class).orLike("A.FULL_NAME", "aa").orLike("A.FULL_NAME", "aa"));
		cb.orGroup(Cnd.builder(User.class).orLike("A.FULL_NAME", "aa").orLike("A.FULL_NAME", "aa"));
		List list = userDAO.findByCriteria(cb.buildCriteria());
	}

}
