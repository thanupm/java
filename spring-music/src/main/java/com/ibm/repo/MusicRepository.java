package com.ibm.repo;

import java.util.List;

import com.ibm.entity.Music;

public interface MusicRepository {

	
	void save(Music m);
	
	List<Music> fetchAll();
	
	Music fetch(int id);
	
	List<Music> fetchByGenre(String genre);
	
	
}
