package com.showmycnft.root.web.dto;

import com.showmycnft.root.domain.posts.Posts;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PostsResponseDtoTest {

    @Test
    public void ConstructorTest() {
        //given
        Long id = 1L;
        String title = "TITLE";
        String content = "CONTENT";
        String author = "AUTHOR";

        Posts post = new Posts();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);

        //when
        PostsResponseDto responseDto = new PostsResponseDto(post);

        //then
        assertEquals(id, responseDto.getId());
        assertEquals(title, responseDto.getTitle());
        assertEquals(author, responseDto.getAuthor());
        assertEquals(content, responseDto.getContent());
    }



}