package com.showmycnft.root.web.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostsUpdateRequestDtoTest {
    @DisplayName("POST 업데이트 생성자 테스트")
    @Test
    public void testPostsUpdateRequestDto() {
        //Given
        String title = "Test Title";
        String content = "Test Content";

        //When
        PostsUpdateRequestDto dto = new PostsUpdateRequestDto().builder()
                .title(title)
                .content(content)
                .build();

        //Then
        assertThat(dto.getTitle()).isEqualTo(title);
        assertThat(dto.getContent()).isEqualTo(content);
    }

    // 의미없음
//    @DisplayName("Builder Tostring 테스트")
//    @Test
//    public final void testToString() {
//        assertTrue(new PostsUpdateRequestDto().toString().contains("@"));
//    }

}