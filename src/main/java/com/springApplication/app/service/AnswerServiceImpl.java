package com.springApplication.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springApplication.app.entity.Answer;
import com.springApplication.app.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public List<Answer> getAllAnswersForQuestions(List<Integer> questionIds) {
		return answerRepository.findAllByQuestionIdIn(questionIds);
		
	}

	@Override
	public List<Answer> getAllAnswers() {
		// TODO Auto-generated method stub
		return answerRepository.findAll();
	}
	
	

}
