package com.Josh.QuizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Josh.QuizApp.support.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
	
}
 