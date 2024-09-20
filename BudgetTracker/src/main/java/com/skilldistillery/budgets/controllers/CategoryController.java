package com.skilldistillery.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.budgets.entities.Category;
import com.skilldistillery.budgets.services.CategoryService;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping("categories")
	public List<Category> index() {
		return service.findAll();
	}
}
