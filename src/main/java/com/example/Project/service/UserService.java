package com.example.Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Project.Beans.User;
import com.example.Project.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	// Method to save a user
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	// Method to retrieve all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Method to retrieve a user by its ID
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	// Method to update a user
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	// Method to delete a user by its ID
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	// Method to retrieve a user by its email
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	

	
	
   
}
