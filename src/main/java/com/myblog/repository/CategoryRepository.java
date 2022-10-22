package com.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myblog.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
