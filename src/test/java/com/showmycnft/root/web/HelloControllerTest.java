package com.showmycnft.root.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링 부트 테스트와 JUnit의 연결자, SpringRunner 라는 스프링 실행자를 사용
@WebMvcTest(controllers = HelloController.class) //Web(Spring MVC)에 집중, controller만 테스트
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 bean 주입
    private MockMvc mvc; //웹 API를 테스트할 때 사용, 테스트 시작점

    @Test
    public void ReturnHello() throws Exception {
        String hello = "hello";

        //MockMvc를 통해 hello주소로 http get요청
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //결과 검증, 상태 체크
                .andExpect(content().string(hello)); //결과, 본문 내용 검증
    }
}