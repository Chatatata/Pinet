package com.thenopebox.pinet.www.training.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class CreateQuestionRequestModel {
    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private List<String> options;

    @Getter
    @Setter
    private int correctOptionIndex;
}
