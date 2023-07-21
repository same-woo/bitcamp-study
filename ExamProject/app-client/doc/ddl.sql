  /* board */
CREATE TABLE myapp_board (
  board_no INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  content TEXT NULL,
  writer VARCHAR(20) NOT NULL,
  password VARCHAR(100) NULL,
  view_count INT DEFAULT 0,
  created_date DATETIME DEFAULT now()
);

alter table myapp_board
  add constraint primary key (board_no),
  modify column board_no int not null auto_increment;

  /* member */
CREATE TABLE myapp_member (
  member_no INT NOT NULL,
  name VARCHAR(20) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  gender CHAR(1) NOT NULL
);


alter table myapp_member
  add constraint primary key (member_no),
  modify column member_no int not null auto_increment; 
  
  
-- 게시판에 카테고리 컬럼 추가
alter table myapp_board
  add column category int not null;
  
-- UPDATE myapp_board set category=1 where board_no < 5;
-- UPDATE myapp_board set category=2 where board_no >= 5;