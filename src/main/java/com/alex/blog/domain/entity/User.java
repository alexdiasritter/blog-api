package com.alex.blog.domain.entity;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private UUID userId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(name = "",
            joinColumns = @JoinColumn(name = ""),
            inverseJoinColumns = @JoinColumn(name = ""))
    private List<Post> likes;

    @OneToMany(mappedBy = "")
    private List<Comment> comments;

    public User() {
    }

    public User(UUID userId, String name, String email, String password, List<Post> posts, List<Post> likes, List<Comment> comments) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.likes = likes;
        this.comments = comments;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getLikes() {
        return likes;
    }

    public void setLikes(List<Post> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
