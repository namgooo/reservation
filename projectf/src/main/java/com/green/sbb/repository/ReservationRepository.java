package com.green.sbb.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.green.sbb.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
	
}
