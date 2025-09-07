package com.microservices.QuizService.Services.Impl;

import com.microservices.QuizService.Entity.Quiz;
import com.microservices.QuizService.Repository.QuizRepo;
import com.microservices.QuizService.Services.QuestionClient;
import com.microservices.QuizService.Services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizServices {

//    we can also use @Autowired
    private QuizRepo quizRepo;

    public QuizServiceImpl(QuizRepo quizRepo){
        this.quizRepo=quizRepo;
    }

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes=quizRepo.findAll();
        return quizzes.stream().map(quiz->{
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz=quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
