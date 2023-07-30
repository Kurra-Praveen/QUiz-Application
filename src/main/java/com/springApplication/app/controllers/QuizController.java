package com.springApplication.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springApplication.app.entity.Answer;
import com.springApplication.app.entity.Question;
import com.springApplication.app.entity.UserAnswer;
import com.springApplication.app.service.AnswerService;
import com.springApplication.app.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired private QuizService quizService;	
	@Autowired private AnswerService answerService;

	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String categeory, @RequestParam int numQ,
			@RequestParam String title) {
		return quizService.createQuizByCategeory(categeory, numQ, title);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Question>>getQuestionsByQuizId(@PathVariable Integer id){
		
		return quizService.getAllQuestionsByQuizId(id);
	}
	
	@GetMapping("answers")
	public ResponseEntity<List<Answer>>getAllAnswers(){
		
		return new ResponseEntity<List<Answer>>(answerService.getAllAnswersForQuestions(Arrays.asList(1,2,4)), HttpStatus.OK);

	}
	
	@GetMapping("allAnswers")
	public ResponseEntity<List<Answer>>getAllAnswers1(){
		
		return new ResponseEntity<List<Answer>>(answerService.getAllAnswers(), HttpStatus.OK);

	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<String>submitQuiz(@PathVariable Integer id, @RequestBody List<UserAnswer> userAnswers){
		
		return quizService.submitAndValidateScore(id,userAnswers);
		
	}
	
}
