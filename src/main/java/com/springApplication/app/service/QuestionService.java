package com.springApplication.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springApplication.app.entity.Question;

public interface QuestionService {

	ResponseEntity<List<Question>> findAllQuestions();

	ResponseEntity<List<Question>> findAllQuestionsByCategeory(String categeory);

	ResponseEntity<Question> saveQuestion(Question question);
	
}
