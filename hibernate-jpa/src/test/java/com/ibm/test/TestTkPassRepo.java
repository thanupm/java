package com.ibm.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ibm.entity.Department;
import com.ibm.entity.Employee;
import com.ibm.entity.Passanger;
import com.ibm.entity.Ticket;
import com.ibm.repo.EmpDeptRepo;
import com.ibm.repo.PassTkRepo;

public class TestTkPassRepo {

private static PassTkRepo repo;
	
@BeforeAll
public static void init()
{
	repo = new PassTkRepo();
}

	

@Test
public void testSaveTicket() {
	Ticket tck = new Ticket();
	tck.setAmount(5000);
	tck.setPnr(1114);
	tck.setTravelDate(null);
	repo.saveTicket(tck);
	
}

@Test
public void testSavePassanger() {
	Passanger pass = new Passanger();
	pass.setAge(28);
	pass.setId(2);
	pass.setName("Manasa");
	repo.savePass(pass, 1111);
}
}
