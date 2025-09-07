package com.microservices.QuizService.Controller;

import com.microservices.QuizService.Entity.Quiz;
import com.microservices.QuizService.Services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class quizController {
    @Autowired
    private QuizServices quizServices;

    @PostMapping("add")
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizServices.add(quiz);
    }

    @GetMapping("get-all")
    public List<Quiz> getAll(){
        return quizServices.getAll();
    }

    @GetMapping("get/{id}")
    public Quiz get(@PathVariable Long id){
        return quizServices.get(id);
    }
}
