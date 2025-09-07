package com.microservices.QuestionService.Services;

import com.microservices.QuestionService.Entity.Question;

import java.util.List;

public interface QuestionService {

    Question create (Question question);
    List<Question> getAll();
    Question get(Long id);
    List<Question> getByQuizId(Long id);

}
