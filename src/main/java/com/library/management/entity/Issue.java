package com.library.management.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Issue {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column (name = "expected_return_date")
	private Date returnDate;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	@JsonIgnore
	@OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
	private List<IssuedBook> issuedBook;
	
	public Issue() {
		
	}

	public Issue(Long id, @NotNull Date issueDate, Date returnDate,
				Member member, List<IssuedBook> issuedBook) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.member = member;
		this.issuedBook = issuedBook;
	}

	public Long getId() {
		return id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public Member getMember() {
		return member;
	}

	public List<IssuedBook> getIssuedBook() {
		return issuedBook;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setIssuedBook(List<IssuedBook> issuedBook) {
		this.issuedBook = issuedBook;
	}
	
	
	
	
}



