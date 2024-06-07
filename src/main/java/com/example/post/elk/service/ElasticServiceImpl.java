package com.example.post.elk.service;

import com.example.post.elk.domain.document.PostDocument;
import com.example.post.elk.domain.dto.KafkaStatus;
import com.example.post.elk.domain.dto.request.PostRequest;
import com.example.post.elk.domain.dto.response.PostSearchResponse;
import com.example.post.elk.domain.repository.PostDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElasticServiceImpl implements ElasticService{
    private final PostDocumentRepository postDocumentRepository;

    @Override
    public List<PostSearchResponse> searchPostsByContent(String req) {
        return postDocumentRepository.findByContent(req).stream().map(PostSearchResponse::from).toList();
    }

    @Override
    public void addPostData(PostRequest req) {
        postDocumentRepository.save(req.toDocument());
    }

    @Override
    @KafkaListener(topics = "post-events")
    public void listener(KafkaStatus<PostRequest> status) {
        switch (status.status()){
            case "insertPost" -> addPostData(status.data());
            case "deletePost" -> {}
        }
    }
}
