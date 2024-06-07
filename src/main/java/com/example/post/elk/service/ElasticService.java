package com.example.post.elk.service;

import com.example.post.elk.domain.dto.KafkaStatus;
import com.example.post.elk.domain.dto.request.PostRequest;
import com.example.post.elk.domain.dto.response.PostSearchResponse;

import java.util.List;

public interface ElasticService {
    List<PostSearchResponse> searchPostsByContent(String req);
    void addPostData(PostRequest req);

    void listener(KafkaStatus<PostRequest> status);
}
