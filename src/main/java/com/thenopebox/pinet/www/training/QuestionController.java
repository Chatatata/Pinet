package com.thenopebox.pinet.www.training;

import com.thenopebox.pinet.training.question.exception.QuestionNotFoundException;
import com.thenopebox.pinet.training.question.model.Question;
import com.thenopebox.pinet.training.question.service.QuestionService;
import com.thenopebox.pinet.www.generic.AbstractController;
import com.thenopebox.pinet.www.training.request.CreateQuestionRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public final class QuestionController extends AbstractController {
    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Question> index() {
        return questionService.listQuestions();
    }

    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Question show(@PathVariable Long id) throws QuestionNotFoundException {
        return questionService.getQuestionById(id);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Question> create(@RequestBody CreateQuestionRequestModel requestModel) {
        final Question question =
                questionService.createQuestion(
                    requestModel.getContent(),
                    requestModel.getOptions(),
                    requestModel.getCorrectOptionIndex());

        return ResponseEntity.ok(question);
    }

    @DeleteMapping(value = "/{id}/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String delete(@PathVariable Long id) throws QuestionNotFoundException {
        questionService.deleteQuestionById(id);

        return "";
    }
}
