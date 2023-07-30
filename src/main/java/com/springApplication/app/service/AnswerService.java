package com.springApplication.app.service;

import java.util.List;

import com.springApplication.app.entity.Answer;

public interface AnswerService {

	List<Answer> getAllAnswersForQuestions(List<Integer> questionIds);
	List<Answer>getAllAnswers();
}
