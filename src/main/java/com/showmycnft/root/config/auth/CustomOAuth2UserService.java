package com.showmycnft.root.config.auth;

import com.showmycnft.root.config.auth.dto.OAuthAttributes;
import com.showmycnft.root.config.auth.dto.SessionUser;
import com.showmycnft.root.domain.user.User;
import com.showmycnft.root.domain.user.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService
        implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User>
                delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.
                loadUser(userRequest);

        String registrationId = userRequest.
                getClientRegistration().getRegistrationId(); // 현재 로그인 진행중인 서비스를 구분하는 코드입니다. EX) GOOGLE OR NAVER
        String userNameAttributeName = userRequest.
                getClientRegistration().getProviderDetails().getUserInfoEndpoint().
                getUserNameAttributeName(); // OAuth2 로그인 진행 시 키가 되는 필드값을 말하고, Primary Key 와 같은 의미입니다.
        //구글은 기본 코드지원 네이버,카카오는 지원 x

        OAuthAttributes attributes = OAuthAttributes.
                of(
                        registrationId,
                        userNameAttributeName,
                        oAuth2User
                                .getAttributes()); // OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스입니다.

        User user = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(user)); // SessionUser는 세션에 사용자 정보를 저장하기 위한 Dto클래스입니다.
        //Session에 저장하기 위해서는 직렬화를 해야하기 때문에 기존의 USER대신 SessionUser DTO를 생성하였습니다.

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
        }
        private User saveOrUpdate(OAuthAttributes attributes) {
            User user = userRepository.findByEmail(attributes.
                    getEmail())
                    .map(entity -> entity.update(attributes.
                            getName(), attributes.getPicture()))
                    .orElse(attributes.toEntity());

            return userRepository.save(user);
        }
}