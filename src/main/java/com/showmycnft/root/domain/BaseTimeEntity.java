package com.showmycnft.root.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 (createData, modifiedDate)칼럼으로 인식하도록할 것
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성되어 저장될 때 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 변경될 때 자동저장
    private LocalDateTime modifiedDate;
}
