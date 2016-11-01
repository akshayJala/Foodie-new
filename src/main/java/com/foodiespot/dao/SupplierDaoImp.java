package com.foodiespot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodiespot.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImp implements SupplierDao{
	private static final Logger logger = LoggerFactory.getLogger(SupplierDaoImp.class);
	@Autowired
	SessionFactory sessionFactory ;

	public boolean saveSupplier(Supplier supplier) {
		logger.info("saveSupplier Method of SupplierDaoImpl start from here with supplierId :" + supplier.getSupplierId());
		try{
		sessionFactory.getCurrentSession().save(supplier);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		logger.info("saveSupplier Method of SupplierDaoImpl ends  here with supplierId :" + supplier.getSupplierId());
		return true ;
	}

	public boolean updateSupplier(Supplier supplier) {
		logger.info("updateSupplier Method of SupplierDaoImpl start from here with supplierId :" + supplier.getSupplierId());
		try{
			sessionFactory.getCurrentSession().update(supplier);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		logger.info("updateSupplier Method of SupplierDaoImpl ends  here with supplierId :" + supplier.getSupplierId());
			return true ;
	}

	public boolean deleteSupplier(int supplierId) {
		logger.info("deleteSupplier Method of SupplierDaoImpl starts from here with supplierId :" + supplierId);
		try{
			sessionFactory.getCurrentSession().delete(getSupplier(supplierId));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		logger.info("deleteSupplier Method of SupplierDaoImpl ends  here with supplierId :" + supplierId);
			return true ;
	}

	public Supplier getSupplier(int supplierId) {
		logger.info("getSupplier Method of SupplierDaoImpl starts from here with supplierId :" + supplierId);
		String hql = "from Supplier where supplierId = '" + supplierId + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> supplierList = query.list();
		if(supplierList == null){
			return null ;
		}
		logger.info("getSupplier Method of SupplierDaoImpl starts ends with supplierId :" + supplierId);
		return supplierList.get(0);
		
	}

	public List<Supplier> SupplierList() {
		logger.info("SupplierList Method of SupplierDaoImpl starts from here !");
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> supplierList = query.list();
		if(supplierList == null){
			return null ;
		}
		logger.info("SupplierList Method of SupplierDaoImpl ends  here !");
		return supplierList ;
	}

	public Supplier getSupplierByName(String supplierName) {
		logger.info("getSupplierByName Method of SupplierDaoImpl starts from here with supplierName: " +supplierName);
		String hql = "from Supplier where supplierName = '" + supplierName + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> supplierList = query.list();
		if(supplierList == null){
			return null ;
		}
		logger.info("getSupplierByName Method of SupplierDaoImpl ends here with supplierName" + supplierName);
		return supplierList.get(0);
		
	}
	
}
