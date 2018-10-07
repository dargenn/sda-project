package io.dargenn.quizhouse.answer;

import io.dargenn.quizhouse.question.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ANSWER")
@Data
@NoArgsConstructor
public class Answer {
    @Id
    private Long id;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean correct;

    private String userAnswer;

    private Integer scale;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;
}