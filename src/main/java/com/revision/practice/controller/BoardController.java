package com.revision.practice.controller;

import com.revision.practice.domain.dto.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @PostMapping("/new")
    public String createANewPost(PostDto postDto) {

        return "board/new";
    }

}
