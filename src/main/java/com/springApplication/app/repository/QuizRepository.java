package com.springApplication.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springApplication.app.entity.Quiz;


public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
