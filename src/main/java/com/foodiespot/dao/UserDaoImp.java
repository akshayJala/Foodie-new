package com.foodiespot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodiespot.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImp implements UserDao{
	@Autowired
	private SessionFactory sessionFactory ;
	public UserDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveUser(User user) {
		try{
			sessionFactory.getCurrentSession().save(user);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		return true;
		
	}

	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		return true;
		
	}

	public boolean deleteUser(String userId) {
		try{
			sessionFactory.getCurrentSession().delete(getUser(userId));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		return true;
		
	}

	public User getUser(String userId) {
		String hql = "from User where userId = '" + userId + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> userList = query.list();
		if(userList == null){
		 return null ;	
		}
		else
		return userList.get(0);
		
	}

	public List<User> UserList() {
		String hql = "from User" ;
		List<User> userList = sessionFactory.getCurrentSession().createQuery(hql).list();
		if(userList == null){
		 return null ;	
		}
		else
		return userList ;
		
	}

}
