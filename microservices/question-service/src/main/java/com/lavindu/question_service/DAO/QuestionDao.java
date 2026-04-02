package com.lavindu.question_service.DAO;

import org.springframework.stereotype.Repository;
import com.lavindu.question_service.entity.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(
        value = "SELECT * FROM question q WHERE q.category =:category ORDER BY RANDOM() LIMIT :numQuestions",
        nativeQuery = true
    )
    List<Question> findRandomQuestionsByCategory(String category, int numQuestions);
    
}
