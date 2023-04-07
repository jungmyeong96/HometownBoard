package com.showmycnft.root;
import com.showmycnft.root.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json을 반환하는 컨트롤러로 만들어줍니다.
public class HelloController {
    @GetMapping("/hello") //Get 라우팅
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto") //Get 라우팅
    public HelloResponseDto helloDto(@RequestParam("name") String name
            , @RequestParam("amount") int amount) { //RequestParam: 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        return new HelloResponseDto(name, amount);
    }
}