package com.microservices.QuestionService.Services.Impl;

import com.microservices.QuestionService.Entity.Question;
import com.microservices.QuestionService.Repository.QuestionRepo;
import com.microservices.QuestionService.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepo.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getByQuizId(Long id) {
        return questionRepo.findByQuizId(id);
    }
}
