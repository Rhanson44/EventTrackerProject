package com.skilldistillery.budgets.services;

import java.util.List;

import com.skilldistillery.budgets.entities.Transaction;

public interface TransactionService {

	List<Transaction> findAll();
	Transaction show(int id);
	Transaction create(Transaction transaction);
	Transaction update(int id, Transaction transaction);
	boolean delete(int id);
	
}
