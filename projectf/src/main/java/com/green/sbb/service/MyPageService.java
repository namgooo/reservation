package com.green.sbb.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.green.sbb.entity.Reservation;
import com.green.sbb.entity.Review;
import com.green.sbb.repository.CustomerRepository;
import com.green.sbb.repository.ReservationRepository;
import com.green.sbb.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageService {

	private final ReviewRepository reviewRepository;
	private final CustomerRepository customerRepository;
	private final ReservationRepository reservationRepository;
	
	
	@Transactional
	public Optional<Reservation> getReservation(int id) {
		
		return this.reservationRepository.findById(id);
	}
	
}
