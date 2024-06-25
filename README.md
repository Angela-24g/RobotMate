# RobotMate

2022-11-12 dev env setting & db relation setting working start 

### ✔️ URL
[http://robotmate.co.kr](http://robotmate.co.kr)

- 로봇메이트 학원 웹 사이트입니다.

### ✔️ 사용 기술 및 개발 환경
```
java11, Spring boot 2.7.5, Spring data JPA, QueryDSL, IntelliJ, Gradle, MySQL, AWS
```

### ✔️ Pages

#### 1️⃣ HOME Application 
- [x] Home Page
- [x] FAQ Page
- [x] Galleries Page
- [ ] Notices Page
- [ ] Price Page

#### 2️⃣ ADMIN Application
- [x] Home Page
- [x] Login Page
- [x] Galleries Page
   - [x] Galleries Edit Page
   - [x] Galleries Detail Page
- [x] Notices Page
   - [ ] Notices Edit Page
- [x] Price Page
   - [ ] Price Edit Page


### Table
```
# 회원 테이블
create table RM_USER (
    id                  BIGINT          NOT NULL        AUTO_INCREMENT      COMMENT '회원 식별자',
    user_id             VARCHAR(20)     NOT NULL                            COMMENT '회원 아이디',
    user_pwd            VARCHAR(500)    NOT NULL                            COMMENT '회원 암호',
    user_nm             VARCHAR(100)    NOT NULL                            COMMENT '회원 이름',
    user_type           VARCHAR(50)     NOT NULL        DEFAULT 'USER'      COMMENT '회원 타입 (USER:일반, ADMIN:관리자)',
    hp_no               VARCHAR(500)    NULL                                COMMENT '회원 전화번호',
    user_email          VARCHAR(500)    NULL                                COMMENT '회원 이메일',
    user_birth_dt       DATE            NULL                                COMMENT '회원 생년월일',
    use_yn              CHAR            NOT NULL        DEFAULT 'Y'         COMMENT '회원 탈퇴 여부 (Y:미탈퇴, N:탈퇴)',
    sms_recv_yn         CHAR            NOT NULL        DEFAULT 'N'         COMMENT '회원 문자 수신 여부 (Y:수신, N:미수신)',
    user_pwd_fail_cnt   INTEGER         NOT NULL        DEFAULT 0           COMMENT '회원 비밀번호 실패 횟수',
    user_pwd_upd_dt     DATETIME        NULL                                COMMENT '회원 마지막 비밀번호 변경일',
    create_dt           DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '회원 생성일',
    mod_dt              DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '회원 수정일',
    PRIMARY KEY (id)
);
...
```
[더보기](https://github.com/Angela-24g/RobotMate/blob/main/sql/table.sql)

### ✔️ Commit
```
- feat : 새로운 기능 추가
- fix : 버그 수정
- docs : 문서 수정
- style : 코드 formatting, 세미콜론(;) 누락, 코드 변경이 없는 경우
- refactor : 코드 리팩터링
- test : 테스트 코드 
- chore : 빌드 업무 수정, 패키지 매니저 수정
- design : CSS 등 사용자 UI 디자인 변경
- comment : 필요한 주석 추가 및 변경
- rename : 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
- remove : 파일을 삭제하는 작업만 수행한 경우
- !BREAKING CHANGE : 커다란 API 변경의 경우
- !HOTFIX : 급하게 치명적인 버그를 고쳐야 하는 경우
```
  
