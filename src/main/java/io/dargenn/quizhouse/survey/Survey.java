package io.dargenn.quizhouse.survey;

import io.dargenn.quizhouse.question.Question;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SURVEY")
@Data
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    private String link;

    @ManyToMany
    @JoinTable(
            name = "QUESTION_SURVEY",
            joinColumns = {@JoinColumn(name = "SURVEY_ID")},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID")}
    )
    private Set<Question> questions = new HashSet<>();
}