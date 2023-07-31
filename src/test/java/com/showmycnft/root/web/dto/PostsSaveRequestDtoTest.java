package com.showmycnft.root.web.dto;

import com.showmycnft.root.domain.posts.Posts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostsSaveRequestDtoTest {

    @DisplayName("Posts Save 생성자 테스트")
    @Test
    public void testPostsSaveRequestDto() {
        //Given
        String title = "title";
        String content = "content";
        String author = "author";

        //When
        PostsSaveRequestDto dto = new PostsSaveRequestDto().builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        //Then
        assertThat(dto.getTitle()).isEqualTo(title);
        assertThat(dto.getContent()).isEqualTo(content);
        assertThat(dto.getAuthor()).isEqualTo(author);
    }

    @DisplayName("toEntity 함수 테스트")
    @Test
    public void testToEntity() {
        //Given
        String title = "title";
        String content = "content";
        String author = "author";

        //When
        PostsSaveRequestDto dto = new PostsSaveRequestDto().builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
        Posts post = dto.toEntity();

        //Then
        assertThat(dto.getTitle()).isEqualTo(post.getTitle());
        assertThat(dto.getContent()).isEqualTo(post.getContent());
        assertThat(dto.getAuthor()).isEqualTo(post.getAuthor());
    }

}