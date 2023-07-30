package com.springApplication.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springApplication.app.entity.Question;
import com.springApplication.app.repository.QustionRepositiory;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QustionRepositiory qustionRepositiory;

	@Override
	public ResponseEntity<List<Question>> findAllQuestions() {
		
		try {
			List<Question> findAll = qustionRepositiory.findAll();
			return new ResponseEntity<List<Question>>(findAll, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<Question> saveQuestion(Question question) {
		try {
			Question save = qustionRepositiory.save(question);
			return new ResponseEntity<Question>(save, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Question>(new Question(), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Question>> findAllQuestionsByCategeory(String categeory) {

		try {
			List<Question> findAllQuestionByCategeory = qustionRepositiory.findAllQuestionByCategeory(categeory);
			return new ResponseEntity<List<Question>>(findAllQuestionByCategeory, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

}
