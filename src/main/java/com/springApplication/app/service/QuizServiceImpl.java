package com.springApplication.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springApplication.app.entity.Answer;
import com.springApplication.app.entity.Question;
import com.springApplication.app.entity.Quiz;
import com.springApplication.app.entity.UserAnswer;
import com.springApplication.app.repository.AnswerRepository;
import com.springApplication.app.repository.QuizRepository;
import com.springApplication.app.repository.QustionRepositiory;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private QustionRepositiory qustionRepositiory;
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public ResponseEntity<String> createQuizByCategeory(String categeory, int numQ, String title) {

		List<Question> findRandomQuestionByCategeory = qustionRepositiory.findRandomQuestionByCategeory(categeory,
				numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(findRandomQuestionByCategeory);
		quizRepository.save(quiz);
		return new ResponseEntity<String>("Sucessfull", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Question>> getAllQuestionsByQuizId(Integer id) {
		Quiz quizData = quizRepository.findById(id).get();
		List<Question> question = quizData.getQuestion();

		return new ResponseEntity<List<Question>>(question, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> submitAndValidateScore(Integer id, List<UserAnswer> userAnswers) {
		
		List<Integer> questionIds = new ArrayList<>();
		for (UserAnswer userData : userAnswers) {
			questionIds.add(userData.getQuestionId());
		}

		List<Answer> correctAnswers = answerRepository.findAllByQuestionIdIn(questionIds);
		int score = 0;
		for (Answer answers : correctAnswers) {
			Integer questionId = answers.getQuestion().getId();
			for (UserAnswer userAnswer : userAnswers) {
				if (userAnswer.getQuestionId() == questionId
						&& userAnswer.getAnswer().equals(answers.getRightAnswer())) {
					score++;
				}

			}
		}
		return new ResponseEntity<String>("Your Final Score is " + score, HttpStatus.OK);
	}

}
