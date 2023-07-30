package com.springApplication.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categeory;
	private String difficultylevel;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String questionTitle;	
	@OneToOne(mappedBy = "question")
	@JsonIgnore
	private Answer answer;

}
