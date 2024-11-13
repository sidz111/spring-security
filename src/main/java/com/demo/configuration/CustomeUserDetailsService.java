package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

@Component   // for allowing to make object use @Component annotation
public class CustomeUserDetailsService implements UserDetailsService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee emp = employeeRepository.findByEmail(email);
		if(emp==null) {
			throw new UsernameNotFoundException("User Not found");
		}
		else {
			return new CustomUser(emp);
		}
	}

}
