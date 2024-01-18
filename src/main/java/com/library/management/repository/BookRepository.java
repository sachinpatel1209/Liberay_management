package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.entity.Book;
import com.library.management.entity.Category;

public interface BookRepository extends JpaRepository<Book, Long>{

	public List<Book> findByCategory(Category category);
}
