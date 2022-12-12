create database if not exists shoppingMall;
use shoppingMall;
create table member(
	id varchar(13) not null primary key,
    pw varchar(20) not null,
    name varchar(20) not null,
    birth varchar(30) not null,
    authority varchar(30) not null
);

create table productClassification(
	pdClassificationNum int(100) not null primary key,
    pdClassificationName varchar(50) not null
);

-- 제품분류번호 외래키 아직 안 넣음
create table product(
	pdNum int(100) not null primary key,
    pdName varchar(50) not null,
    pdDetailInfor longtext not null,
    pdCount int(100) not null,
    pdPrice int(100) not null    
);
alter table product add pdClassificationNum int(100) default 0;

alter table product add constraint fk_product_pdClassificationNum 
foreign key(pdClassificationNum) references productClassification(pdClassificationNum);

create table boardClassification(
	bdClassificationNum int(100) not null primary key,
    bdClassificationName varchar(50) not null
);

create table board(
	bdNum int(100) not null primary key,
    bdTitle varchar(50) not null,
    bdContents longtext not null,
    bdWriter varchar(50) not null,
    bdDate datetime not null,
    bdViews int(100) not null,
    bdClassificationNum int(100) not null, foreign key(bdClassificationNum) references boardClassification(bdClassificationNum),
	id varchar(13) not null, foreign key(id) references member(id)
);

