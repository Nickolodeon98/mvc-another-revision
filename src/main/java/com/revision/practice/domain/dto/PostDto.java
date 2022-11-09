package com.revision.practice.domain.dto;


import com.revision.practice.domain.entity.Post;

public class PostDto {
    private Long id;
    private String title;
    private String contents;
    private String author;

    public Post toEntity() {
        return new Post(this.title, this.contents, this.author);
    }
}
