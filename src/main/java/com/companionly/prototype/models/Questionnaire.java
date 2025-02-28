package com.companionly.prototype.models;


import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "questions")
@Entity
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, unique = true, length = 200)
    public String question;

    //constructor
    public  Questionnaire(long id, String question) {
        this.id = id;
        this.question = question;
    }

    public Questionnaire() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getID() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
