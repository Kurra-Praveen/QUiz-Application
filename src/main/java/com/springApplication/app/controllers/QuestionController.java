package com.springApplication.app.controllers;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springApplication.app.entity.Question;
import com.springApplication.app.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> getAllQuestions() {

		return questionService.findAllQuestions();
	}

	@GetMapping("categeory/{categeory}")
	public ResponseEntity<List<Question>> getAllQuestionByCategeory(@PathVariable String categeory) {

		return questionService.findAllQuestionsByCategeory(categeory);
	}

	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {

		return questionService.saveQuestion(question);
	}
}
