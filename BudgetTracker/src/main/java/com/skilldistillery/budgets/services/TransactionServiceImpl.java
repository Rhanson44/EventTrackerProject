package com.skilldistillery.budgets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.budgets.entities.Transaction;
import com.skilldistillery.budgets.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repo;
	
	@Override
	public List<Transaction> findAll() {
		return repo.findAll();
	}

	@Override
	public Transaction show(int id) {
		return null;
	}

	@Override
	public Transaction create(Transaction transaction) {
		return null;
	}

	@Override
	public Transaction update(int id, Transaction transaction) {
		return null;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

}
