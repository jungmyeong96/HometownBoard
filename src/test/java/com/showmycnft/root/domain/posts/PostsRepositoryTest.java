package com.showmycnft.root.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest //별 다른 설정 없이 SpringBootTest를 사용할 경우 H2 데이터베이스를 자동으로 실행해줍니다.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void testPostSaveLoad() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // insert/update
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("gkswndaud@gmail.com") //향후 환경변수로 수정할 것
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}