package com.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myblog.model.Subject;

@Repository
public interface subjectRepository extends JpaRepository<Subject, Long> {

}
