package com.lavindu.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavindu.quizapp.DAO.QuestionDao;
import com.lavindu.quizapp.entity.Question;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public void addQuestion(Question question) {
        questionDao.save(question);
    }
    
}
