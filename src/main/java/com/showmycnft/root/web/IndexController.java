package com.showmycnft.root.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // mustache 스타터가 앞의 경로와 확장자를 자동으로 지정
    }
}