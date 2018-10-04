package com.thenopebox.pinet.training.question.service;

import com.thenopebox.pinet.training.question.exception.QuestionNotFoundException;
import com.thenopebox.pinet.training.question.repository.OptionRepository;
import com.thenopebox.pinet.training.question.QuestionBuilder;
import com.thenopebox.pinet.training.question.repository.QuestionRepository;
import com.thenopebox.pinet.training.question.model.Option;
import com.thenopebox.pinet.training.question.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConcreteQuestionService implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public List<Question> listQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) throws QuestionNotFoundException {
        Optional<Question> question = questionRepository.findById(id);

        if (question.isPresent()) {
            return question.get();
        } else {
            throw new QuestionNotFoundException(id);
        }
    }

    @Override
    public Question createQuestion(String content, List<String> options, int correctOptionIndex) {
        final List<Option> optionsList = new ArrayList<>();

        for (String optionContent : options) {
            final Option option = new Option();

            option.setContent(optionContent);

            optionsList.add(option);
        }

        Question question =
                new QuestionBuilder()
                        .setContent(content)
                        .setOptions(optionsList)
                        .setCorrectOptionIndex(correctOptionIndex).createQuestion();

        questionRepository.save(question);

        for (Option eachOption : question.getOptions()) {
            optionRepository.save(eachOption);
        }

        return question;
    }

    @Override
    public void deleteQuestionById(Long id) throws QuestionNotFoundException {
        final Question question = getQuestionById(id);

        questionRepository.delete(question);
    }
}
