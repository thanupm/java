package com.ibm.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.student;
import com.ibm.service.StudentService;

@ExtendWith(SpringExtension.class)
public class TestStudentService {

	@Autowired
	private StudentService service;
	
	@Test
	public void testSave()
	{
		student s = new student();
		s.setRolNo(456);
		s.setName("Maxi");
		s.setSchool("Mihs");
		
		service.save(s);
	}
	
	@Test
	public void testFetch()
	{
		student s = service.fetch(123);
		assertNotNull(s);
	}
	
	@Test
	public void testInvalidFetch()
	{
		student s = service.fetch(999);
		assertNull(s);
		
	}
	
	@Test
	public void testFetchAll()
	{
		List<student> stud = service.fetchAll();
		assertNotNull(stud);
	}
	
}
