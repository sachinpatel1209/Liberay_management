package com.library.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "issued book")
public class IssuedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	@NotNull
	private Book book;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "issue_id")
	@NotNull
	private Issue issue;

	
	public IssuedBook() {
		
	}
	
	
	public IssuedBook(Long id, @NotNull Book book, @NotNull Issue issue) {
		super();
		this.id = id;
		this.book = book;
		this.issue = issue;
	}

	public Long getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	
}



