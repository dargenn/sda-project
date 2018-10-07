package io.dargenn.quizhouse.question;

import io.dargenn.quizhouse.answer.Answer;
import io.dargenn.quizhouse.survey.Survey;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "QUESTION")
@Data
public class Question {
    @Id
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "questions")
    private Set<Survey> surveys = new HashSet<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Answer> answers = new HashSet<>();
}
