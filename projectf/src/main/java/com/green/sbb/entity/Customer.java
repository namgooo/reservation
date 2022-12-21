package com.green.sbb.entity;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "CUSTOMER")
public class Customer {
	
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cid_SEQ")
	@SequenceGenerator(sequenceName = "cid_seq", allocationSize = 1, name = "cid_SEQ")
    private Integer id;
    
    
    // 포린키
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Reservation> reservation;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Answer> answer;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Review> review;
    
    //수정
	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
	private List<Restaurant> restaurant;
    //  포린키
   
   
    //@Column(unique = true)
    private String customerId;
    
    //@Column(nullable = false)
    private String password;
    
    //@Column(nullable = false)
    private String name;
    
    //@Column(unique = true)
    private String email;
    
    //@Column(nullable = false)
    private String tel;
    
    private LocalDateTime createDate;
    
    private Integer role;

}
