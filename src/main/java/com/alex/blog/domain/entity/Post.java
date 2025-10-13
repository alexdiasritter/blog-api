package com.alex.blog.domain.entity;
import com.alex.blog.domain.dto.PostDtoRequest;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long post_id;

    private LocalDateTime postDateTime;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String text;

    private String urlImageS3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentsList;

    @OneToMany(mappedBy = "likes")
    private List<User> likes;

    private String photo_url;

    public Post(PostDtoRequest dto) {
        this.postDateTime = dto.postDateTime();
        this.title = dto.title();
        this.text = dto.text();
        this.urlImageS3 = dto.urlImageS3();
        this.photo_url = dto.photo_url();
    }

    public Long getPost_id() {
        return post_id;
    }
    public void setPost_id(Long post_id) {
        this.post_id = post_id;
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
    public String getPhoto_url() {
        return photo_url;
    }
    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}