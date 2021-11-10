package com.ibm.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ibm.entity.Department;
import com.ibm.entity.Employee;
import com.ibm.repo.EmpDeptRepo;



public class TestEmpDeptRepo {
	
	private static EmpDeptRepo repo;
	
	@BeforeAll
	public static void init()
	{
		repo = new EmpDeptRepo();
	}
	
	
	@Test
	public void testSaveDepartment() {
		Department dept = new Department();
		dept.setDeptName("Sales");
		dept.setDeptno(108);
		repo.saveDept(dept);
		
	}
	
	@Test
	public void testSaveEmployee() {
		Employee emp = new Employee();
		emp.setEmpNo(209);
		emp.setEmpName("Lulu");
		emp.setSalary(80000);
		repo.saveEmp(emp,108);
	}
	
	@Test
	public void TestGetDept()
	{
		Department dept = repo.getDept(23);
		System.out.println("Department: "+dept.getDeptno()+ " - "+dept.getDeptName());
		dept.getEmp();
		
	} 
	
	@Test 
	public void TestDeleteDept()
	{
		repo.deleteDept(23);
	}
	
	
}