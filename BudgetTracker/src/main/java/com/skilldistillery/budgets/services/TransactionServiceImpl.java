package com.skilldistillery.budgets.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.budgets.entities.Category;
import com.skilldistillery.budgets.entities.Transaction;
import com.skilldistillery.budgets.entities.TransactionParty;
import com.skilldistillery.budgets.repositories.CategoryRepository;
import com.skilldistillery.budgets.repositories.TransactionPartyRepository;
import com.skilldistillery.budgets.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private TransactionPartyRepository partyRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public List<Transaction> findAll() {
		return transactionRepo.findAll();
	}

	@Override
	public Transaction show(int id) {
		Optional<Transaction> optTransaction = transactionRepo.findById(id);
		Transaction foundTransaction = null;
		if (optTransaction.isPresent()) {
			foundTransaction = optTransaction.get();
		}
		return foundTransaction;
	}

	@Override
	public Transaction create(Transaction transaction, int partyId, int categoryId) {
		Optional<TransactionParty> partyOpt = partyRepo.findById(partyId);
		if (partyOpt.isPresent()) {
			transaction.setTransactionParty(partyOpt.get());
		}
		Optional<Category> categoryOpt = categoryRepo.findById(categoryId);
		if (categoryOpt.isPresent()) {
			transaction.setCategory(categoryOpt.get());
		}
		Transaction createdTransaction = transactionRepo.saveAndFlush(transaction);
		return createdTransaction;
	}

	@Override
	public Transaction update(int id, Transaction transaction) {
		Optional<Transaction> optTransaction = transactionRepo.findById(id);
		Transaction newTransaction = null;
		if (optTransaction.isPresent()) {
			newTransaction = optTransaction.get();
			newTransaction.setType(transaction.getType());
			newTransaction.setAmount(transaction.getAmount());
			newTransaction.setDescription(transaction.getDescription());
			transactionRepo.saveAndFlush(newTransaction);
		}
		return newTransaction;
	}

	@Override
	public boolean delete(int id) {
		Optional<Transaction> optTransaction = transactionRepo.findById(id);
		Transaction foundTransaction = null;
		if (optTransaction.isPresent()) {
			foundTransaction = optTransaction.get();
			transactionRepo.delete(foundTransaction);
			return true;
		}
		return false;
	}

	@Override
	public List<Transaction> findByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		return transactionRepo.findByDescriptionLike(keyword);
	}

	@Override
	public List<Transaction> findByDate(LocalDate start, LocalDate end) {
		return transactionRepo.findByPaymentDateBetween(start, end);
	}

}
