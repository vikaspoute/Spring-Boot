package com.self.learn.ecommerce.repositories;

import com.self.learn.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);
//    Optional<Category> findByEmail(String categoryName);
}
