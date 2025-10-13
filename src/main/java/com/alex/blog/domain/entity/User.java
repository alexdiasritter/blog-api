package com.alex.blog.domain.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    private String name;

    @Column(unique = true, name = "auth0_sub")
    private String auth0Sub;

    @Column(unique = true)
    private String email;

    @Column(name = "email_verified")
    private boolean emailVerified;

    @Column(name = "photo_url")
    private String photo_url;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts;

    @ManyToMany
    @JoinTable(name = "tb_post_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> likes;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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
    public String getPhoto_url() {
        return photo_url;
    }
    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
    public String getAuth0Sub() {
        return auth0Sub;
    }
    public void setAuth0Sub(String auth0Sub) {
        this.auth0Sub = auth0Sub;
    }
}
