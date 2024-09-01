package com.learn.jpa.repositories;

import com.learn.jpa.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {
}
