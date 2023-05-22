package com.spring.boot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.boot.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByCity(String city);

    // @Query("SELECT u FROM User u")
    // public List<User> getAllUsers();

    @Query("SELECT u FROM User u WHERE u.name = :name")
    public List<User> getUserByName(@Param("name") String name);

    public List<User> getUserByNameAndCity(String name, String city);

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    public List<User> getAllUsers();
}
