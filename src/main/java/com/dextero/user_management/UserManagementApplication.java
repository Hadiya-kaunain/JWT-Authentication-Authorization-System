package com.dextero.user_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dextero.user_management.entity.Role;
import com.dextero.user_management.entity.User;
import com.dextero.user_management.repository.RoleRepository;
import com.dextero.user_management.repository.UserRepository;
@SpringBootApplication
@EntityScan("com.dextero.user_management.entity")
public class UserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}
	  @Bean
	    CommandLineRunner loadData(
	            RoleRepository roleRepository,
	            UserRepository userRepository,
	            PasswordEncoder passwordEncoder) {

	        return args -> {

	            //  Create roles
	            Role adminRole = new Role();
	            adminRole.setName("ROLE_ADMIN");

	            Role userRole = new Role();
	            userRole.setName("ROLE_USER");

	            roleRepository.save(adminRole);
	            roleRepository.save(userRole);

	            //  Create admin user
	            User admin = new User();
	            admin.setName("Admin");
	            admin.setEmail("admin@dextero.com");
	            admin.setPassword(passwordEncoder.encode("Admin@123"));
	            admin.setRoles(Set.of(adminRole));

	            userRepository.save(admin);

	            System.out.println("Default roles and admin user created");
	        };
	    }
	}


