package com.showmycnft.root.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@NoArgsConstructor //기본 생성자 자동추가
@Entity //테이블과 링크될 클래스
public class Posts {

    @Id //해당 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성 , 어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있습니다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
