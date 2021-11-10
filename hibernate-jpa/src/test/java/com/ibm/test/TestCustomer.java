package com.ibm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.ibm.entity.Customer;


public class TestCustomer {
	@Test
	public void testSaveCustomer() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Customer c1 = new Customer();
		c1.setCustId(112);
		c1.setCustName("Anki");
		c1.setCity("Tumkur");
		
		mgr.persist(c1);
		txn.commit();
	
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testGetCustomer() {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		Customer c1 = mgr.find(Customer.class, 111);
		System.out.println(c1.getCustName() + "\t" + c1.getCity());
		
		mgr.close();
		emf.close();
	}
	
	
}

