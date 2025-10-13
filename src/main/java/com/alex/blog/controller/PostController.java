package com.alex.blog.controller;
import com.alex.blog.domain.dto.PostDtoRequest;
import com.alex.blog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostDtoRequest dto, @AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();
        if (dto.title() == null || dto.title().isBlank()) {
            return ResponseEntity.badRequest().body("Invalid post data");
        }
        Long idPost = postService.doPost(dto, userId);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(idPost)
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
