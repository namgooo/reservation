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
@Table(name = "ANSWER")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answerId_SEQ")
	@SequenceGenerator(sequenceName = "answerId_seq", allocationSize = 1, name = "answerId_SEQ")
	private Integer answerId;
	
	// 포린키
	@ManyToOne
	private Review review;
	
	@ManyToOne
	private Customer customer;
	// 포린키
	
	//@Column(nullable = false)
	private String content;
	
	private LocalDateTime createDate;
		
}
