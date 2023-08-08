-- myapp_member 테이블 예제 데이터
insert into myapp_member(member_no, name, email, password, gender) 
  values(1, 'aaa', 'aaa@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender) 
  values(2, 'bbb', 'bbb@test.com', sha1('1111'), 'M');
insert into myapp_member(member_no, name, email, password, gender) 
  values(3, 'ccc', 'ccc@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender) 
  values(4, 'ddd', 'ddd@test.com', sha1('1111'), 'M');
insert into myapp_member(member_no, name, email, password, gender) 
  values(5, 'eee', 'eee@test.com', sha1('1111'), 'W');
insert into myapp_member(member_no, name, email, password, gender) 
  values(6, 'fff', 'fff@test.com', sha1('1111'), 'M');

-- myapp_board 테이블 예제 데이터
insert into myapp_board(board_no, title, content, writer, password, category)
  values(11, '제목1', '내용', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(12, '제목2', '내용', 1, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(13, '제목3', '내용', 3, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(14, '제목4', '내용', 4, sha1('1111'), 1);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(15, '제목5', '내용', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(16, '제목6', '내용', 5, sha1('1111'), 2);
insert into myapp_board(board_no, title, content, writer, password, category)
  values(17, '제목7', '내용', 5, sha1('1111'), 2);


--------------------------------------
-- myapp_dog 테이블 예제 데이터
INSERT INTO myapp_dog(dog_no, kind, age, gender, weight, location, id)
VALUES(1, '믹스견', 4, 'M', 4.8, '전라남도 순천시', 410100012849800);

INSERT INTO myapp_dog(dog_no, kind, age, gender, weight, location, id)
VALUES(2, '시바견', 7, 'W', 8.1, '노원 상계', 410100012842800);

INSERT INTO myapp_dog(dog_no, kind, age, gender, weight, location, id)
VALUES(3, '비숑', 10, 'W', 5.3, '김포 풍무', 420100012849800);

INSERT INTO myapp_dog(dog_no, kind, age, gender, weight, location, id)
VALUES(4, '믹스견', 4, 'M', 6.2, '대전 유성구', 413222012849800);

