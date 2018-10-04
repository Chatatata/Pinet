package com.thenopebox.pinet.training.question;

import com.thenopebox.pinet.training.question.model.Option;
import com.thenopebox.pinet.training.question.model.Question;

import java.util.List;

public class QuestionBuilder {
    private String content;
    private List<Option> options;
    private int correctOptionIndex;

    public QuestionBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public QuestionBuilder setOptions(List<Option> options) {
        this.options = options;

        return this;
    }

    public QuestionBuilder setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
        return this;
    }

    public Question createQuestion() {
        final Question question = new Question();

        question.setContent(content);
        question.setOptions(options);

        for (Option eachOption : options) {
            eachOption.setQuestion(question);
        }

        if (correctOptionIndex < options.size()) {
            options.get(correctOptionIndex).setCorrectOption(true);
        } else {
            throw new IndexOutOfBoundsException();
        }

        return question;
    }
}