package com.lavindu.quiz_service.DTO;

import lombok.Data;


@Data
public class QuizDto {
    String categoryName;
    Integer numQuestions;
    String title;
}
