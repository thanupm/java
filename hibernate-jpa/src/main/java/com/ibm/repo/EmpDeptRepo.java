package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ibm.entity.Department;
import com.ibm.entity.Employee;

public class EmpDeptRepo {
private EntityManager getManager()
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
	EntityManager mgr = emf.createEntityManager();
	
	return mgr;
}

public void saveEmp(Employee emp, int deptno) {
	EntityManager mgr =  getManager();
	EntityTransaction txn = mgr.getTransaction();
	txn.begin();
	
	Department dept = mgr.find(Department.class,deptno);
	emp.setDept(dept);
	mgr.persist(emp);
	txn.commit();
	mgr.close();
}

public void saveDept(Department dept)
{
	EntityManager mgr =  getManager();
	EntityTransaction txn = mgr.getTransaction();
	
	txn.begin();
	mgr.persist(dept);
	txn.commit();
	mgr.close();
}

public void deleteDept(int deptno)
{
	EntityManager mgr =  getManager();
	EntityTransaction txn = mgr.getTransaction();
	
	txn.begin();
	Department dept = mgr.find(Department.class,deptno);
	mgr.remove(dept);
	
	txn.commit();
	mgr.close();
}

public Employee getEmp(int empNo)
{
	EntityManager mgr =  getManager();
	return mgr.find(Employee.class, empNo);
}

public List<Employee> getAlleMP(){
	EntityManager mgr =  getManager();
	return mgr.createQuery("from Employee").getResultList();
}

public Department getDept(int deptno) {
	EntityManager mgr =  getManager();
	return mgr.find(Department.class,deptno);
}

public List<Department> getAllDept()
{
	EntityManager mgr =  getManager();
	return mgr.createNativeQuery("from Department").getResultList();
}
}