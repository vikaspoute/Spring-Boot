package com.learn.jpa.repositories;

import com.learn.jpa.models.Text;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<Text, Integer> {
}
