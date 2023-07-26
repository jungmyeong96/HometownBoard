package com.showmycnft.root.web.dto;

import com.showmycnft.root.domain.posts.Posts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PostsListResponseDtoTest {

    @DisplayName("PostsListResponseDto 생성자 테스트")
    @Test
    public  void ConstructorTest() {

        //given
        Long id = 1L;
        String title = "TITLE";
        String author = "AUTHOR";
        LocalDateTime modifiedDate = LocalDateTime.now();

        Posts posts = new Posts();
        posts.setId(id);
        posts.setTitle(title);
        posts.setAuthor(author);
        posts.setModifiedDate(modifiedDate);


        //when
        PostsListResponseDto responseDto = new PostsListResponseDto(posts);

        // Then
        assertEquals(id, responseDto.getId());
        assertEquals(title, responseDto.getTitle());
        assertEquals(author, responseDto.getAuthor());
        assertEquals(modifiedDate, responseDto.getModifiedDate());
    }
}