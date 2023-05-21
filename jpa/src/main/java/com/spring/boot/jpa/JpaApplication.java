package com.spring.boot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.boot.jpa.dao.UserRepository;
import com.spring.boot.jpa.entities.User;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		// Saving multiple user

		// User user = new User();
		// user.setUsername("Vikas Poute");
		// user.setCity("Pune");
		// user.setStatus("Looking for java developer");

		// User user1 = new User();
		// user1.setUsername("Mahesh Poute");
		// user1.setCity("Sangli");
		// user1.setStatus("Policeman");

		// List<User> users = List.of(user, user1);
		// Iterable<User> result = userRepository.saveAll(users);

		// result.forEach(it -> {
		// System.out.println(it);
		// });

		// Get the user
		Optional<User> optional = userRepository.findById(2);
		User user = optional.get();
		System.out.println(user);

		// Update user .............. In update i used old varialbe instead of new one
		user.setUsername("Pondy");
		user.setCity("Pune");
		user.setStatus("Finding fronted job");

		User upResult = userRepository.save(user);
		System.out.println(upResult);

		// Get all the users
		Iterable<User> itr = userRepository.findAll();
		itr.forEach(it -> System.out.println(it));

		// delete all the users
		userRepository.deleteAll(itr);
		System.out.println("All users deleted");

	}

}
