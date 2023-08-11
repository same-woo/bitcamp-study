-- 회원
DROP TABLE IF EXISTS `회원` RESTRICT;

-- 보호동물
DROP TABLE IF EXISTS `보호동물` RESTRICT;

-- 게시판분류
DROP TABLE IF EXISTS `게시판분류` RESTRICT;

-- 보호소
DROP TABLE IF EXISTS `보호소` RESTRICT;

-- 게시글
DROP TABLE IF EXISTS `게시글` RESTRICT;

-- 후원단체
DROP TABLE IF EXISTS `후원단체` RESTRICT;

-- 보호소사진
DROP TABLE IF EXISTS `보호소사진` RESTRICT;

-- 보호동물 사진
DROP TABLE IF EXISTS `보호동물 사진` RESTRICT;

-- 서류첨부
DROP TABLE IF EXISTS `서류첨부` RESTRICT;

-- 보호소후원단체
DROP TABLE IF EXISTS `보호소후원단체` RESTRICT;

-- 회원
CREATE TABLE `회원` (
  `회원번호` INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  `이름`     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  `전화`     VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  `이메일`   VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  `암호`     VARCHAR(255) NOT NULL COMMENT '암호', -- 암호
  `성별`     VARCHAR(10)  NOT NULL COMMENT '성별', -- 성별
  `가입일`   DATE         NOT NULL COMMENT '가입일' -- 가입일
)
COMMENT '회원';

-- 회원
ALTER TABLE `회원`
  ADD CONSTRAINT `PK_회원` -- 회원 기본키
  PRIMARY KEY (
  `회원번호` -- 회원번호
  );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX `UIX_회원`
  ON `회원` ( -- 회원
    `이메일` ASC -- 이메일
  );

-- 회원 인덱스
CREATE INDEX `IX_회원`
  ON `회원`( -- 회원
    `이름` ASC -- 이름
  );

-- 회원 인덱스2
CREATE INDEX `IX_회원2`
  ON `회원`( -- 회원
    `이메일` ASC -- 이메일
  );

-- 회원 인덱스3
CREATE INDEX `IX_회원3`
  ON `회원`( -- 회원
    `전화` ASC -- 전화
  );

-- 보호동물
CREATE TABLE `보호동물` (
  `동물번호`     INTEGER     NOT NULL COMMENT '동물번호', -- 동물번호
  `보호소번호`   INTEGER     NOT NULL COMMENT '보호소번호', -- 보호소번호
  `종`           VARCHAR(20) NULL     COMMENT '종', -- 종
  `나이`         INTEGER     NULL     COMMENT '나이', -- 나이
  `체중`         FLOAT       NOT NULL COMMENT '체중', -- 체중
  `성별`         VARCHAR(10) NOT NULL COMMENT '성별', -- 성별
  `동물인증번호` INTEGER     NULL     COMMENT '동물인증번호', -- 동물인증번호
  `보호시작일`   DATE        NOT NULL COMMENT '보호시작일', -- 보호시작일
  `건강특이사항` VARCHAR(20) NOT NULL COMMENT '건강특이사항', -- 건강특이사항
  `상태`         VARCHAR(10) NULL     COMMENT '상태' -- 상태
)
COMMENT '보호동물';

-- 보호동물
ALTER TABLE `보호동물`
  ADD CONSTRAINT `PK_보호동물` -- 보호동물 기본키
  PRIMARY KEY (
  `동물번호` -- 동물번호
  );

-- 보호동물 유니크 인덱스
CREATE UNIQUE INDEX `UIX_보호동물`
  ON `보호동물` ( -- 보호동물
    `동물인증번호` ASC -- 동물인증번호
  );

-- 보호동물 인덱스
CREATE INDEX `IX_보호동물`
  ON `보호동물`( -- 보호동물
    `종` ASC -- 종
  );

-- 보호동물 인덱스5
CREATE INDEX `IX_보호동물5`
  ON `보호동물`( -- 보호동물
    `건강특이사항` ASC -- 건강특이사항
  );

-- 게시판분류
CREATE TABLE `게시판분류` (
  `게시판분류번호` INTEGER     NOT NULL COMMENT '게시판분류번호', -- 게시판분류번호
  `분류명`         VARCHAR(10) NOT NULL COMMENT '분류명(카테고리)' -- 분류명(카테고리)
)
COMMENT '게시판분류';

-- 게시판분류
ALTER TABLE `게시판분류`
  ADD CONSTRAINT `PK_게시판분류` -- 게시판분류 기본키
  PRIMARY KEY (
  `게시판분류번호` -- 게시판분류번호
  );

-- 게시판분류 인덱스
CREATE INDEX `IX_게시판분류`
  ON `게시판분류`( -- 게시판분류
    `분류명` ASC -- 분류명(카테고리)
  );

