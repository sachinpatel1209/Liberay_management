package com.library.management.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.library.management.entity.Book;

import com.library.management.service.BookService;
import jakarta.validation.Valid;

@RestController
public class BookController {
	
	@Autowired
	public BookService bookService;
	

	@GetMapping("/books")
	public List<Book> getAllBook() {
		return bookService.getAll();
	}
	
	
	@GetMapping("/books/{id}")
	public Optional<Book> getBookById(@PathVariable Long id) {
		return  bookService.getById(id);
	
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addNewBook(@Valid @RequestBody Book book) {
		 Book addedNew = bookService.addNew(book);
		
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				 		.path("/{id}")
				 		.buildAndExpand(addedNew.getId())
				 		.toUri();
		 
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/books/remove/{id}")
	public void removeBook(@PathVariable Long id) {
	    bookService.delete(id);
	}
	

}









