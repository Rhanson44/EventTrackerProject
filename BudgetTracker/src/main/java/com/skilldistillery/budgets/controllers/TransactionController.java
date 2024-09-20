package com.skilldistillery.budgets.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping("transactions")
	public List<Transaction> index(HttpServletResponse response) {
		return service.findAll();
	}
	
	@GetMapping("transactions/{id}")
	public Transaction findById(@PathVariable("id") int id, HttpServletResponse response) {
		Transaction transaction = service.show(id);
		if (transaction == null) {
			response.setStatus(404);
		}
		return transaction;
	}
	
	@PostMapping("transactions/transactionParties/{partyId}/categories/{categoryId}")
	public Transaction create(@RequestBody Transaction transaction, @PathVariable("partyId") int partyId, @PathVariable("categoryId") int categoryId, HttpServletResponse response, HttpServletRequest request) {
		try {
			service.create(transaction, partyId, categoryId);
			if (transaction == null) {
				response.setStatus(404);
			} else {
				response.setStatus(201);
				response.setHeader("Location", request.getRequestURL().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			transaction = null;
		}
		return transaction;
	}
	
	@PutMapping("transactions/{id}")
	public Transaction update(@RequestBody Transaction transaction, @PathVariable("id") int id, HttpServletResponse response, HttpServletRequest request) {
		Transaction newTransaction = null;
		try {
			newTransaction = service.update(id, transaction);
			if (transaction == null) {
				response.setStatus(404);
			} else {
				response.setStatus(201);
				response.setHeader("Location", request.getRequestURL().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
			transaction = null;
		}
		return newTransaction;
	}
	
	@DeleteMapping("transactions/{id}")
	public void delete(@PathVariable("id") int id, HttpServletResponse response) {
		try {
			if(service.delete(id)) {
				response.setStatus(204);
			} else {
				response.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
	}
	
	@GetMapping("transactions/search/{keyword}")
	public List<Transaction> findByKeyword(@PathVariable("keyword") String keyword, HttpServletResponse response) {
		List<Transaction> transactions = null;
		try {
			transactions = service.findByKeyword(keyword);
			if (transactions == null) {
				response.setStatus(404);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
		return transactions;
	}
	
	@GetMapping("transactions/searchDate/{start}/{end}")
	public List<Transaction> findByKeyword(@PathVariable("start") LocalDate start, @PathVariable("end") LocalDate end, HttpServletResponse response) {
		List<Transaction> transactions = null;
		try {
			transactions = service.findByDate(start, end);
			if (transactions == null) {
				response.setStatus(404);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
		return transactions;	
	}
}
