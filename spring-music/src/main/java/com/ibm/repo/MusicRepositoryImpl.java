package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.ibm.entity.Music;

@Repository("repo")
public class MusicRepositoryImpl implements MusicRepository {
	
	@PersistenceContext 
	private EntityManager em;

	@Transactional
	@Override
	public void save(Music m) {
		em.persist(m);

	}

	@Override
	public List<Music> fetchAll() {
		
		Query query = em.createNamedQuery("music");
				return query.getResultList();
		// return em.createQuery("from Music").getResultList();
	}

	@Override
	public Music fetch(int id) {
		
		return em.find(Music.class, id);
	}

	@Override
	public List<Music> fetchByGenre(String genre) {
		Query query = em.createQuery("from Music Where genre='" + genre+ "'");
		return query.getResultList();
	}

}
