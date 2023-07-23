# **Hometown Board**
This is a bulletin board that contains all the stories of the neighborhood.

---
> This is a Spring Boot project that applies the MVC pattern and has a 3-tier structure.

## **Architecture Design**


### **Frontend**

- [x]  Development using temporary JPA (Considering migration to React.js)

### **Backend**

- [x]  Develop RESTful API using Java Spring Framework.
- [x]  Implement SSO authentication.
- [ ]  Use MySQL database to store data. (Considering migration to AWS RDS)
- [x]  Map objects to database using Spring Data JPA.
- [ ]  Store image files in a distributed manner using IPFS (InterPlanetary File System).
  Server (Considering AWS S3)

### **Infrastructure**

- [ ]  Host server using AWS EC2 instance.

----
##  Development tool

### **Build tool**
- Gradle

### **Implementation tool**
- JDK
- IntelliJ IDEA

### Test tool
- JUnit

### Version control tool
- git


---

##  env
applications-oauth.properties
```
# 꾸글이지롱!
# registration

spring.security.oauth2.client.registration.google.client-id=[client-id] <--추가
spring.security.oauth2.client.registration.google.client-secret=[client-secret] <--추가
spring.security.oauth2.client.registration.google.scope=profile,email


# 네이바지롱!
# registration
spring.security.oauth2.client.registration.naver.client-id=[client-id] <--추가
spring.security.oauth2.client.registration.naver.client-secret=[client-secret] <--추가
spring.security.oauth2.client.registration.naver.redirect-uri={baseUrl}/{action}/oauth2/code/{registrationId}
spring.security.oauth2.client.registration.naver.authorization_grant_type=authorization_code
spring.security.oauth2.client.registration.naver.scope=name,email,profile_image
spring.security.oauth2.client.registration.naver.client-name=Naver


# provider
spring.security.oauth2.client.provider.naver.authorization_uri=https://nid.naver.com/oauth2.0/authorize
spring.security.oauth2.client.provider.naver.token_uri=https://nid.naver.com/oauth2.0/token
spring.security.oauth2.client.provider.naver.user-info-uri=https://openapi.naver.com/v1/nid/me
spring.security.oauth2.client.provider.naver.user_name_attribute=response
```



<br/>
<br/>

==========================



# Hometown Board
동네의 모든 이야기를 담는 게시판입니다.

---
> MVC 패턴을 적용하고 3-tier 구조로 되어 있는 Spring Boot 프로젝트입니다.

## 아키텍쳐 구조설계

### 프론트엔드
- [x] 임시 JPA를 통한 개발 (React.js 마이그레이션 고민중)

### 백엔드
1. [x] Java Spring Framework를 사용하여 RESTful API를 개발합니다.
2. [x] SSO 인증 구현
3. [ ] MySQL 데이터베이스를 사용하여 데이터를 저장합니다. (AWS RDS 마이그레이션 고민 중)
4. [x] Spring Data JPA를 사용하여 객체와 데이터베이스를 매핑합니다.
5. [ ] IPFS (InterPlanetary File System)를 사용하여 이미지 파일을 분산 저장합니다.
  서버 (AWS S3 고민중)

### 인프라
1. [ ] AWS EC2 인스턴스를 사용하여 서버를 호스팅합니다.


----
## 개발 도구

### 빌드 도구
- Gradle

### 구현 도구
- JDK
- IntelliJ IDEA

### 테스트 도구
- JUnit

### 형상 관리 도구
- git
  
---

## 환경 설정
applications-oauth.properties
```
# 꾸글이지롱!
# registration

spring.security.oauth2.client.registration.google.client-id=[client-id] <--추가
spring.security.oauth2.client.registration.google.client-secret=[client-secret] <--추가
spring.security.oauth2.client.registration.google.scope=profile,email


# 네이바지롱!
# registration
spring.security.oauth2.client.registration.naver.client-id=[client-id] <--추가
spring.security.oauth2.client.registration.naver.client-secret=[client-secret] <--추가
spring.security.oauth2.client.registration.naver.redirect-uri={baseUrl}/{action}/oauth2/code/{registrationId}
spring.security.oauth2.client.registration.naver.authorization_grant_type=authorization_code
spring.security.oauth2.client.registration.naver.scope=name,email,profile_image
spring.security.oauth2.client.registration.naver.client-name=Naver


# provider
spring.security.oauth2.client.provider.naver.authorization_uri=https://nid.naver.com/oauth2.0/authorize
spring.security.oauth2.client.provider.naver.token_uri=https://nid.naver.com/oauth2.0/token
spring.security.oauth2.client.provider.naver.user-info-uri=https://openapi.naver.com/v1/nid/me
spring.security.oauth2.client.provider.naver.user_name_attribute=response
```

