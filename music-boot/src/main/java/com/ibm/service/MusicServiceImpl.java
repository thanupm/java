package com.ibm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ibm.entity.Music;
import com.ibm.repo.MusicRepository;


@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	private MusicRepository repo;
	
	@Transactional
	@Override
	public void save(Music m) {
		repo.save(m);

	}

	@Override
	public Music fetch(int id) {
	
		return repo.findById(id).get();
	}

	@Override
	public List<Music> list() {
		
		return repo.findAll();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);

	}

	 @Override
	public List<Music> byTitle(String title) {
		
		 return repo.findByTitle(title);
	}

	@Override
	public List<Music> byArtist(String artist) {
		
		return repo.findByArtist(artist);
	} 

}
