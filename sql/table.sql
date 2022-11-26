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

# 관리자 테이블
create table RM_ADMIN (
     id                  BIGINT          NOT NULL        AUTO_INCREMENT      COMMENT '관리자 식별자',
     admin_id            VARCHAR(20)     NOT NULL                            COMMENT '관리자 아이디',
     admin_pwd           VARCHAR(500)    NOT NULL                            COMMENT '관리자 암호',
     nm                  VARCHAR(100)    NOT NULL                            COMMENT '관리자 이름',
     create_dt           DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '관리자 생성일',
     mod_dt              DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '관리자 수정일',
     PRIMARY KEY (id)
);

# 공지사항 테이블
create table RM_NOTICE (
    id                  BIGINT          NOT NULL        AUTO_INCREMENT      COMMENT '공지사항 식별자',
    title               VARCHAR(1000)   NULL                                COMMENT '공지사항 제목',
    contents            TEXT            NULL                                COMMENT '공지사항 내용',
    view_cnt            INTEGER         NOT NULL        DEFAULT 0           COMMENT '공지사항 조회수',
    pbc_yn              CHAR            NOT NULL        DEFAULT 'Y'         COMMENT '공지사항 공개여부(Y:공개,N:비공개)',
    user_id             BIGINT          NULL                                COMMENT '공지사항 작성자 식별자',
    del_yn              CHAR            NOT NULL        DEFAULT 'N'         COMMENT '공지사항 삭제여부(Y:삭제,N:미삭제)',
    create_dt           DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '공지사항 생성일',
    mod_dt              DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '공지사항 수정일',
    PRIMARY KEY (id)
);

# 문의사항 테이블
create table RM_REQ (
    id                  BIGINT          NOT NULL        AUTO_INCREMENT      COMMENT '문의사항 식별자',
    title               VARCHAR(1000)   NULL                                COMMENT '문의사항 제목',
    contents            TEXT            NULL                                COMMENT '문의사항 내용',
    user_id             BIGINT          NULL                                COMMENT '문의사항 작성자 식별자',
    del_yn              CHAR            NOT NULL        DEFAULT 'N'         COMMENT '문의사항 삭제여부(Y:삭제,N:미삭제)',
    create_dt           DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '문의사항 생성일',
    mod_dt              DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '문의사항 수정일',
    PRIMARY KEY (id)
);

# 갤러리 테이블
create table RM_GALLERY (
    id                  BIGINT          NOT NULL        AUTO_INCREMENT      COMMENT '갤러리 식별자',
    title               VARCHAR(1000)   NULL                                COMMENT '갤러리 제목',
    contents            TEXT            NULL                                COMMENT '갤러리 내용',
    gall_type           VARCHAR(50)     NOT NULL        DEFAULT 'NORMAL'    COMMENT '갤러리 타입(NORMAL:일반,AWARD:수상내역)',
    user_id             BIGINT          NULL                                COMMENT '갤러리 작성자 식별자',
    del_yn              CHAR            NOT NULL        DEFAULT 'N'         COMMENT '갤러리 삭제여부(Y:삭제,N:미삭제)',
    create_dt           DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '갤러리 생성일',
    mod_dt              DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '갤러리 수정일',
    PRIMARY KEY (id)
);

# 파일관련 테이블
create table RM_FILE (
    id                  BIGINT          NOT NULL        AUTO_INCREMENT      COMMENT '파일 식별자',
    type                VARCHAR(50)     NOT NULL                            COMMENT '파일 타입(NOTICE:게시판,REQ:문의사항,GALLERY:갤러리)',
    bucket              VARCHAR(500)    NULL                                COMMENT '파일 경로',
    ori_file_nm         VARCHAR(500)    NULL                                COMMENT '원본 파일 명',
    nm                  VARCHAR(500)    NULL                                COMMENT '파일 명',
    file_format         VARCHAR(50)     NULL                                COMMENT '파일 유형',
    size                INTEGER         NULL                                COMMENT '파일 크기',
    target_id           BIGINT          NOT NULL                            COMMENT '타겟 식별자',
    del_yn              CHAR            NOT NULL        DEFAULT 'N'         COMMENT '파일 삭제여부(Y:삭제,N:미삭제)',
    create_dt           DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '파일 생성일',
    mod_dt              DATETIME        NOT NULL        DEFAULT NOW()       COMMENT '파일 수정일',
    PRIMARY KEY (id)
);

# 공통코드 테이블
create table RM_CODE (
    code_cd             VARCHAR(50)     NOT NULL                            COMMENT '공통 코드 식별자',
    code_nm             VARCHAR(100)    NULL                                COMMENT '공통 코드명',
    code_desc           VARCHAR(1000)   NULL                                COMMENT '공통 코드 설명',
    use_yn              CHAR            NOT NULL        DEFAULT 'Y'         COMMENT '공통 코드 사용 여부(Y:사용, N:미사용)',
    PRIMARY KEY (code_cd)
 );

