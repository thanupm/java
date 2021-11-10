package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.model.student;

public interface StudentRepository extends MongoRepository<student, Integer> {
	
	
	
	

}
