package io.dargenn.quizhouse.question;

import io.dargenn.quizhouse.survey.Survey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "questions")
    private Set<Survey> surveys = new HashSet<>();

    public Question() {
    }

    public Question(Long id, String title, Set<Survey> surveys) {
        this.id = id;
        this.title = title;
        this.surveys = surveys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(title, question.title) &&
                Objects.equals(surveys, question.surveys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, surveys);
    }
}
