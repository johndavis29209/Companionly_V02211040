package com.companionly.prototype.models;

import jakarta.persistence.*;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long questionId;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private String username; // To track which user submitted it

    public Response() {}

    public Response(Long questionId, int score, String username) {
        this.questionId = questionId;
        this.score = score;
        this.username = username;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
