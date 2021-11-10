package com.ibm.repo;

import com.ibm.entity.Flight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FlightRepository extends JpaRepository<Flight , Integer> {

	
	List<Flight> findByCarrier(String carrier);
	
	@Query("From Flight WHERE source=:src AND destiny=:dest")
   List<Flight> findByRoute(String src, String dest);
}
