package com.showmycnft.root.web;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("랜딩페이지 테스트")
    @Test
    public void testLandingPage() {

        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("HometownBoard");
    }

    @DisplayName("인덱스 페이지 이동 테스트")
    @Test
    public void testLoadingMainPage() {

        //when
        //this.restTemplate.postForObject("/index", String.class);


        //then
        //assertThat(body).contains("글 등록하기");
    }

}
