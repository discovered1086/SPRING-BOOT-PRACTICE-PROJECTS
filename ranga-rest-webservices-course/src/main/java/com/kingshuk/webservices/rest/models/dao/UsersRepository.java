package com.kingshuk.webservices.rest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kingshuk.webservices.rest.models.User;

public interface UsersRepository extends JpaRepository<User, Integer> {

}
