package io.dargenn.quizhouse.question;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.dargenn.quizhouse.answer.Answer;
import io.dargenn.quizhouse.survey.Survey;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "QUESTION")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "questions")
    private Set<Survey> surveys = new HashSet<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Answer> answers = new ArrayList<>();
}
