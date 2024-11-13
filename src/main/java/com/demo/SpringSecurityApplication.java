package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
//		System.out.println(new BCryptPasswordEncoder().encode("1234"));
//		$2a$10$GsOxUpXgkA/pJLa0.O6lXeETBLp/uAmI9ixEac3zpGnC9uz4ikmZO

	}

}
