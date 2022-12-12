-- test database 생성, 명령어와 클릭을 통해서 생성할 수 있다. 
-- create database test;
-- 아래와 같이 파일이 존재 여부 확인후에 생성해주는 것이 좋다.
-- test database 존재하지 않으면 test database 생성 -> 
create database if not exists test;
-- test database 선택
use test;
-- test database 삭제, 명령어와 클릭을 통해서 삭제할 수 있다. 
-- drop database test;
-- test database가 존재하면 test database 삭제
-- drop database if exists test2;
-- member 테이블 생성
-- 속성으로 id(최대 문자열 13, 기본키), 비번(최대 문자열 20), 이름을 가짐

create table if not exists member(
	id varchar(13) primary key, 
    pw varchar(20) not null, 
    name varchar(30) not null
);
use test;
drop database test2;
use test;
-- 규모를 생각해서 범위를 정하는 것이 좋다.
-- auto_increment : 자동으로 크기를 증가시켜줌(자동증가). 그러나 기본키만 가능, 테이블당 최대 1개만 설정 가능.
create table board(
	num int auto_increment primary key,
    title varchar(50) not null,
    contents longtext not null,
    writer varchar(13) not null,
    -- board table의 writer 속성을 member table의 id와 연결(외래키 설정)
    foreign key(writer) references member(id)
);

-- board 테이블에 조회수 추가
alter table board add views int default 0;
-- board 테이블레 조회수 삭제
alter table board drop views;
-- board table에 잘못된 data tapy으로 조회수 추가
alter table board add views varchar(10);
-- board table에 잘못된 조회수를 올바르게 int로 수정
alter table board modify views int default 0;
-- board table의 views를 views2로 수정(변경)
alter table board change views view2 int default 0;
-- board table의 views2를 views로 수정(변경)
alter table board change view2 views int default 0;
-- board table에 있는 writer의 제약조건을 삭제
alter table board drop constraint board_ibfk_1;
-- board table에 writer와 member테이블에 id를 외래키로 연결(제약조건 추가)
alter table board add constraint fk_board_writer  foreign key(writer) references member(id);
-- workbench에서 추가한 board2 테이블 삭제
drop table if exists board2

create database if not exists shoppingMall;
