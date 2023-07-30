package com.springApplication.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springApplication.app.entity.Question;
import com.springApplication.app.entity.UserAnswer;

public interface QuizService {

	ResponseEntity<String> createQuizByCategeory(String categeory, int numQ, String title);

	ResponseEntity<List<Question>> getAllQuestionsByQuizId(Integer id);

	ResponseEntity<String> submitAndValidateScore(Integer id, List<UserAnswer> userAnswers);

	
}
