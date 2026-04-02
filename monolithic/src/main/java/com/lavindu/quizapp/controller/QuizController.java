package com.lavindu.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lavindu.quizapp.entity.Question;
import com.lavindu.quizapp.entity.QuestionWrapper;
import com.lavindu.quizapp.entity.Response;
import com.lavindu.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQuestions, @RequestParam String title) {
        return quizService.createQuiz(category, numQuestions, title);
    }
    
    @GetMapping("get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer quizId) {
        return quizService.getQuizQuestions(quizId);
    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer quizId, @RequestBody List<Response> responses) {
        ResponseEntity<Integer> score = quizService.calculateScore(quizId, responses);
        return score;
    }
}