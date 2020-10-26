package com.kingshuk.webservices.rest.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kingshuk.webservices.rest.models.User;
import com.kingshuk.webservices.rest.models.UserPost;
import com.kingshuk.webservices.rest.service.UsersService;

@RestController
public class UserPostsController {

	@Autowired
	private UsersService service;

	@GetMapping(path = "/users/{id}/posts")
	public List<UserPost> findAllUsers() {
		return service.findAllUserPosts();
	}

	@GetMapping(path = "/users/{userId}/posts/{id}")
	public ResponseEntity<UserPost> findSingleUser(@PathVariable String userId, @PathVariable("id") String postId) {
		Optional<User> findOneUser = service.findOneUser(userId);

		if (!findOneUser.isPresent()) {
			// return ResponseEntity.notFound().build();
			throw new UserNotFoundException("The user with id " + userId + " was not found...!!");
		}

		Optional<UserPost> userPost = service.findOneUserPost(postId);

		if (!userPost.isPresent()) {
			// return ResponseEntity.notFound().build();
			throw new UserNotFoundException("The user post with id " + postId + " was not found...!!");
		}

		return ResponseEntity.ok(userPost.get());
	}

	@DeleteMapping(path = "/users/{id}/posts/{id}")
	public ResponseEntity<Void> deleteSingleUser(@PathVariable String id) {
		Optional<User> findOneUser = service.findOneUser(id);

		if (!findOneUser.isPresent()) {
			// return ResponseEntity.notFound().build();
			throw new UserNotFoundException("The user with id " + id + " was not found...!!");
		}

		service.deleteUser(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Object> createNewUser(@Valid @RequestBody UserPost post, @PathVariable("id") String userId) {
		UserPost newPost = service.createNewPost(post, userId);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPost.getPostId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
