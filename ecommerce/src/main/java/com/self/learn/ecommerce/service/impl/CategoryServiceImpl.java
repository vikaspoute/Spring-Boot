package com.self.learn.ecommerce.service.impl;

import com.self.learn.ecommerce.model.Category;
import com.self.learn.ecommerce.repositories.CategoryRepository;
import com.self.learn.ecommerce.service.CategoryService;
import com.self.learn.ecommerce.exceptions.category.CategoryNotFoundException;
import com.self.learn.ecommerce.exceptions.category.CategoryAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = repository.findAll();
        return ResponseEntity.ok(categories);
    }

    @Override
    public ResponseEntity<Category> createCategory(Category category) throws CategoryAlreadyExistsException {
        if (repository.findByCategoryName(category.getCategoryName()).isPresent()) {
            throw new CategoryAlreadyExistsException(category.getCategoryName(), null);
        }
        Category savedCategory = repository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @Override
    public ResponseEntity<Category> getCategoryById(Long categoryId) throws CategoryNotFoundException {
        Category category = repository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
        return ResponseEntity.ok(category);
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long categoryId, Category category) throws CategoryNotFoundException {
        Category existingCategory = repository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        existingCategory.setCategoryName(category.getCategoryName());
        Category updatedCategory = repository.save(existingCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Long categoryId) throws CategoryNotFoundException {
        if (!repository.existsById(categoryId)) {
            throw new CategoryNotFoundException(categoryId);
        }
        repository.deleteById(categoryId);
        return ResponseEntity.noContent().build();
    }
}