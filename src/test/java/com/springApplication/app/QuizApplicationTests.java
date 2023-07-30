package com.springApplication.app;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springApplication.app.entity.Question;
import com.springApplication.app.entity.Quiz;
import com.springApplication.app.repository.QuizRepository;

@SpringBootTest
class QuizApplicationTests {
	
	@Autowired
	QuizRepository quizRepository;
	
	@Test
	void contextLoads() {
		
		Optional<Quiz> findById = quizRepository.findById(1);
		Quiz quiz = findById.get();
		
		List<Question> question = quiz.getQuestion();
		System.out.println(question);
		System.out.println(quiz.getTitle());
	}

}
