package com.alex.blog.domain.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID postId;

    private LocalDateTime postDateTime;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    private String urlImageS3;

    private User author;

    @OneToMany(mappedBy = "")
    private List<Comment> commentsList;

    @OneToMany(mappedBy = "")
    private List<User> likes;

    public Post() {
    }

    public Post(UUID postId, LocalDateTime postDateTime, String title, String text, String urlImageS3, User author, List<Comment> commentsList) {
        this.postId = postId;
        this.postDateTime = postDateTime;
        this.title = title;
        this.text = text;
        this.urlImageS3 = urlImageS3;
        this.author = author;
        this.commentsList = commentsList;
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrlImageS3() {
        return urlImageS3;
    }

    public void setUrlImageS3(String urlImageS3) {
        this.urlImageS3 = urlImageS3;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }
}