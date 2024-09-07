package com.skilldistillery.budgets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.budgets.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
