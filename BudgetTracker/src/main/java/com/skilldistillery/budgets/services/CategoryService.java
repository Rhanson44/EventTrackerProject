package com.skilldistillery.budgets.services;

import java.util.List;

import com.skilldistillery.budgets.entities.Category;

public interface CategoryService {
	
	List<Category> findAll();
	Category show(int id);
	Category create(Category category);
	Category update(int id, Category category);
	boolean delete(int id);
	
}
