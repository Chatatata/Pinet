package com.thenopebox.pinet.training.question.model;

import com.thenopebox.pinet.training.question.model.Option;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Getter
    private Long id;

    @Column(name = "content", nullable = false)
    @NotNull
    @Getter
    @Setter
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    @NotNull
    @Getter
    @Setter
    private List<Option> options;

    @Column(name = "inserted_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    private Date insertedAt;

    public Question() {
        this.insertedAt = new Date();
    }
}
