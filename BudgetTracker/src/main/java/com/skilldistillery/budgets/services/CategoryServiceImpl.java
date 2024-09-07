package com.skilldistillery.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.budgets.entities.Category;
import com.skilldistillery.budgets.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Override
	public List<Category> findAll() {
		return repo.findAll();
	}

	@Override
	public Category show(int id) {
		return null;
	}

	@Override
	public Category create(Category category) {
		return null;
	}

	@Override
	public Category update(int id, Category category) {
		return null;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

}
