package com.green.sbb.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurantId_SEQ")
	@SequenceGenerator(sequenceName = "restaurantId_seq", allocationSize = 1, name = "restaurantId_SEQ")
	private Integer restaurantId;
	
	
	// 포린키	
	@OneToMany(mappedBy="restaurant", cascade = CascadeType.REMOVE)
	private List<Reservation> reservation;
	
	@OneToMany(mappedBy="restaurant", cascade = CascadeType.REMOVE)
	private List<Review> review;
	
	@ManyToOne
	private Customer customer;
	// 포린키
	
	//@Column(nullable = false)
	private String restaurantName;
	
	//@Column(nullable = false)
	private String restaurantAddress;
			
	//@Column(nullable = false)
	private String restaurantTel;
	
	//@Column(nullable = false)
	private String owner;
	
	//@Column(nullable = false)
	private String buisnessNumber;
	
	//@Column(nullable = false)
	private String foundingDay;
	
	private LocalDateTime createDate;
	
	
	
}
