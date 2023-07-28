  /* board */
CREATE TABLE myapp_board (
  board_no INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  content TEXT NULL,
  writer int NOT NULL,
  password VARCHAR(100) NULL,
  view_count INT DEFAULT 0,
  created_date DATETIME DEFAULT now(),
  category int NOT NULL
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
  gender CHAR(1) NOT NULL,
  created_date DATE DEFAULT (current_date())
);



alter table myapp_member
  add constraint primary key (member_no),
  modify column member_no int not null auto_increment; 
  
  -- 멤버 테이블 이메일 중복 방지
alter table myapp_member
  add constraint myapp_member_uk unique (email);
  
  
 -- 게시판 작성자에 의해 외부키 설정
 alter table myapp_board
  add constraint myapp_board_fk foreign key (writer) references myapp_member (member_no);
  
