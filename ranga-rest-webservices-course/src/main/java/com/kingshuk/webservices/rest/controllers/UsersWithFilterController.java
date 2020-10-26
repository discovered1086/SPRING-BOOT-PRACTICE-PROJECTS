package com.kingshuk.webservices.rest.controllers;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kingshuk.webservices.rest.models.User;
import com.kingshuk.webservices.rest.models.UserWithFilter;
import com.kingshuk.webservices.rest.service.UsersService;

@RestController
public class UsersWithFilterController {

	@Autowired
	private UsersService service;

	@GetMapping(path = "/users-dynamic-filtering")
	public MappingJacksonValue findAllUsers() {
		List<User> findAllUsers = service.findAllUsers();
		List<UserWithFilter> collect = findAllUsers.stream()
				.map(user -> new UserWithFilter(user.getId(), user.getName(), user.getDob(), user.getSsn()))
				.collect(Collectors.toList());
		return filterBean(collect, "id", "name", "dob");
	}

	@GetMapping(path = "/users-dynamic-filtering/{id}")
	public MappingJacksonValue findSingleUser(@PathVariable String id) {
		Optional<User> findOneUser = service.findOneUser(id);

		if (!findOneUser.isPresent()) {
			// return ResponseEntity.notFound().build();
			throw new UserNotFoundException("The user with id " + id + " was not found...!!");
		}

		User user = findOneUser.get();

		return filterBean(Arrays.asList(new UserWithFilter(user.getId(), user.getName(), user.getDob(), user.getSsn())),
				"id", "name", "ssn");
	}

	private MappingJacksonValue filterBean(List<UserWithFilter> findOneUser, String... fieldNames) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldNames);
		// Create the filter provider
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFetchFilter", filter);

		MappingJacksonValue mappingBean = new MappingJacksonValue(findOneUser);
		mappingBean.setFilters(filters);

		return mappingBean;
	}

	@PostMapping(path = "/users-dynamic-filtering")
	public ResponseEntity<Object> createNewUser(@Valid @RequestBody UserWithFilter user) {
		User createNewUser = service
				.createNewUser(new User(user.getId(), user.getName(), user.getDob(), user.getSsn()));

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createNewUser.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
