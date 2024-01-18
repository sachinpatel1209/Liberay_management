package com.library.management.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.entity.Book;
import com.library.management.entity.Issue;
import com.library.management.entity.IssuedBook;
import com.library.management.service.BookService;
import com.library.management.service.IssueService;
import com.library.management.service.IssuedBookService;

@RestController
public class IssueController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private IssueService issueService;
	
	@Autowired
	private IssuedBookService issuedBookService;

	@GetMapping("/return/all")
	public String returnAll(@PathVariable(name = "id") Long id) {
		Optional<Issue> optionalIssue = issueService.getById(id);
		if (optionalIssue.isPresent()) {
		    Issue issue = optionalIssue.get();
		    List<IssuedBook> issuedBooks = issue.getIssuedBook();
			for( int i=0 ; i<issuedBooks.size() ; i++ ) {
				IssuedBook ib = issuedBooks.get(i);
				
				issuedBookService.saveNewIssuedBook( ib );
				
				Book book = ib.getBook();
				
				bookService.addNew(book);
			}
			
			issueService.save(issue);
			
			return "successful";
		} else {
			return "unsuccessful";
		}
	}
	
	@PostMapping("/return")
	public String returnSelected( @PathVariable(name = "id") Long id) {
		Optional<Issue> optionalIssue = issueService.getById(id);
		if (optionalIssue.isPresent()) {
		    Issue issue = optionalIssue.get();
		    List<IssuedBook> issuedBooks = issue.getIssuedBook();
			
			for( int k=0 ; k<issuedBooks.size() ; k++ ) {
				IssuedBook ib = issuedBooks.get(k);
				
					
					Book book = ib.getBook();
					
					bookService.addNew(book);
				}
			}
			
			return "successful";
		} 
	}

	
	
		
