package com.microservices.QuestionService.Controller;

import com.microservices.QuestionService.Entity.Question;
import com.microservices.QuestionService.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping("/get-all")
    public List<Question> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/get/{id}")
    public Question get(@PathVariable Long id){
        return questionService.get(id);
    }

    @GetMapping("/quiz=/{quizId}")
    public List<Question> findByQuizId(@PathVariable Long quizId){
        return questionService.getByQuizId(quizId);
    }
}
