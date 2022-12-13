create database if not exists shoppingApp;
use shoppingApp;

-- 회원
create table if not exists member(
	me_id varchar(13) primary key, 
    me_pw varchar(20) not null,
    me_name varchar(10) not null,
    me_birth date not null,
    me_authority varchar(6) not null default 'MEMBER' -- 권한 : 회원(MEMBER), 관리자(ADMIN)
);

-- 게시글분류
create table if not exists board_category(
	bc_num int auto_increment primary key,	-- 게시글번호pk
    bc_name varchar(20) not null			-- 게시글 이름
);

-- 제품대분류
create table if not exists pr_main_category(
	pr_main_num int auto_increment primary key,	-- 제품 대분류번호pk
    pr_main_name varchar(15) not null			-- 제품 대분류 이름
);

-- 제품중분류
create table if not exists pr_middle_category(
	pr_middle_num int auto_increment primary key,	-- 제품 중분류번호pk
    pr_middle_name varchar(15) not null,			-- 제품 중분류 이름
    pr_pr_main_num int not null,
    constraint fk_pr_pr_main_num foreign key(pr_pr_main_num) references pr_main_category(pr_main_num)
);

-- 게시글
create table if not exists board(
	bo_num int auto_increment primary key,
    bo_title varchar(50) not null,
    bo_contents longtext not null,
    bo_writer varchar(10) not null,
    bo_reg_date datetime not null default now(),	-- (now()->현재시간 자동으로 출력)
    bo_views int not null default 0,
    bo_bc_num int not null,
    constraint fk_bo_bc_num foreign key(bo_bc_num) references board_category(bc_num),
    bo_me_id varchar(15) not null,
    constraint fk_bo_me_id foreign key(bo_me_id) references member(me_id)
);




