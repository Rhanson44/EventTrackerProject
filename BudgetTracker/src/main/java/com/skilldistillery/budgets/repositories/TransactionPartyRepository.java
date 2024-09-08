package com.skilldistillery.budgets.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.budgets.entities.TransactionParty;

public interface TransactionPartyRepository extends JpaRepository<TransactionParty, Integer>{
}
