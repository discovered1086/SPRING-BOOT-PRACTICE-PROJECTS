package com.kingshuk.webservices.rest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.webservices.rest.models.UserPost;

public interface UserPostsRepository extends JpaRepository<UserPost, Integer> {

}
