package com.skilldistillery.budgets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.budgets.entities.Category;
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
		Optional<Transaction> optTransaction = repo.findById(id);
		Transaction foundTransaction = null;
		if (optTransaction.isPresent()) {
			foundTransaction = optTransaction.get();
		}
		return foundTransaction;
	}

	@Override
	public Transaction create(Transaction transaction) {
		Category category = new Category();
		category.setId(1);
		transaction.setCategory(category);
		Transaction createdTransaction = repo.saveAndFlush(transaction);
		return createdTransaction;
	}

	@Override
	public Transaction update(int id, Transaction transaction) {
		Optional<Transaction> foundTransaction = repo.findById(id);
		Transaction newTransaction = null;
		if (foundTransaction.isPresent()) {
			newTransaction = foundTransaction.get();
			newTransaction.setType(transaction.getType());
			newTransaction.setAmount(transaction.getAmount());
			newTransaction.setDescription(transaction.getDescription());
			repo.saveAndFlush(newTransaction);
			return newTransaction;
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		Optional<Transaction> optTransaction = repo.findById(id);
		Transaction foundTransaction = null;
		if (optTransaction.isPresent()) {
			foundTransaction = optTransaction.get();
			repo.delete(foundTransaction);
			return true;
		}
		return false;
	}

}
