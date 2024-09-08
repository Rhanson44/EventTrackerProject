package com.skilldistillery.budgets.services;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.budgets.entities.Transaction;

public interface TransactionService {

	List<Transaction> findAll();
	Transaction show(int id);
	Transaction create(Transaction transaction, int partyId, int categoryId);
	Transaction update(int id, Transaction transaction);
	boolean delete(int id);
	List<Transaction> findByKeyword(String keyword);
	List<Transaction> findByDate(LocalDate start, LocalDate end);
	
}
