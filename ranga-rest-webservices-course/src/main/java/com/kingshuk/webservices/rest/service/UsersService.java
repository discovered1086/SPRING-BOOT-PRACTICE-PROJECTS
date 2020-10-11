package com.kingshuk.webservices.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.webservices.rest.models.User;
import com.kingshuk.webservices.rest.models.dao.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public List<User> findAllUsers() {
		return usersRepository.findAll();
	}

	public User findOneUser(String id) {
		return usersRepository.findById(Integer.parseInt(id)).get();
	}

	public User createNewUser(User user) {
		return usersRepository.save(user);
	}

}
