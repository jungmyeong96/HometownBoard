package com.showmycnft.root.web;

import com.showmycnft.root.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다!
        model.addAttribute("posts", postsService.findAllDesc()); //데이터를 posts에 담아 저장
        return "index"; // mustache 스타터가 앞의 경로와 확장자를 자동으로 지정
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save"; //posts-save.mustache 호출
    }
}