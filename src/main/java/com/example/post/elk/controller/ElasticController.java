package com.example.post.elk.controller;

import com.example.post.elk.domain.dto.response.PostSearchResponse;
import com.example.post.elk.service.ElasticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class ElasticController {
    private final ElasticService elasticService;

    @GetMapping("/{content}")
    public List<PostSearchResponse> searchPostsByContent(@PathVariable String content) {
        return elasticService.searchPostsByContent(content);
    }
}