-- 보호소
CREATE TABLE `보호소` (
  `보호소번호`  INTEGER      NOT NULL COMMENT '보호소번호', -- 보호소번호
  `보호소 이름` VARCHAR(50)  NOT NULL COMMENT '보호소 이름', -- 보호소 이름
  `이메일`      VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  `전화`        VARCHAR(30)  NOT NULL COMMENT '전화', -- 전화
  `우편번호`    VARCHAR(10)  NOT NULL COMMENT '우편번호', -- 우편번호
  `기본주소`    VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
  `상세주소`    VARCHAR(255) NULL     COMMENT '상세주소' -- 상세주소
)
COMMENT '보호소';

-- 보호소
ALTER TABLE `보호소`
  ADD CONSTRAINT `PK_보호소` -- 보호소 기본키
  PRIMARY KEY (
  `보호소번호` -- 보호소번호
  );

-- 보호소 유니크 인덱스
CREATE UNIQUE INDEX `UIX_보호소`
  ON `보호소` ( -- 보호소
    `이메일` ASC -- 이메일
  );

-- 보호소 인덱스
CREATE INDEX `IX_보호소`
  ON `보호소`( -- 보호소
    `보호소 이름` ASC -- 보호소 이름
  );

-- 게시글
CREATE TABLE `게시글` (
  `글번호`         INTEGER     NOT NULL COMMENT '글번호', -- 글번호
  `게시판분류번호` INTEGER     NULL     COMMENT '게시판분류번호', -- 게시판분류번호
  `작성자`         INTEGER     NOT NULL COMMENT '작성자', -- 작성자
  `제목`           VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  `내용`           MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
  `조회수`         INTEGER     NOT NULL COMMENT '조회수', -- 조회수
  `생성일`         DATE        NOT NULL COMMENT '생성일', -- 생성일
  `동물번호`       INTEGER     NULL     COMMENT '동물번호' -- 동물번호
)
COMMENT '게시글';

-- 게시글
ALTER TABLE `게시글`
  ADD CONSTRAINT `PK_게시글` -- 게시글 기본키
  PRIMARY KEY (
  `글번호` -- 글번호
  );

-- 게시글 인덱스
CREATE INDEX `IX_게시글`
  ON `게시글`( -- 게시글
    `제목` ASC -- 제목
  );

-- 게시글 인덱스2
CREATE INDEX `IX_게시글2`
  ON `게시글`( -- 게시글
    `내용` ASC -- 내용
  );

-- 게시글 인덱스3
CREATE INDEX `IX_게시글3`
  ON `게시글`( -- 게시글
    `제목` ASC, -- 제목
    `내용` ASC  -- 내용
  );

-- 후원단체
CREATE TABLE `후원단체` (
  `후원단체번호` INTEGER     NOT NULL COMMENT '후원단체번호', -- 후원단체번호
  `후원단체명`   VARCHAR(50) NOT NULL COMMENT '후원단체명' -- 후원단체명
)
COMMENT '후원단체';

-- 후원단체
ALTER TABLE `후원단체`
  ADD CONSTRAINT `PK_후원단체` -- 후원단체 기본키
  PRIMARY KEY (
  `후원단체번호` -- 후원단체번호
  );

-- 후원단체 유니크 인덱스
CREATE UNIQUE INDEX `UIX_후원단체`
  ON `후원단체` ( -- 후원단체
    `후원단체명` ASC -- 후원단체명
  );

-- 보호소사진
CREATE TABLE `보호소사진` (
  `보호소사진번호` INTEGER      NOT NULL COMMENT '보호소사진번호', -- 보호소사진번호
  `보호소번호`     INTEGER      NOT NULL COMMENT '보호소번호', -- 보호소번호
  `사진파일명`     VARCHAR(255) NOT NULL COMMENT '사진파일명' -- 사진파일명
)
COMMENT '보호소사진';

-- 보호소사진
ALTER TABLE `보호소사진`
  ADD CONSTRAINT `PK_보호소사진` -- 보호소사진 기본키
  PRIMARY KEY (
  `보호소사진번호` -- 보호소사진번호
  );

-- 보호동물 사진
CREATE TABLE `보호동물 사진` (
  `보호동물 사진번호` INTEGER      NOT NULL COMMENT '보호동물 사진번호', -- 보호동물 사진번호
  `동물번호`          INTEGER      NOT NULL COMMENT '동물번호', -- 동물번호
  `사진파일명`        VARCHAR(255) NOT NULL COMMENT '사진파일명' -- 사진파일명
)
COMMENT '보호동물 사진';

