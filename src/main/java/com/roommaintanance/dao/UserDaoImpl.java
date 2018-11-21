package com.roommaintanance.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roommaintanance.model.AppUser;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public AppUser findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public AppUser findByUserName(String userName) {
		AppUser userDetails = null;
		Criteria criteria = sessionFactory.openSession().createCriteria(AppUser.class);
		criteria.add(Restrictions.eq("appUserName", userName));
		List<AppUser> entityList = criteria.list();
		if(!entityList.isEmpty()) {
			userDetails = entityList.get(0);
		}
		return userDetails;
	}

	public void saveUserDetails(UploadFile uploadFile) {
		 sessionFactory.getCurrentSession().save(uploadFile);
		
	}

}
