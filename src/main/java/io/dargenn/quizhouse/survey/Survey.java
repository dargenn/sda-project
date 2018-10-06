package io.dargenn.quizhouse.survey;

import io.dargenn.quizhouse.question.Question;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SURVEY")
public class Survey {
    @Id
    private Long id;

    private String title;

    private String description;

    private Date creationDate;

    private Date expirationDate;

    private String link;

    @ManyToMany
    @JoinTable(
            name = "QUESTION_SURVEY",
            joinColumns = {@JoinColumn(name = "SURVEY_ID")},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID")}
    )
    private Set<Question> questions = new HashSet<>();

    public Survey() {
    }

    public Survey(Long id, String title, String description, Date creationDate, Date expirationDate, String link, Set<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.link = link;
        this.questions = questions;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}