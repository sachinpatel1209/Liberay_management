package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Issue;
import com.library.management.repository.IssueRepository;

@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;
	
	public List<Issue> getAll() {
		return issueRepository.findAll();
	}
	
	public Optional<Issue> getById(long id) {
		return issueRepository.findById(id);
	}
	
	
	public Issue save(Issue issue) {
		return issueRepository.save(issue);
	}

	
	
	
}
