package com.kingshuk.webservices.rest.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kingshuk.webservices.rest.models.User;
import com.kingshuk.webservices.rest.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@GetMapping(path = "/users")
	public List<User> findAllUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping(path = "/users/{id}")
	public User findSingleUser(@PathVariable String id){
		return service.findOneUser(id);
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createNewUser(@RequestBody User user){
		User createNewUser = service.createNewUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
								   .path("/{id}")
								   .buildAndExpand(createNewUser.getId())
								   .toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
