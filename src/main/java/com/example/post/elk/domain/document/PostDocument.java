package com.example.post.elk.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.UUID;

@Document(indexName = "post")
@AllArgsConstructor
@Getter @Builder
public class PostDocument {
    @Id @Field(type = FieldType.Text)
    private Long id;

    @Field(type = FieldType.Text)
    UUID userId;

    @Field(type = FieldType.Text)
    String content;

    @Field(type = FieldType.Long)
    Long likeNum;

    @Field(type = FieldType.Long)
    Long scrapNum;

    @Field(type = FieldType.Date)
    Date createdAt;

    @Field(type = FieldType.Text)
    String file;

    @Field(type = FieldType.Text)
    String fileType;
}
