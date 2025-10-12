package com.alex.blog.domain.dto;
import org.springframework.security.oauth2.jwt.Jwt;

public record UserInfoResponse(String sub, String name, String email, boolean emailVerified) {

    public static UserInfoResponse from(Jwt jwt) {
        return new UserInfoResponse(
                jwt.getSubject(),
                jwt.getClaim("name"),
                jwt.getClaim("email"),
                Boolean.TRUE.equals(jwt.getClaim("email_verified"))
        );
    }

}