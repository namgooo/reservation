package com.green.sbb.entity;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "RESERVATION")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationId_SEQ")
	@SequenceGenerator(sequenceName = "reservationId_seq", allocationSize = 1, name = "reservationId_SEQ")
	private Integer reservationId;
	
	// 포린키
	@ManyToOne
	private Restaurant restaurant;
	
	@ManyToOne
	private Customer customer;
	// 포린키
	
	//@Column(nullable = false)
	private String restaurantName;
	
	//@Column(nullable = false)
	private String reservationName;
	
	//@Column(nullable = false)
	private String reservationDay;
	
	//@Column(nullable = false)
	private String reservationTime;
	
	//@Column(nullable = false)
	private String people;

	//@Column(nullable = false)
	private String coment;
	
	private LocalDateTime createDate;
	
}
