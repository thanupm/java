package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ibm.dao.EmpDeptDao;
import com.ibm.entity.Department;
import com.ibm.entity.Employee;

public class TestEmpDept {
	private static EmpDeptDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new EmpDeptDao();
	}
	
	@Test
	public void testAddDept() {
		Department dept = new Department();
		dept.setDeptId(10);
		dept.setDeptName("IT");
		assertEquals(10, dao.addDept(dept));
		System.out.println(dept);
	}
	
	@Test
	public void testAddEmp() {
		Employee emp = new Employee();
		emp.setEmpName("Polo");
		emp.setSalary(1200);
		assertNotEquals(0, dao.addEmp(emp, 10));
		System.out.println(emp);
	}
	
	@Test
	public void testFindDept() {
		Department dept = dao.findDept(10);
		assertNotNull(dept);
		System.out.println(dept);
		dept.getEmps().forEach(System.out::println);
	}
	
	@Test
	public void testRemoveDept() {
		assertTrue(dao.removeDept(10));
	}
}
