package com.ibm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.ibm.entity.Passport;
import com.ibm.entity.Person;

public class TestPerson {
	@Test
	public void testSavePerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Person p1 = new Person();
		p1.setName("Sandhya");
		p1.setAge(22);
		
		mgr.persist(p1);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testGetPerson() {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		Person p = mgr.find(Person.class, 1);
		System.out.println(p.getName() + "\t" + p.getAge() +"\t" + p.getPid());
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testSavePassport() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		txn.begin();
		Passport pp = new Passport();
	    pp.setPassportNo(123567100l);
	    pp.setCountry("India");
	    Person p = mgr.find(Person.class,1);
	    pp.setCitizen(p);
		
		mgr.persist(pp);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testGetPassport() {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		Passport pp = mgr.find(Passport.class, 12356789l);
		System.out.println(pp.getCountry()+"\t"+pp.getPassportNo()+"\t"+pp.getCitizen());
		
		mgr.close();
		emf.close();
	}
	
	@Test
	public void testUpdatePerson() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Person p = mgr.find(Person.class, 1);
		p.setAge(30);
		
		mgr.merge(p);
		txn.commit();
		
		mgr.close();
		emf.close();
	}
	
	
}
