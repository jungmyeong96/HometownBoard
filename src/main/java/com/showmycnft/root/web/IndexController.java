package com.showmycnft.root.web;

import com.showmycnft.root.config.auth.LoginUser;
import com.showmycnft.root.config.auth.dto.SessionUser;
import com.showmycnft.root.service.posts.PostsService;
import com.showmycnft.root.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index() {
        return "landing"; // mustache 스타터가 앞의 경로와 확장자를 자동으로 지정
    }

    @GetMapping("/index") // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다!
    public String 동(Model model, @LoginUser SessionUser user) { // 기존 세션 정보 값 가져오는 중복 실행 함수를 어노테이션으로 대체
        model.addAttribute("posts", postsService.findAllDesc()); //데이터를 posts에 담아 저장

        if (user != null) {
            model.addAttribute("userName", user.getName()); //세션에 저장된 값이 있을 때만 model에 userName으로 등록
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save"; //posts-save.mustache 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}