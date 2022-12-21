package com.green.sbb.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.sbb.entity.Customer;
import com.green.sbb.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Customer create(String customerId,
						   String password,
						   String name,
						   String email,
						   String tel) {
		
		Customer customer = new Customer();
		
		customer.setCustomerId(customerId);
		customer.setPassword(passwordEncoder.encode(password));
		customer.setName(name);
		customer.setEmail(email);
		customer.setTel(tel);
		customer.setCreateDate(LocalDateTime.now());
		customer.setRole(1);
		
		this.customerRepository.save(customer);
		
		return customer;
	}
	
	
	// id로 유저 정보 반환
	public Optional<Customer> getCustomer(String id) {
			
		return this.customerRepository.findByCustomerId(id);
	}
	
	public Optional<Customer> getCustomers(int id) {
		
		return this.customerRepository.findById(id);
	}
}