-- 보호동물 사진
ALTER TABLE `보호동물 사진`
  ADD CONSTRAINT `PK_보호동물 사진` -- 보호동물 사진 기본키
  PRIMARY KEY (
  `보호동물 사진번호` -- 보호동물 사진번호
  );

-- 서류첨부
CREATE TABLE `서류첨부` (
  `서류첨부파일 번호` INTEGER      NOT NULL COMMENT '서류첨부파일 번호', -- 서류첨부파일 번호
  `첨부파일명`        VARCHAR(255) NOT NULL COMMENT '첨부파일명', -- 첨부파일명
  `글번호`            INTEGER      NULL     COMMENT '글번호' -- 글번호
)
COMMENT '서류첨부';

-- 서류첨부
ALTER TABLE `서류첨부`
  ADD CONSTRAINT `PK_서류첨부` -- 서류첨부 기본키
  PRIMARY KEY (
  `서류첨부파일 번호` -- 서류첨부파일 번호
  );

-- 보호소후원단체
CREATE TABLE `보호소후원단체` (
  `보호소번호`   INTEGER NOT NULL COMMENT '보호소번호', -- 보호소번호
  `후원단체번호` INTEGER NOT NULL COMMENT '후원단체번호' -- 후원단체번호
)
COMMENT '보호소후원단체';

-- 보호소후원단체
ALTER TABLE `보호소후원단체`
  ADD CONSTRAINT `PK_보호소후원단체` -- 보호소후원단체 기본키
  PRIMARY KEY (
  `보호소번호`,   -- 보호소번호
  `후원단체번호`  -- 후원단체번호
  );

-- 보호동물
ALTER TABLE `보호동물`
  ADD CONSTRAINT `FK_보호소_TO_보호동물` -- 보호소 -> 보호동물
  FOREIGN KEY (
  `보호소번호` -- 보호소번호
  )
  REFERENCES `보호소` ( -- 보호소
  `보호소번호` -- 보호소번호
  );

-- 게시글
ALTER TABLE `게시글`
  ADD CONSTRAINT `FK_회원_TO_게시글` -- 회원 -> 게시글
  FOREIGN KEY (
  `작성자` -- 작성자
  )
  REFERENCES `회원` ( -- 회원
  `회원번호` -- 회원번호
  );

-- 게시글
ALTER TABLE `게시글`
  ADD CONSTRAINT `FK_게시판분류_TO_게시글` -- 게시판분류 -> 게시글
  FOREIGN KEY (
  `게시판분류번호` -- 게시판분류번호
  )
  REFERENCES `게시판분류` ( -- 게시판분류
  `게시판분류번호` -- 게시판분류번호
  );

-- 게시글
ALTER TABLE `게시글`
  ADD CONSTRAINT `FK_보호동물_TO_게시글` -- 보호동물 -> 게시글
  FOREIGN KEY (
  `동물번호` -- 동물번호
  )
  REFERENCES `보호동물` ( -- 보호동물
  `동물번호` -- 동물번호
  );

-- 보호소사진
ALTER TABLE `보호소사진`
  ADD CONSTRAINT `FK_보호소_TO_보호소사진` -- 보호소 -> 보호소사진
  FOREIGN KEY (
  `보호소번호` -- 보호소번호
  )
  REFERENCES `보호소` ( -- 보호소
  `보호소번호` -- 보호소번호
  );

-- 보호동물 사진
ALTER TABLE `보호동물 사진`
  ADD CONSTRAINT `FK_보호동물_TO_보호동물 사진` -- 보호동물 -> 보호동물 사진
  FOREIGN KEY (
  `동물번호` -- 동물번호
  )
  REFERENCES `보호동물` ( -- 보호동물
  `동물번호` -- 동물번호
  );

-- 서류첨부
ALTER TABLE `서류첨부`
  ADD CONSTRAINT `FK_게시글_TO_서류첨부` -- 게시글 -> 서류첨부
  FOREIGN KEY (
  `글번호` -- 글번호
  )
  REFERENCES `게시글` ( -- 게시글
  `글번호` -- 글번호
  );

-- 보호소후원단체
ALTER TABLE `보호소후원단체`
  ADD CONSTRAINT `FK_보호소_TO_보호소후원단체` -- 보호소 -> 보호소후원단체
  FOREIGN KEY (
  `보호소번호` -- 보호소번호
  )
  REFERENCES `보호소` ( -- 보호소
  `보호소번호` -- 보호소번호
  );

-- 보호소후원단체
ALTER TABLE `보호소후원단체`
  ADD CONSTRAINT `FK_후원단체_TO_보호소후원단체` -- 후원단체 -> 보호소후원단체
  FOREIGN KEY (
  `후원단체번호` -- 후원단체번호
  )
  REFERENCES `후원단체` ( -- 후원단체
  `후원단체번호` -- 후원단체번호
  );