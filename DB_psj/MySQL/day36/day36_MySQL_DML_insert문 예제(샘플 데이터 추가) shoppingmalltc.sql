use shoppingmalltc;
-- 제품 카테고리 추가 : 가전, 의류, 식품, 취미용품, 애견용품
select * from product_category;
insert into product_category(pc_name) values('가전'), ('의류'), ('식품'), ('취미용품'), ('애견용품');
select * from product_category;

-- 제품 추가  
-- 가전, 50인치 TV, 50인치 TV 팜, 10대, 5원
-- 가전, 100인치 TV, 100인치 TV 팜, 20대, 10원
-- 가전, 무풍 에어컨, 바람이 불지 않는 에어컨, 5대, 15원
-- 의류, 블랙 코트, 케시미어 코트, 3개, 3원
-- 식품, 토시살포장, 소고기 소량 부위, 10kg, 3원
-- 취미용품, 애플 헤드폰, 노이즈 캔슬링 무선 헤드폰, 5대, 5원
-- 애견용품, 로얄 사료, 저지방, 100개, 1원

select * from product;
insert into product( pr_title, pr_contents, pr_amount, pr_price, pr_pc_num) 
	values('50인치 TV', '50인치 TV 팜', 10, 5, 1),
		  ('100인치 TV', '100인치 TV 팜', 20, 10, 1),
          ('무풍 에어컨', '바람이 불지 않는 에어컨', 5, 15, 1),
          ('블랙 코트', '케시미어 코트', 3, 3, 2),
          ('토시살포장', '소고기 소량 부위', 10, 3, 3),
          ('애플 헤드폰', '노이즈 캔슬링 무선 헤드폰', 5, 5, 4),
          ('로얄 사료', '저지방', 100, 1, 5);
select * from product;

-- abc회원이 50인치 TV 1대를 구매 함. 주소는 서울시 강남, 우편번호는 12345
-- 이 때 실행되야 하는 쿼리를 작성 
-- buy 테이블 - insert문
select * from member;
select * from buy;
insert into buy(bu_num, bu_state, bu_amount, bu_address, bu_post_num, bu_me_id, bu_pr_num)
	values('abc202212120001', '결재완료', 1, '서울시 강남', '12345', 'abc', 16);
select * from buy;
-- product 테이블 - update문
update product
	set
		pr_amount = pr_amount - 1
	where pr_num = 16;
select * from product;
-- *상황이 주어지면 그 상황에 맞는 작업을 하는 연습이 필요하다.

/*
- insert values문 : 추가하는 값들을 모두 알고 있는 경우
insert into 테이블명 values();
- insert select문 : 일부 값들이 검색을 통해 가져와야 하는 경우
insert into 테이블명 select ...
*/
-- 식품, 음료수, 탄산, 2000개, 1원
insert into product(pr_title, pr_contents, pr_amount, pr_price, pr_pc_num) 
	select '음료수', '탄산', 2000, 1, pc_num from product_category
		where pc_name = '식품';
select * from product;
select * from product_category;

-- product의 pr_num 16부터 시작하는 것을 1로 바꾸기, 그럼 만약에 byu에 있는 bu_pr_num을 삭제한 다음에 수정하면 어떻게 될까?
-- select * from buy;
-- update buy set bu_pr_num = bu_pr_num - 15;
-- update product set pr_num = pr_num - 15;
