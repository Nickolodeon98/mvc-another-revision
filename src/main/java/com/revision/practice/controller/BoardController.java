package com.revision.practice.controller;

import com.revision.practice.domain.dto.PostDto;
import com.revision.practice.domain.entity.Post;
import com.revision.practice.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final PostRepository postRepository;

    public BoardController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/new")
    public String createANewPost() {
        return "board/new";
    }

    @PostMapping("")
    public String createRecord(PostDto postDto) {
        Post savedPost = postRepository.save(postDto.toEntity());
        log.info("GeneratedId:{}", savedPost.getId());
        return "";
    }

}
