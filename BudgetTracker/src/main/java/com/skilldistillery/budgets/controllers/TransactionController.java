package com.skilldistillery.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("transactions/{id}")
	public Transaction findById(@PathVariable("id") int id) {
		return service.show(id);
	}
	
	@PostMapping("transactions")
	public Transaction create(@RequestBody Transaction transaction) {
		return service.create(transaction);
	}
	
	@PutMapping("transactions/{id}")
	public Transaction update(@RequestBody Transaction transaction, @PathVariable("id") int id) {
		return service.update(id, transaction);
	}
	
	@DeleteMapping("transactions/{id}")
	public boolean delete(@PathVariable("id") int id) {
		if(service.delete(id)) {
			return true;
		}
		return false;
	}
}
