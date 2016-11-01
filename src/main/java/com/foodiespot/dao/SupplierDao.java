package com.foodiespot.dao;

import java.util.List;

import com.foodiespot.model.Supplier;

public interface SupplierDao {
	
	public boolean saveSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplierId);
	public Supplier getSupplier(int supplierId);
	public List<Supplier> SupplierList();
	public Supplier getSupplierByName(String supplierName);

}
