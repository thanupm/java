package com.ibm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ibm.entity.Movie;
import com.ibm.entity.Multiplex;

public class MovieDao {
	private EntityManagerFactory factory;
	
	public MovieDao() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public int addMultiplex(Multiplex m) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(m);
		txn.commit();
		em.close();
		return m.getMpexid();
	}
	
	public int addMovie(Movie m) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(m);
		txn.commit();
		em.close();
		return m.getMovid();
	}
	
	public boolean addMovieToMultiplex(int movId, int mpexId) {
		EntityManager em = null;
		EntityTransaction txn = null;
		
		try {
			em = factory.createEntityManager();
			txn = em.getTransaction();
			txn.begin();
			Movie mov = em.find(Movie.class, movId);
			Multiplex mpex = em.find(Multiplex.class, mpexId);
			mov.getMultiplexs().add(mpex);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public Multiplex findMultiplex(int mpexId) {
		EntityManager em = factory.createEntityManager();
		Multiplex mpex = em.find(Multiplex.class, mpexId);
		return mpex;
	}
	
	public Movie findMovie(int movId) {
		EntityManager em = factory.createEntityManager();
		Movie mov = em.find(Movie.class, movId);
		return mov;
	}
}
