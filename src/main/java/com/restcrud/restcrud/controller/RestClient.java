package com.restcrud.restcrud.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.restcrud.restcrud.model.UserDTO;

//import com.restcrud.restcrud.model.UserDTO;


public class RestClient {
	
	private static final String GET_ALL_USERS_API = "http://localhost:8080/users";
	private static final String CREATE_USER_API = "http://localhost:8080/users";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		
		callGetAllUsersAPI();
		callCreateUserAPI();
	}
	

	private static void callGetAllUsersAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USERS_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	private static void callCreateUserAPI() {
		UserDTO user = new UserDTO("Darshan", "Singer", false);
		ResponseEntity<UserDTO> user2 = restTemplate.postForEntity(CREATE_USER_API, user, UserDTO.class);
//		System.out.println(user2);
	}
}
	
	
