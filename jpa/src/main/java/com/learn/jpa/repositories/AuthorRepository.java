package com.learn.jpa.repositories;

import com.learn.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllAuthorsByFirstName(String firstName);
}
