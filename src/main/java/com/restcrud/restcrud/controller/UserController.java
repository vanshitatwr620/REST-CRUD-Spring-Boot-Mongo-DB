package com.restcrud.restcrud.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restcrud.restcrud.model.UserDTO;
import com.restcrud.restcrud.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		List<UserDTO> users = userRepo.findAll();
		
		if(users.size() > 0) {
			return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<>("No Users Available", HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody UserDTO user) {
		try {
			user.setCreatedAt(new Date(System.currentTimeMillis()));
			userRepo.save(user);
			return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getSingleUser(@PathVariable("id") String id) {
		Optional<UserDTO> userOptional = userRepo.findById(id);
		if(userOptional.isPresent()) {
			return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<>("User Not Found with id :" + id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/users/{id}")
	public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody UserDTO user) {
		Optional<UserDTO> userOptional = userRepo.findById(id);
		if(userOptional.isPresent()) {
			UserDTO userToSave = userOptional.get();
			userToSave.setCompleted(user.getCompleted() != null ?  user.getCompleted() : userToSave.getCompleted());
			userToSave.setUser(user.getUser() != null ? user.getUser() : userToSave.getUser());
			userToSave.setOccupation(user.getOccupation() != null ? user.getOccupation() : userToSave.getOccupation());
			userToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
			userRepo.save(userToSave);
			return new ResponseEntity<>(userToSave, HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<>("User Not Found with id :" + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deletById(@PathVariable("id") String id) {
		try {
			userRepo.deleteById(id);
			return new ResponseEntity<>("Successfully deleted by id : "+ id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
}
