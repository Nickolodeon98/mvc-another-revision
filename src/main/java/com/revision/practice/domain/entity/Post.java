package com.revision.practice.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="board")
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;
    private String author;

    public Post(String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
}
