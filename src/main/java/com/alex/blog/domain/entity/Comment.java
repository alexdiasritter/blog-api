package com.alex.blog.domain.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID commentId;

    private String text;
    private LocalDateTime commentDateTime;

    @ManyToOne
    @JoinColumn(name = "")
    private User author;

    @ManyToOne
    @JoinColumn(name = "")
    private Post post;

    public Comment() {
    }

    public Comment(UUID commentId, String text, LocalDateTime commentDateTime, User author, Post post) {
        this.commentId = commentId;
        this.text = text;
        this.commentDateTime = commentDateTime;
        this.author = author;
        this.post = post;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCommentDateTime() {
        return commentDateTime;
    }

    public void setCommentDateTime(LocalDateTime commentDateTime) {
        this.commentDateTime = commentDateTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
