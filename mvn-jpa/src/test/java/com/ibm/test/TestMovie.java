package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ibm.dao.MovieDao;
import com.ibm.entity.Movie;
import com.ibm.entity.Multiplex;

public class TestMovie {

	private static MovieDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new MovieDao();
	}
	
	@Test
	public void testAddMovie() {
		Movie m = new Movie();
		m.setTitle("Dangal");
		m.setRating(4.6);
		int mid = dao.addMovie(m);
		System.out.println(mid);
	}
	
	@Test
	public void testAddMultiplex() {
		Multiplex m = new Multiplex();
		m.setName("INOX");
		m.setCity("Thane");
		int mid = dao.addMultiplex(m);
		System.out.println(mid);
	}
	
	@Test
	public void testSetMovieToMultiplex() {
		assertTrue(dao.addMovieToMultiplex(352, 1452));
	}
	
	@Test
	public void testFindMovie() {
		Movie m = dao.findMovie(352);
		assertNotNull(m);
		System.out.println(m);
	}
}
