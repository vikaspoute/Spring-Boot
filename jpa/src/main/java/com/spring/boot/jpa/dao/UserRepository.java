package com.spring.boot.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
