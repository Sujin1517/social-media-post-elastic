package com.example.post.elk.domain.dto.response;

import com.example.post.elk.domain.document.PostDocument;

import java.util.Date;
import java.util.UUID;

public record PostSearchResponse(
        Long id,
        UUID userId,
        String content,
        Long likeNum,
        Long scrapNum,
        Date createdAt,
        String file,
        String fileType
) {
    public static PostSearchResponse from(PostDocument post) {
        return new PostSearchResponse(
                post.getId(),
                post.getUserId(),
                post.getContent(),
                post.getLikeNum(),
                post.getScrapNum(),
                post.getCreatedAt(),
                post.getFile(),
                post.getFileType()
        );
    }
}
