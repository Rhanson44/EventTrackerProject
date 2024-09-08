package com.skilldistillery.budgets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.budgets.entities.Transaction;
import com.skilldistillery.budgets.entities.TransactionParty;
import com.skilldistillery.budgets.services.TransactionPartyService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class TransactionPartyController {
	
	@Autowired
	private TransactionPartyService service;

	@GetMapping("transactionParties")
	public List<TransactionParty> findAll() {
		return service.findAll();
	}
	
	@PostMapping("transactionParties")
	public TransactionParty create(@RequestBody TransactionParty party, HttpServletResponse response, HttpServletRequest request) {
		TransactionParty createdParty = null;
		try {
			createdParty = service.create(party);
			if (createdParty == null) {
				response.setStatus(404);
			} else {
				response.setStatus(201);
				response.setHeader("Location", request.getRequestURL().toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(400);
		}
		return createdParty;
	}
	
	@GetMapping("transactionParties/{partyId}/transactions")
	public List<Transaction> findTransactionsByParty(@PathVariable("partyId") int partyId, HttpServletResponse response) {
		List<Transaction> transactions = null;
		try {
			transactions = service.findTransactionsByPartyId(partyId);
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
