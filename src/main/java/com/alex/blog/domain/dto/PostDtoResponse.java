package com.alex.blog.domain.dto;

import java.time.LocalDateTime;

public record PostDtoResponse(Long id, LocalDateTime postDateTime, String title, String text, String urlImageS3, Long authorId, String photo_url) {
}
