package com.revision.practice.controller;

import com.revision.practice.domain.dto.PostDto;
import com.revision.practice.domain.entity.Post;
import com.revision.practice.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public String selectSingleRecord(@PathVariable Long id, Model model) {
        Optional<Post> postOpt = postRepository.findById(id);
        if (postOpt.isPresent()) {
            model.addAttribute("post", postOpt.get());
            return "board/show";
        } else return "error";
    }

    @GetMapping("/all")
    public String showAllRecords(Model model) {
        List<Post> allPosts = postRepository.findAll();
        model.addAttribute("posts", allPosts);
        return "board/list";
    }
}
