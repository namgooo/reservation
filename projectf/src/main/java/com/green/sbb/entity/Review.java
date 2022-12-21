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
@Table(name = "REVIEW")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewId_SEQ")
	@SequenceGenerator(sequenceName = "reviewId_seq", allocationSize = 1, name = "reviewId_SEQ")
	private Integer reviewId;
	
	// 포린키		
	@OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE)
	private List<Answer> answer;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Restaurant restaurant;	
	// 포린키
	
	//@Column(nullable = false)
	private String restaurantName;
	
	//@Column(nullable = false)
	private String nickName;
	
	//@Column(nullable = false)
	private String title;
	
	//@Column(nullable = false)
	private String coment;
	
	//@Column(nullable = false)
	private String score;
	
	private LocalDateTime createDate;
	

}

