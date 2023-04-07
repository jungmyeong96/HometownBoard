package com.showmycnft.root.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//어노테이션 필요없이 JpaRepository<Entity, PK>만 선언해도 CRUD를 구축해준단다 겁나 편해부러~
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
