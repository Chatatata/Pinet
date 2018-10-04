package com.thenopebox.pinet.training.question.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "question_options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    @NotNull
    @JsonIgnore
    @Getter
    @Setter
    private Question question;

    @Column(name = "content", nullable = false)
    @NotNull
    @Getter
    @Setter
    private String content;

    @Column(name = "is_correct_option", nullable = false)
    @NotNull
    @Getter
    @Setter
    private Boolean correctOption;

    public Option() {
        this.correctOption = false;
    }
}
