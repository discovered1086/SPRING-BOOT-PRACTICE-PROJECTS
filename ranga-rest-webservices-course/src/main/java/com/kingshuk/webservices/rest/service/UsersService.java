package com.kingshuk.webservices.rest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingshuk.webservices.rest.models.User;
import com.kingshuk.webservices.rest.models.UserPost;
import com.kingshuk.webservices.rest.models.dao.UserPostsRepository;
import com.kingshuk.webservices.rest.models.dao.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserPostsRepository userPostsRepository;

	public List<User> findAllUsers() {
		return usersRepository.findAll();
	}

	public Optional<User> findOneUser(String id) {
		return usersRepository.findById(Integer.parseInt(id));
	}

	public User createNewUser(User user) {
		return usersRepository.save(user);
	}
	
	public void deleteUser(String id) {
		usersRepository.deleteById(Integer.parseInt(id));
	}
	
	public List<UserPost> findAllUserPosts() {
		return userPostsRepository.findAll();
	}

	public Optional<UserPost> findOneUserPost(String id) {
		return userPostsRepository.findById(Integer.parseInt(id));
	}

	public UserPost createNewPost(UserPost post, String userId) {
		post.setPostedAt(LocalDateTime.now());
		
		
		Optional<User> findById = usersRepository.findById(Integer.parseInt(userId));
		
		User user = findById.get();
		
		post.setUser(user);
		
		return userPostsRepository.save(post);
	}
	
	public void deleteUserPost(String id) {
		userPostsRepository.deleteById(Integer.parseInt(id));
	}

}
