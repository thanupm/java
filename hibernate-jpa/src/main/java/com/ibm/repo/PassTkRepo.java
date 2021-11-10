package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ibm.entity.Department;
import com.ibm.entity.Employee;
import com.ibm.entity.Passanger;
import com.ibm.entity.Ticket;


public class PassTkRepo {
private EntityManager getManager()
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("first-jpa");
	EntityManager mgr = emf.createEntityManager();
	
	return mgr;
}

public void savePass(Passanger pass, int pnr) {
	EntityManager mgr =  getManager();
	EntityTransaction txn = mgr.getTransaction();
	txn.begin();
	
	Ticket tck = mgr.find(Ticket.class, 1);
	pass.setTck(tck);
	mgr.persist(pass);
	txn.commit();
	mgr.close();
}

public void saveTicket(Ticket tck)
{
	EntityManager mgr =  getManager();
	EntityTransaction txn = mgr.getTransaction();
	
	txn.begin();
	mgr.persist(tck);
	txn.commit();
	mgr.close();
}

public Passanger getPass(int id)
{
	EntityManager mgr =  getManager();
	return mgr.find(Passanger.class, id);
}

public List<Passanger> getAllPass(){
	EntityManager mgr =  getManager();
	return mgr.createQuery("from Passanger").getResultList();
}

public Ticket getTck(int pnr) {
	EntityManager mgr =  getManager();
	return mgr.find(Ticket.class,pnr);
}

public List<Ticket> getAllTck()
{
	EntityManager mgr =  getManager();
	return mgr.createNativeQuery("from Ticket").getResultList();
}


}