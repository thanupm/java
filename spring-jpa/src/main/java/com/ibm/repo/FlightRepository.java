package com.ibm.repo;

import java.util.List;

import com.ibm.entity.Flight;

public interface FlightRepository {

	void save(Flight f);
	
	List<Flight> fetchAll();
	
	Flight fetch(int code);
	
	List<Flight> fetchByCarrier(String carrier);
	
	List<Flight> fetchByRoute(String source, String destiny);
	
	void updateFlight(Flight f);
	
	void removeFlight(int code);
}
