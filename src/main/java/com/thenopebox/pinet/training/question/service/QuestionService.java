package com.thenopebox.pinet.training.question.service;

import com.thenopebox.pinet.training.question.exception.QuestionNotFoundException;
import com.thenopebox.pinet.training.question.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> listQuestions();

    Question getQuestionById(Long id) throws QuestionNotFoundException;

    Question createQuestion(String content, List<String> options, int correctOptionIndex);

    void deleteQuestionById(Long id) throws QuestionNotFoundException;
}
