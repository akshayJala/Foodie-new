package com.foodiespot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodiespot.model.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;
	

	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public Double getTotalRs(String userId) {
		String hql = "select sum(price) from Cart where userId=" + "'" + userId + "' and status=" + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Double sum = (Double) query.uniqueResult();
		return sum;
	}

	public void saveCart(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
		
	}

	public void updateCart(String userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "UPDATE Cart set status = 'D' where userId = '"+ userId + "' and status = 'N'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		
		
	}

	public void deleteCart(int cartId) {
		Cart cart = new Cart();
		cart.setCartId(cartId);

		sessionFactory.getCurrentSession().delete(cart);
		
	}

	public List<Cart> listCart(String userId) {
		String hql = "from Cart where userId=" + "'" + userId + "' and status=" + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listCart = query.list();
		return listCart;
		
	}

	public Cart getCart(String userId, String productName) {
		String hql = "from Cart where userId='" + userId + "' and productName='"+ productName + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listCart = query.getResultList();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}

		return null;
		
	}
	
	public Cart getCartByStatus(String userId) {
		String hql = "from Cart where userId='" + userId + "' and status='N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listCart = query.getResultList();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}

		return null;
		
	}


	public Cart getCartbyId(String userId, int cartId) {
		String hql = "from Cart where userId='" + userId + "' and cartId='"+ cartId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> listCart = query.getResultList();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}

		return null;
	}




}

