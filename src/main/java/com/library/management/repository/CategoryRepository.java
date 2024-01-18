package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
