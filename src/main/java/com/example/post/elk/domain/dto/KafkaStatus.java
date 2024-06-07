package com.example.post.elk.domain.dto;

public record KafkaStatus<T>(
        T data,
        String status
) {
}
