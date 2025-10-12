package com.alex.blog.controller;
import com.alex.blog.domain.dto.UserInfoRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public UserInfoRequest me(@AuthenticationPrincipal Jwt jwt) {
        return UserInfoRequest.from(jwt);
    }

}
