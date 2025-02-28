package com.companionly.prototype.models;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "forum_replies")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reply_content", nullable = false, columnDefinition = "TEXT")
    private String replyContent;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Column(name = "reply_created", nullable = false, updatable = false)
    private Timestamp replyCreated;

    @PrePersist
    protected void onCreate() {
        replyCreated = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReplyContent() { return replyContent; }
    public void setReplyContent(String replyContent) { this.replyContent = replyContent; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }

    public Timestamp getReplyCreated() { return replyCreated; }
}
