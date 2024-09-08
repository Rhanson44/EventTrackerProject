package com.skilldistillery.budgets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.budgets.entities.Transaction;
import com.skilldistillery.budgets.entities.TransactionParty;
import com.skilldistillery.budgets.repositories.TransactionPartyRepository;

@Service
public class TransactionPartyServiceImpl implements TransactionPartyService {

	@Autowired
	private TransactionPartyRepository repo;

	@Override
	public List<TransactionParty> findAll() {
		return repo.findAll();
	}

	@Override
	public TransactionParty create(TransactionParty party) {
		return repo.saveAndFlush(party);
	}

	@Override
	public List<Transaction> findTransactionsByPartyId(int partyId) {
		Optional<TransactionParty> optTransactionParty = repo.findById(partyId);
		TransactionParty party = null; 
		if (optTransactionParty.isPresent()) {
			party = optTransactionParty.get();
		}
		List<Transaction> transactions = party.getTransactions();
		return transactions;
	}

}
