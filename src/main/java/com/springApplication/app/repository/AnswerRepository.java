package com.springApplication.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springApplication.app.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAllByQuestionIdIn(List<Integer> questionIds);
    
 
}

