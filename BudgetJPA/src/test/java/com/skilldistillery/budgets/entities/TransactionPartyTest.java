package com.skilldistillery.budgets.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class TransactionPartyTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private TransactionParty party;

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
		party = em.find(TransactionParty.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		party = null;
	}

	@Test
	void test_Transaction_entity_mapping() {
		assertNotNull(party);
		assertEquals("FirstBank", party.getName());
	}
	
	@Test
	void test_TransactionParty_Transaction_OneToMany_relationship() {
		assertNotNull(party.getTransactions());
		assertTrue(party.getTransactions().size() > 0);
	}

}
