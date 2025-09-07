package com.microservices.QuestionService.Repository;

import com.microservices.QuestionService.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> findByQuizId(Long quizId);
}
