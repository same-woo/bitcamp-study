-- myapp_member 테이블 예제 데이터
INSERT INTO myapp_member(member_no, name, email, password, gender)
VALUES(1, 'aaa', 'aaa@test.com', SHA1('1111'), 'W');
INSERT INTO myapp_member(member_no, name, email, password, gender)
VALUES(2, 'bbb', 'bbb@test.com', SHA1('1111'), 'M');
INSERT INTO myapp_member(member_no, name, email, password, gender)
VALUES(3, 'ccc', 'ccc@test.com', SHA1('1111'), 'W');
INSERT INTO myapp_member(member_no, name, email, password, gender)
VALUES(4, 'ddd', 'ddd@test.com', SHA1('1111'), 'M');
INSERT INTO myapp_member(member_no, name, email, password, gender)
VALUES(5, 'eee', 'eee@test.com', SHA1('1111'), 'W');
INSERT INTO myapp_member(member_no, name, email, password, gender)
VALUES(6, 'fff', 'fff@test.com', SHA1('1111'), 'M');

-- myapp_board 테이블 예제 데이터
INSERT INTO myapp_board(board_no, title, content, writer, password, category)
VALUES(11, '제목1', '내용', '1', SHA1('1111'), 1);
INSERT INTO myapp_board(board_no, title, content, writer, password, category)
VALUES(12, '제목2', '내용', '1', SHA1('1111'), 1);
INSERT INTO myapp_board(board_no, title, content, writer, password, category)
VALUES(13, '제목3', '내용', '3', SHA1('1111'), 1);
INSERT INTO myapp_board(board_no, title, content, writer, password, category)
VALUES(14, '제목4', '내용', '4', SHA1('1111'), 1);
INSERT INTO myapp_board(board_no, title, content, writer, password, category)
VALUES(15, '제목5', '내용', '5', SHA1('1111'), 2);
INSERT INTO myapp_board(board_no, title, content, writer, password, category)
VALUES(16, '제목6', '내용', '5', SHA1('1111'), 2);
