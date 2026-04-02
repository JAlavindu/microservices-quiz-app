package com.lavindu.quiz_service.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lavindu.quiz_service.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
    

}
