-- 테이블 삭제 쿼리

-- 보호동물 테이블 삭제
DROP TABLE IF EXISTS shelter_animal;

-- 게시글 테이블 삭제
DROP TABLE IF EXISTS myapp_board;

-- 게시판유형 테이블 삭제
DROP TABLE IF EXISTS myapp_board_category;

-- 회원 테이블 삭제
DROP TABLE IF EXISTS myapp_member;


-- 회원
CREATE TABLE myapp_member (
    member_no    INTEGER      NOT NULL COMMENT '번호', -- 번호
    name         VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
    email        VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
    tel          VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
    password     VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
    gender       VARCHAR(1)   NOT NULL COMMENT '성별', -- 성별
    created_date DATE         NOT NULL COMMENT '등록일', -- 등록일
    photo        VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '회원';

-- 회원 데이터 생성
INSERT INTO myapp_member (member_no, name, email, tel, password, gender, created_date, photo)
VALUES
    (1, 'John Doe', 'john@example.com', '123-456-7890', 'hashed_password', 'M', '2023-08-01', 'profile1.jpg'),
    (2, 'Jane Smith', 'jane@example.com', '987-654-3210', 'hashed_password', 'F', '2023-08-02', 'profile2.jpg');

-- 게시판유형
CREATE TABLE myapp_board_category (
    board_category_no INTEGER     NOT NULL COMMENT '번호', -- 번호
    name              VARCHAR(50) NOT NULL COMMENT '게시판이름' -- 게시판이름
)
COMMENT '게시판유형';

-- 게시판유형 데이터 생성
INSERT INTO myapp_board_category (board_category_no, name)
VALUES
    (1, 'Announcements'),
    (2, 'General Discussion'),
    (3, 'Support');

-- 게시글
CREATE TABLE myapp_board (
    board_no     INTEGER      NOT NULL COMMENT '번호', -- 번호
    title        VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
    content      MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
    view_count   INTEGER      NOT NULL COMMENT '조회수', -- 조회수
    created_date DATETIME     NOT NULL COMMENT '등록일', -- 등록일
    animal_no    INTEGER      NULL     COMMENT '동물번호', -- 동물번호
    writer       INTEGER      NOT NULL COMMENT '작성자', -- 작성자
    category     INTEGER      NOT NULL COMMENT '카테고리' -- 카테고리
)
COMMENT '게시글';

-- 게시글 데이터 생성
INSERT INTO myapp_board (board_no, title, content, view_count, created_date, animal_no, writer, category)
VALUES
    (1, 'Important Announcement', 'Lorem ipsum dolor sit amet...', 100, '2023-08-03', NULL, 1, 1),
    (2, 'Discussion Topic 1', 'Aenean euismod bibendum...', 75, '2023-08-04', NULL, 2, 2),
    (3, 'Support Request', 'Nullam elementum urna vel...', 50, '2023-08-05', NULL, 1, 3);

-- 보호동물
CREATE TABLE shelter_animal (
    shelter_animal_no INTEGER     NOT NULL COMMENT '번호', -- 번호
    shelter_no        INTEGER     NOT NULL COMMENT '보호소번호', -- 보호소번호
    animal_kind_no    INTEGER     NOT NULL COMMENT '종', -- 종
    age               INTEGER     NOT NULL COMMENT '나이', -- 나이
    weight            FLOAT       NOT NULL COMMENT '체중', -- 체중
    gender            VARCHAR(1)  NOT NULL COMMENT '성별', -- 성별
    animal_key        DOUBLE      NULL     COMMENT '동물인증번호', -- 동물인증번호
    protection_day    DATE        NOT NULL COMMENT '보호일자', -- 보호일자
    specifics         VARCHAR(50) NOT NULL COMMENT '건강특이사항', -- 건강특이사항
    protection        VARCHAR(1)  NOT NULL COMMENT '보호여부' -- 보호여부
)
COMMENT '보호동물';

-- 보호동물 데이터 생성
INSERT INTO shelter_animal (shelter_animal_no, shelter_no, animal_kind_no, age, weight, gender, animal_key, protection_day, specifics, protection)
VALUES
    (1, 1, 1, 2, 5.5, 'M', 123456789, '2023-08-01', 'Healthy and active', 'Y'),
    (2, 2, 2, 3, 7.2, 'F', 987654321, '2023-08-02', 'Friendly and playful', 'N');
