package com.library.management.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.library.management.entity.Category;
import com.library.management.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService;

	@GetMapping("categories")
	public List<Category> getAllCategories() {
		return categoryService.getAll();
	}
	
	@GetMapping("/categories/{id}")
	public Optional<Category> getCategoryById(@PathVariable Long id) {
		return categoryService.getId(id);
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Object> addCategory(@Valid @RequestBody Category category) {
		Category savedCategory = categoryService.save(category);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedCategory.getId())
						.toUri();
		return ResponseEntity.created(location).build();
	}
	
	public void removeCategory(@PathVariable Long id) {
		categoryService.delete(id);
	}
}





