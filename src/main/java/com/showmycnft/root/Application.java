package com.showmycnft.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트의 자동설정, 스프링 Bean읽기와 생성 모두 자동
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 was 실행
    }
}
