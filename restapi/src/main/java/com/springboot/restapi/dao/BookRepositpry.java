package com.springboot.restapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.restapi.entities.Books;

public interface BookRepositpry extends CrudRepository<Books, Integer> {

    public Books findById(int id);
}
