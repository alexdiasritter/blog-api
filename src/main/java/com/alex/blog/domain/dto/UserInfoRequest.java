package com.alex.blog.domain.dto;
import org.springframework.security.oauth2.jwt.Jwt;

public record UserInfoRequest(String sub, String name, String email, boolean emailVerified) {

    public static UserInfoRequest from(Jwt jwt) {
        return new UserInfoRequest(
                jwt.getSubject(),
                jwt.getClaim("name"),
                jwt.getClaim("email"),
                Boolean.TRUE.equals(jwt.getClaim("email_verified"))
        );
    }

}