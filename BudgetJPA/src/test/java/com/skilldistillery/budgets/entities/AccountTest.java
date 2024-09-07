package com.skilldistillery.budgets.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class AccountTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Account account;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("BudgetJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		account = em.find(Account.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		account = null;
	}

	@Test
	void test_Transaction_entity_mapping() {
		assertNotNull(account);
		assertEquals("Checking", account.getType());
	}

}
