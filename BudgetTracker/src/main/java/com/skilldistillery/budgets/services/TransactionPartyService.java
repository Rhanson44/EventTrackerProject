package com.skilldistillery.budgets.services;

import java.util.List;

import com.skilldistillery.budgets.entities.Transaction;
import com.skilldistillery.budgets.entities.TransactionParty;

public interface TransactionPartyService {

	List<TransactionParty> findAll();
	List<Transaction> findTransactionsByPartyId(int partyId);
	TransactionParty create(TransactionParty party);
}
