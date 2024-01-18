package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Category;
import com.library.management.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getId(Long id) { 
		return categoryRepository.findById(id);
	}
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}
}



