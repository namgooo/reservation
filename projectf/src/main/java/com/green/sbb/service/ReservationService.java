package com.green.sbb.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.green.sbb.entity.Customer;
import com.green.sbb.entity.Reservation;
import com.green.sbb.entity.Restaurant;
import com.green.sbb.repository.CustomerRepository;
import com.green.sbb.repository.ReservationRepository;
import com.green.sbb.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;
	private final CustomerRepository custometRepository;
	private final RestaurantRepository restaurantRepository;
	
	public void create( String restaurantName,
					    String reservationName,
					    String reservationDay,
					    String reservationTime,
					    String people,
					    String coment,
					    LocalDateTime createDate,
					    Customer customer) {
		
		Reservation reservation = new Reservation();
		
		Restaurant restaurant =  this.restaurantRepository.findByRestaurantName(restaurantName).get();
		
		reservation.setRestaurantName(restaurantName);
		reservation.setReservationName(reservationName);
		reservation.setReservationDay(reservationDay);
		reservation.setReservationTime(reservationTime);
		reservation.setPeople(people);
		reservation.setComent(coment);
		reservation.setCreateDate(LocalDateTime.now());
		reservation.setCustomer(customer);
		reservation.setRestaurant(restaurant);
		
		this.reservationRepository.save(reservation);
		
	}
	
	public List<Reservation> reservationInfo(int id) {
		return this.reservationRepository.findAll();
	}
	
}