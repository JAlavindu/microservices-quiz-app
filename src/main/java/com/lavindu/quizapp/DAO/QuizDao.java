package com.lavindu.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lavindu.quizapp.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
    

}
