package com.ibm.service;

import java.util.List;

import com.ibm.model.student;

public interface StudentService {

	void save(student s);
	
	student fetch(int rolNo);
	
	List<student> fetchAll();
	
}
