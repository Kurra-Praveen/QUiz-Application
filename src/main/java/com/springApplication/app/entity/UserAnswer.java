package com.springApplication.app.entity;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Data;

@Data
public class UserAnswer {

    private Integer questionId;
    private String answer;
}
