package com.alex.blog.service;

import com.alex.blog.domain.dto.PostDtoRequest;
import com.alex.blog.domain.dto.PostDtoResponse;
import com.alex.blog.domain.entity.Post;
import com.alex.blog.domain.entity.User;
import com.alex.blog.repository.PostRepository;
import com.alex.blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import static org.springframework.boot.autoconfigure.container.ContainerImageMetadata.isPresent;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }
    public Long doPost(PostDtoRequest dto, String auth0Sub) {
        User user = userRepository.findByAuth0Sub(auth0Sub)
                .orElseGet(() -> createUserFromAuth0(auth0Sub)); // cria se não existir

        Post post = new Post(dto);
        post.setAuthor(user);

        Post saved = postRepository.save(post);
        return saved.getPost_id();
    }

    private User createUserFromAuth0(String auth0Sub) {
        // buscar os dados do usuário no Auth0 via Management API
        User user = new User();
        user.setAuth0Sub(auth0Sub);
        user.setName("Usuário " + auth0Sub); // temporário
        return userRepository.save(user);
    }
}
