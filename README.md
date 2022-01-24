# Billie Joe
Spring Framework, mybatis를 사용한 공간 대여 시스템 파이널 프로젝트

## 레퍼런스
* https://www.spacecloud.kr/

## 개발환경
* Java SE 1.8
* AdoptOpenJDK 8
* Apache Tomcat 8.5
* Oracle 11g

### 사용된 라이브러리
* Spring Framework 5.2.8.RELEASE
* Apache Maven 3.8.1
   - ojdbc6
   - commons-fileupload
   - commons-dbcp2
   - jackson-databind
   - spring-websocket
   - gson
   - spring-security-core
   - spring-security-config
   - spring-jdbc
   - mybatis-spring
* MyBatis
* taglibs
   - jstlel 1.2.5
   - impl 1.2.5
   - spec 1.2.5

### 담당한 파트
* 회원
   - 회원가입 
   - 로그인 
   - 로그아웃 
   - 탈퇴

* 관리자
   - 로그인 
   - 로그아웃
   - 후기신고 게시판
   - 후기관리(불량,광고 등) 게시판

* 게시판 
   - 후기 게시판 CRUD 
   - 불량 후기 신고처리(게시글 담당자가 관리자에게 신고)

### 소스코드 경로
* front-end(html)
   - https://github.com/Kang-Ji-Ae/kh-final/tree/master/src/main/webapp/WEB-INF/views

* front-end(css & js)
   - https://github.com/Kang-Ji-Ae/kh-final/tree/master/src/main/webapp/resources

* back-end
   - https://github.com/Kang-Ji-Ae/kh-final/tree/master/src/main/java/kr/co/billiejoe
