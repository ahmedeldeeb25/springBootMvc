package com.arch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.arch.mongoEntities.user;

@SpringBootApplication
public class NewArchApplication extends SpringBootServletInitializer implements CommandLineRunner{
	 @Autowired
	    com.arch.mongoEntities.userRepository userRepository;
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NewArchApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(NewArchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
//		
//		userRepository.save(new user("500","ahmed mar3y" ,"123","ahmedmar3y108@gmail.com" , "tanta" ,"01015136837"));
//		
//	     for (user user : userRepository.findAll()) {
//	            System.out.println(user);
//	        }
//
//	        System.out.println(userRepository.findById("500").getUsername());
//
//		
		
		
	}
}
