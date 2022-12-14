use small_tc;
select * from small_tc.member;

-- 카테고리 등록(메인)
-- 제품대분류 등록
insert into  main_category(mc_name) values('의류'), ('식품'), ('가전'), ('스포츠'), ('문구');

-- 제품중분류 등록
/* - 의류
	- 여성
    - 남성
    - 아동
	- 남녀공용
*/
insert into sub_category(sc_name, sc_mc_num) values('여성', 1), ('남성', 1), ('아동', 1), ('남녀공용', 1);
/* main_category의 mc_num을 알지 못하거나 확인하지 못할 때 아래의 쿼리문으로 사용이 가능하다. 단, 코드가 길어진다는 단점이 있지만.
insert into sub_category(sc_name, sc_mc_num) 
 	select '여성', mc_num from main_category where mc_name = '의류';
insert into sub_category(sc_name, sc_mc_num) 
 	select '남성', mc_num from main_category where mc_name = '의류';
insert into sub_category(sc_name, sc_mc_num) 
 	select '아동', mc_num from main_category where mc_name = '의류';
insert into sub_category(sc_name, sc_mc_num) 
 	select '남녀공용', mc_num from main_category where mc_name = '의류';
*/

/* 식품
	- 과일
    - 채소
    - 과자
    - 쌀/잡곡
*/
insert into sub_category(sc_name, sc_mc_num) values('과일', 2), ('채소', 2), ('과자', 2), ('쌀/잡곡', 2);
/* 가전
	- TV
    - 냉장고
    - 에어컨
*/
insert into sub_category(sc_name, sc_mc_num) values('TV', 3), ('냉장고', 3), ('에어컨', 3);
/* 스포츠
	- 수영
	- 골프
    - 자전거
*/
insert into sub_category(sc_name, sc_mc_num) values('수영', 4), ('골프', 4), ('자전거', 4);
/* 문구
	- 사무용품
    - 미술용품
*/
insert into sub_category(sc_name, sc_mc_num) values('사무용품', 5), ('미술용품', 5);

/* 주소
abc : 집, 서울시 강남, 12345
	  회사, 서울시 강북, 23456
a1  : 집, 경기도 안산, 45678
	  회사, 서울시 강북, 23456
qwe : 집, 경기도 구리, 77777
	  처가, 서울시 강남, 33333
*/
insert into address_book(ab_name, ab_address, ab_post_num, ab_me_id) 
	values ('집', '서울시 강남', '12345', 'abc'),
		   ('회사', '서울시 강북', '23456', 'abc'),
           ('집', '경기도 안산', '45678', 'a1'),
		   ('회사', '서울시 강북', '23456', 'a1'),
		   ('집', '경기도 구리', '77777', 'qwe'),
           ('처가', '서울시 강남', '33333', 'qwe');
           
/* 의류
- 의류 - 여성, 	반집업 맨투맨, 	세컨그라운드 여성용 반집업 맨투맨,   10,  17000원
- 의류 - 여성, 	세미 크롭 맨투맨, 	바블링브록 여성용 세미 크롭 맨투맨,  10,  19900원
- 의류 - 남성, 	긴발 카라티, 		빅사이즈클럽 긴팔 카라티, 		  20,  24900원
- 의류 - 남성, 	7부 브이넥 티셔츠, 	해리슨 남성용 브이넥 7부 티셔츠, 	  20,  23900원
- 의류 - 남녀공용, 기모 조거팬츠, 	우드파카 기모 조거팬츠,			  5,   18900원
- 의류 - 남녀공용, 슬롭 스키니, 		블랙 기모 슬림 스키니, 			  100, 51840원
*/
insert into product(pr_title, pr_contents, pr_amount, pr_price, pr_sc_num)
	values('반집업 맨투맨', '세컨그라운드 여성용 반집업 맨투맨', 10, 17000, 1), -- 이번에 values로 한 이유는 select문의 반복을 줄여주기 위해
		('세미 크롭 맨투맨', '바블링브록 여성용 세미 크롭 맨투맨', 10, 19900, 1),
		('긴발 카라티', '빅사이즈클럽 긴팔 카라티맨', 20, 24900, 2),
        ('7부 브이넥 티셔츠', '해리슨 남성용 브이넥 7부 티셔츠', 20, 23900, 2),
        ('기모 조거팬츠', '우드파카 기모 조거팬츠', 5, 18900, 4),
        ('슬롭 스키니', '블랙 기모 슬림 스키니', 100, 51840, 4);

/* 옵션
- 의류 - 여성, 	반집업 맨투맨, 	세컨그라운드 여성용 반집업 맨투맨,   10,  17000원
	- 빨강, 노랑, 횐색
- 의류 - 여성, 	세미 크롭 맨투맨, 	바블링브록 여성용 세미 크롭 맨투맨,  10,  19900원
	- S, M, L
- 의류 - 남성, 	긴발 카라티, 		빅사이즈클럽 긴팔 카라티, 		  20,  24900원
	- 흰색 S, 흰색 M, 흰색 L, 남색 S, 남색 M, 남색 L
- 의류 - 남성, 	7부 브이넥 티셔츠, 	해리슨 남성용 브이넥 7부 티셔츠, 	  20,  23900원
	- XS, S, M, L, XL
- 의류 - 남녀공용, 기모 조거팬츠, 	우드파카 기모 조거팬츠,			  5,   18900원
	- 24인치, 26인치, 28인치, 30인치, 32인치
- 의류 - 남녀공용, 슬롭 스키니, 		블랙 기모 슬림 스키니, 			  100, 51840원
	- 60cm, 64cm, 68cm, 72cm
*조건 : 수량은 다 5개
*/        
insert into product_option(po_title, po_amount, po_pr_num)
	values('빨강', 5, 1), ('노랑', 5, 1), ('흰색', 5, 1),
		  ('S', 5, 2),  ('M', 5, 2), ('L', 5, 2),
          ('흰색 S', 5, 3), ('흰색 M', 5, 3), ('흰색 L', 5, 3), ('남색 S', 5, 3), ('남색 M', 5, 3), ('남색 L', 5, 3),
		  ('XS', 5, 4), ('S', 5, 4), ('M', 5, 4), ('L', 5, 4), ('XL', 5, 4),
          ('24인치', 5, 5), ('26인치', 5, 5), ('28인치', 5, 5), ('30인치', 5, 5), ('32인치', 5, 5),
          ('60cm', 5, 6), ('64cm', 5, 6), ('68cm', 5, 6), ('72cm', 5, 6);
          

