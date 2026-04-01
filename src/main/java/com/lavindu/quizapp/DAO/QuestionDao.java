package com.lavindu.quizapp.DAO;

import org.springframework.stereotype.Repository;
import com.lavindu.quizapp.entity.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    
}
