package com.library.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{

	Optional<Issue> findById(Long id);

}
