package com.lavindu.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lavindu.quizapp.DAO.QuestionDao;
import com.lavindu.quizapp.DAO.QuizDao;
import com.lavindu.quizapp.entity.Question;
import com.lavindu.quizapp.entity.QuestionWrapper;
import com.lavindu.quizapp.entity.Quiz;
import com.lavindu.quizapp.entity.Response;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQuestions, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        Quiz quiz = quizDao.findById(quizId).orElse(null);
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        for (Question question : quiz.getQuestions()) {
            QuestionWrapper qw = new QuestionWrapper();
            qw.setId(question.getId());
            qw.setQuestionTitle(question.getQuestionTitle());
            qw.setOption1(question.getOption1());
            qw.setOption2(question.getOption2());
            qw.setOption3(question.getOption3());
            qw.setOption4(question.getOption4());
            questionWrappers.add(qw);
        }
        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(Integer quizId, List<Response> responses) {
        Quiz quiz = quizDao.findById(quizId).orElse(null);
        List<Question> questions = quiz.getQuestions();
        int right= 0;
        int i = 0;
        
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }




}
