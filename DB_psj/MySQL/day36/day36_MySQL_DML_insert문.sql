show databases;
use shoppingmalltc;
/*
insert into member(me_id, me_pw, me_name, me_birth, me_authority) 
	values('abc', '123', 'seojin', '2000-03-03', 'MEMBER');
insert into member(me_id, me_pw, me_name, me_birth) 
	values('qwe', '123', 'jiny', '2000-03-02');
*/
-- 전체 열명을 나열하지 않아도 가능, 단 생략한 열이 null허용이거나 기본값이 존재해야 함.
insert into member(me_id, me_name, me_birth, me_pw) 
	values('123', 'jiny', '2000-03-02', 'qwe');

-- 열을 전체 생략해도 가능. 단, 테이블 생성시 추가했던 열 순으로 값들을 입력해야 함.
insert into member values('asd1235', 'qwe1235', '진씨', '2002-03-02', 'MEMBER'),
						('qwe456', '1234', '서씨', '2003-03-02', 'MEMBER');

use shoppingmalltc;

insert into board_category(bc_name) values('공지'), ('자유'), ('문의');
select * from board;
insert into board(bo_title, bo_contents, bo_me_id, bo_bc_num)
	values('제목1', '내용1', 'qwe', '1');

    
select * from member;
select * from board_category;
select * from board;

