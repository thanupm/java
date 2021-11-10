package com.ibm.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ibm.entity.Music;


@Repository
public interface MusicService {

	
void save(Music m);
	
	Music fetch(int id);
	
	List<Music> list();
	
	void delete(int id);
	
	List<Music> byTitle(String title);
	
	List<Music> byArtist(String artist);
}
