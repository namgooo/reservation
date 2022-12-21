package com.green.sbb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.sbb.UserRole;
import com.green.sbb.entity.Customer;
import com.green.sbb.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService{
	
	private final CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String customerId) throws UsernameNotFoundException{
		
		Optional<Customer> customers = this.customerRepository.findByCustomerId(customerId);
		
		if(customers.isEmpty()) {
			throw new UsernameNotFoundException("회원을 찾을수 없습니다.");
		}
		
		Customer customer = customers.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if("namgo".equals(customerId)) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}  else {
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		
		
		if(customer.getRole() == 1) {
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		
		if(customer.getRole() >= 2) {
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		}
		

		return new User(customer.getCustomerId(), customer.getPassword(), authorities);
	}
	
	

}
