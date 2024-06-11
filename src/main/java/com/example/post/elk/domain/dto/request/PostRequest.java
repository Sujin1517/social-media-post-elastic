package com.example.post.elk.domain.dto.request;

import com.example.post.elk.domain.document.PostDocument;

import java.util.Date;
import java.util.UUID;

public record PostRequest (
        Long postId,
        UUID userId,
        String content,
        Long likeNum,
        Long scrapNum,
        Date createdAt,
        String file,
        String fileType,
        Boolean isDisable
){
        public PostDocument toDocument() {
            return new PostDocument(
                    null,
                    postId,
                    userId,
                    content,
                    likeNum,
                    scrapNum,
                    createdAt,
                    file,
                    fileType
            );
        }
}
