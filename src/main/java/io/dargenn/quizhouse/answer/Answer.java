package io.dargenn.quizhouse.answer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.dargenn.quizhouse.question.Question;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ANSWER")
@Data
@NoArgsConstructor
@ToString(exclude = "question")
@EqualsAndHashCode(exclude = "question")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean correct;

    private String userAnswer;

    private Integer scale;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    @JsonBackReference
    private Question question;
}