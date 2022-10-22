package com.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myblog.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
