package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ibm.dao.AlbumDao;
import com.ibm.entity.Album;

public class TestAlbumDao {

	private static AlbumDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new AlbumDao();
	}
	
	@Test
	public void testAdd() {
		Album a = new Album();
		a.setTitle("Rockstar");
		a.setGenre("Rock");
		a.setRating(4.0);
		
		assertNotEquals(0, dao.saveAlbum(a));
	}
	
	@Test
	public void testFind() {
		Album a = dao.findAlbum(17);
		assertNotNull(a);
		System.out.println(a);
	}
	
	@Test
	public void testUpdate() {
		Album a = new Album();
		a.setAlbumId(17);
		a.setTitle("Rockstar");
		a.setGenre("Rock");
		a.setRating(4.5);
		
		assertNotNull(dao.updateAlbum(a));
		System.out.println(a);
	}
}
