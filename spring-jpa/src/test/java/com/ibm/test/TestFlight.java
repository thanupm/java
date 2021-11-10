package com.ibm.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Flight;
import com.ibm.repo.FlightRepository;
import com.ibm.repo.FlightRepositoryImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestFlight {
	
	@Autowired
	private FlightRepository repo;

	@Test
	public void testSaveFlight() {
		
		//ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		//FlightRepository repo = (FlightRepository) appCtx.getBean("repo");
		Flight f = new Flight();
		f.setCarrier("Air Asia");
		f.setCode(456);
		f.setDestiny("Delhi");
		f.setSource("Kolkata");
		
		repo.save(f);
	}
	
	@Test 
	public void TestFetch()
	{
		//ApplicationContext appCtx = new ClassPathXmlApplicationContext("appctx.xml");
		
		//FlightRepository repo = (FlightRepository) appCtx.getBean("repo");
		Flight f = repo.fetch(456);
		System.out.println(f.getCarrier()+" , "+ f.getSource()+" , "+ f.getDestiny());
	}
	
	@Test
	public void testFetchByCarrier() {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		
		//FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		List<Flight> list = repo.fetchByCarrier("Air Asia");
		list.forEach(System.out::println);
		//for(Flight flight : list)
		//System.out.println(flight.getCode() + " "+flight.getDestiny() +" "+flight.getSource());
		
    }
	
	@Test
	public void testFetchByRoute()
	{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("appctx.xml");
		
		//FlightRepository repo = (FlightRepository) ctx.getBean("repo");
		List<Flight> flight = repo.fetchByRoute("Kolkata","Delhi");
		flight.forEach(System.out::println);
	}
	
	@Test
	public void TestRemoveFlight()
	{
		repo.removeFlight(0);
	}
	
	@Test
	public void TestUpdateFlight()
	{
		Flight f = new Flight();
		f.setCode(123);
		f.setCarrier("Indian Airways");
		f.setDestiny("Goa");
		f.setSource("Bengalore");
		repo.updateFlight(f);
	}
	
	
}
