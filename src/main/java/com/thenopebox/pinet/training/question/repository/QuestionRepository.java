package com.thenopebox.pinet.training.question.repository;

import com.thenopebox.pinet.training.question.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository  extends CrudRepository<Question, Long> {
    List<Question> findAll();

    Optional<Question> findById(Long id);

    Question save(Question question);
}
