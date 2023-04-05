package com.showmycnft.root.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //json을 반환하는 컨트롤러로 만들어줍니다.
public class HelloController {
    @GetMapping("/hello") //Get 라우팅
    public String hello() {
        return "hello";
    }
}