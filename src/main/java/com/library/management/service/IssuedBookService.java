package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.IssuedBook;
import com.library.management.repository.IssuedBookRepository;

@Service
public class IssuedBookService {

	@Autowired
	public IssuedBookRepository issuedBookRepository;

	
	public List<IssuedBook> getAll() {
		return issuedBookRepository.findAll();
	}
	
	public Optional<IssuedBook> get(Long id) { 
		return issuedBookRepository.findById(id);
	}
	
	public IssuedBook saveNewIssuedBook(IssuedBook issuedBook) {
		return issuedBookRepository.save(issuedBook);
	}
}
