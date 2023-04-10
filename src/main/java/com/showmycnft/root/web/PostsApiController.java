package com.showmycnft.root.web;

import com.showmycnft.root.service.posts.PostsService;
import com.showmycnft.root.web.dto.PostsResponseDto;
import com.showmycnft.root.web.dto.PostsSaveRequestDto;
import com.showmycnft.root.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    //생성자 주입형 의존성 주입 (롬복으로 생성자 자동생성)
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id)
    {
        return postsService.findById(id);
    }

}
