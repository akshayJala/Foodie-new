package com.foodiespot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodiespot.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImp implements CategoryDao{
	private static final Logger logger = LoggerFactory.getLogger(CategoryDaoImp.class);
	@Autowired
	private SessionFactory sessionFactory ;
	
	public CategoryDaoImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveCategory(Category category) {
		logger.info(" saveCategory method of CategoryDAO begins here! ");
		try{
			sessionFactory.getCurrentSession().save(category);
			//String json = gson.toJson(category);
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		logger.info(" saveCategory method of CategoryDAO ends here! ");
		return true;
	}

	public boolean updateCategory(Category category) {
		logger.info(" updateCategory method of CategoryDAO begins here! ");
		try{
			sessionFactory.getCurrentSession().update(category);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		logger.info(" updateCategory method of CategoryDAO ends here! ");
		return true;
	}

	public boolean deleteCategory(int categoryId) {
		logger.info(" deleteCategory method of CategoryDAO begins here! ");
		try{
			sessionFactory.getCurrentSession().delete(getCategory(categoryId));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		
		}
		logger.info(" deleteCategory method of CategoryDAO ends here! ");
		return true;
	}

	public Category getCategory(int categoryId) {
		logger.info(" getCategory method of CategoryDAO begins here! ");
		String hql = "from Category where categoryId = '" + categoryId + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> categoryList = query.list();
		if(categoryList == null){
		 return null ;	
		}
		else
		logger.info(" getCategory method of CategoryDAO ends here! ");
		return categoryList.get(0);
	}

	public List<Category> CategoryList() {
		logger.info(" CategoryList method of CategoryDAO begins here! ");
		
		String hql = "from Category" ;
		List<Category> categoryList = sessionFactory.getCurrentSession().createQuery(hql).list();
		
		if(categoryList == null){
		 return null ;	
		}
		else
			logger.info(" CategoryList method of CategoryDAO ends here! ");
		return categoryList ;
	}

	public Category getCategoryByName(String categoryName) {
		logger.info(" getCategoryByName method of CategoryDAO begins here! ");
		String hql = "from Category where categoryName = '" + categoryName + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> categoryList = query.list();
		if(categoryList == null){
		 return null ;	
		}
		else
			logger.info(" getCategoryByName method of CategoryDAO ends here! ");
		return categoryList.get(0);
		
	}

	

}

