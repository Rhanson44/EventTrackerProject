package com.skilldistillery.budgets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.budgets.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
