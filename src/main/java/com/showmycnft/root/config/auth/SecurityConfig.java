package com.showmycnft.root.config.auth;

import com.showmycnft.root.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity //Spring Security 설정을 활성화하는 어노테이션
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() //h2 console 화면을 사용하기 위해 해당 옵션들을 사용하지 않을 것 입니다.
                .and()
                    .authorizeRequests(a -> a //URL별 권한 관리를 설정하는 옵션, antMatchers옵션 사용하기 위함
                    .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //권한 관리 대상을 지정
                    .requestMatchers("/api/v1/**").hasRole(Role.USER.name()) //RBAC
                    .anyRequest().authenticated()) //나머지 처리 authenticated()를 추가해서 나머지는 모두 인증된 사용자들에게만 허용하게함
                    .logout()
                    .logoutSuccessUrl("/") //로그아웃 기능에 대한 여러 설정의 진입점이고 로그아웃 시 /로 이동
                .and()
                    .oauth2Login()
                    .userInfoEndpoint() //OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                    .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록

        return http.build();
    }
}
