package com.springApplication.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springApplication.app.entity.Question;

public interface QustionRepositiory extends JpaRepository<Question, Integer> {

	
	List<Question> findAllQuestionByCategeory(String categeory);

	@Query(
			  value = "SELECT * FROM question q WHERE q.categeory=:categeory ORDER BY RAND() limit :numQ", 
			  nativeQuery = true)
	
	List<Question> findRandomQuestionByCategeory(String categeory, int numQ);

}
