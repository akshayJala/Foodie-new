package com.foodiespot.dao;

import java.util.List;

import com.foodiespot.model.Category;

public interface CategoryDao {
	public boolean saveCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int categoryId);
	public Category getCategory(int categoryId);
	public List<Category> CategoryList();
	public Category getCategoryByName(String categoryName);
}