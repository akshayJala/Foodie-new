package com.foodiespot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodiespot.model.UserDetails;

@Repository("userDetailsDao")
@Transactional
public class UserDetailsDaoImp implements UserDetailsDao {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsDaoImp.class);
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveUserDetails(UserDetails userDetails) {
		logger.info(" saveUserDetails of  UserDetailsDaoImp begins here with user name :" + userDetails.getFullName());
		logger.info(" saveUserDetails of  UserDetailsDaoImp begins here with dob :" + userDetails.getdOB());
		try {
			sessionFactory.getCurrentSession().save(userDetails);
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		logger.info(" saveUserDetails of  UserDetailsDaoImp ends here with user name :" + userDetails.getFullName());
		return true;
	}

	public boolean updateUserDetails(UserDetails userDetails) {
		logger.info(" updateUserDetails of  UserDetailsDaoImp begins here with user name :" + userDetails.getFullName());
		try {
			sessionFactory.getCurrentSession().update(userDetails);
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		logger.info(" updateUserDetails of  UserDetailsDaoImp ends here with user name :" + userDetails.getFullName());
		return true;
	}

	public boolean deleteUserDetails(String userId) {
		try {
			logger.info(" deleteUserDetails of  UserDetailsDaoImp begins here with user Id :" + userId);
			sessionFactory.getCurrentSession().delete(getUserDetails(userId));
		} catch (Exception exception) {
			exception.printStackTrace();

		}
		logger.info(" deleteUserDetails of  UserDetailsDaoImp ends here with user Id :" + userId);
		return true;
	}

	public UserDetails getUserDetails(String userId) {
		logger.info(" getUserDetails of  UserDetailsDaoImp begins here with user Id :" + userId);
		String hql = "from UserDetails where userId = '" + userId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> userdetailList = query.list();
		if (userdetailList == null) {
			logger.info(" getUserDetails of  UserDetailsDaoImp ends here with user Id :" + userId);
			return null;
		} else
			logger.info(" getUserDetails of  UserDetailsDaoImp ends here with user Id :" + userId);
			return userdetailList.get(0);
	}

	public List<UserDetails> UserList() {
		logger.info(" UserList of  UserDetailsDaoImp starts from here !");
		String hql = "from UserDetails";
		List<UserDetails> userdetailList = sessionFactory.getCurrentSession().createQuery(hql).list();
		if (userdetailList == null) {
			return null;
		} else
			logger.info(" UserList of  UserDetailsDaoImp ends here !");
			return userdetailList;
	}

	public UserDetails isValidUser(String userId, String password) {
		logger.info(" isValidUser of  UserDetailsDaoImp start from here with userId : "+ userId + " password : " + password);
		String hql = "from UserDetails where userId = " + "'" + userId + "'" + "and" 
				+ " password = " + "'" + password+ "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		if(list != null && !list.isEmpty()){
		logger.info(" isValidUser of  UserDetailsDaoImp start ends here with userId : "+ userId + " password : " + password);
			return list.get(0);
		}
		logger.info(" isValidUser of  UserDetailsDaoImp start ends here with userId : "+ userId + " password : " + password);
		return null ;
	}

}

