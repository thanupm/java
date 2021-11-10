package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.student;
import com.ibm.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public void save(student s) {
		repo.save(s);

	}

	@Override
	public student fetch(int rolNo) {
		
		return repo.findById(rolNo).get();
	}

	@Override
	public List<student> fetchAll() {
		
		return repo.findAll();
	}

}
