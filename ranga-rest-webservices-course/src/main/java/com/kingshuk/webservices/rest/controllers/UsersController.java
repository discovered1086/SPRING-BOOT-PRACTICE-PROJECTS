package com.kingshuk.webservices.rest.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
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
	public List<User> findAllUsers() {
		return service.findAllUsers();
	}

	@GetMapping(path = "/users/{id}")
	public ResponseEntity<EntityModel<User>> findSingleUser(@PathVariable String id) {
		Optional<User> findOneUser = service.findOneUser(id);

		if (!findOneUser.isPresent()) {
			// return ResponseEntity.notFound().build();
			throw new UserNotFoundException("The user with id " + id + " was not found...!!");
		}

		// Add link for getting all the users
		// More specifically add the link that's exposed over the controller method
		// 'findAllUsers'

		// Build the wrapper class which will hold the data as well as the links
		EntityModel<User> entityModel = EntityModel.of(findOneUser.get());

		// Using a builder class to build the links
		WebMvcLinkBuilder resourceLink = linkTo(methodOn(this.getClass()).findAllUsers());

		// Add the link to the wrapper resource class, with relationships
		entityModel.add(resourceLink.withRel("all-users"));

		return ResponseEntity.ok(entityModel);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createNewUser(@Valid @RequestBody User user) {
		User createNewUser = service.createNewUser(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createNewUser.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
