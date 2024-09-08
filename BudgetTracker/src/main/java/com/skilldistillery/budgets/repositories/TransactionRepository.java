package com.skilldistillery.budgets.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.budgets.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	List<Transaction> findByDescriptionLike(String keyword);
	List<Transaction> findByPaymentDateBetween(LocalDate start, LocalDate end);
}
