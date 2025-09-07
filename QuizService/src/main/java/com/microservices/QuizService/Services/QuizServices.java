package com.microservices.QuizService.Services;

import com.microservices.QuizService.Entity.Quiz;

import java.util.List;

public interface QuizServices {
    Quiz add(Quiz quiz);
    List<Quiz> getAll();
    Quiz get(Long id);
}
