package com.self.learn.ecommerce.service;

import com.self.learn.ecommerce.exceptions.category.CategoryAlreadyExistsException;
import com.self.learn.ecommerce.exceptions.category.CategoryNotFoundException;
import com.self.learn.ecommerce.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<List<Category>> getAllCategories();

    ResponseEntity<Category> createCategory(Category category) throws CategoryAlreadyExistsException;

    ResponseEntity<Category> getCategoryById(Long categoryId) throws CategoryNotFoundException;

    ResponseEntity<Category> updateCategory(Long categoryId, Category category) throws CategoryNotFoundException;

    ResponseEntity<Void> deleteCategory(Long categoryId) throws CategoryNotFoundException;
}