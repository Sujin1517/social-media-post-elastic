package com.example.post.elk.domain.repository;

import com.example.post.elk.domain.document.PostDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDocumentRepository
        extends ElasticsearchRepository<PostDocument, Long> {
    List<PostDocument> findByContent(String content);
}
