package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Book;
import com.library.management.entity.Category;
import com.library.management.repository.BookRepository;

@Service
public class BookService {
	 
	@Autowired
	public BookRepository bookRepository;

	
	
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<Book> getAll() {
		return bookRepository.findAll();
		
	}
	
	public Optional<Book> getById(Long id) {
		return bookRepository.findById(id);
	}
	
	
	public Book addNew(Book book) {
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> getByCategory(Category category) {
		return bookRepository.findByCategory(category);
	}
}
 







