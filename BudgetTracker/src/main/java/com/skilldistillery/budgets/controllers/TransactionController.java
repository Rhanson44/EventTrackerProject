package com.skilldistillery.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.budgets.entities.Transaction;
import com.skilldistillery.budgets.services.TransactionService;

@RestController
@RequestMapping("api")
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping("transactions")
	public List<Transaction> index() {
		return service.findAll();
	}
}
