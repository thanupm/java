package com.ibm.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.ibm.entity.Music;
import com.ibm.repo.MusicRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestMusic {

	@Autowired
	private MusicRepository repo;
	
	@Test
	public void saveMusic()
	{
		Music m = new Music();
		m.setId(2);
		m.setArtist("Shreya Ghoshal");
		m.setGenre("Classical");
		m.setRating(9.5);
		
		repo.save(m);
		
	}
	
	@Test
	public void fetch()
	{
		Music m = repo.fetch(1);
		System.out.println(m.getArtist()+ ", " +m.getGenre()+ " ," +m.getRating());
	}
	
	@Test
	public void fetchAll()
	{
		List<Music> music = repo.fetchAll();
		music.forEach(System.out::println);
	}
	
	@Test
	public void fetchByGener()
	{
		List<Music> music = repo.fetchByGenre("melody");
		music.forEach(System.out::println);
	}

}
