use small_tc;
-- abc회원이 반집업 맨투맨(1번 제품) 빨강을 2개 장바구니에 담았다. 이때 실행되어야 하는 쿼리를 작성

select * from product;
select * from basket;
-- 장바구니 테이블에 입력해준다(insert), 장바구니는 주문이 아니기 때문에 수량이 빠진 상태는 아니다.
/*
insert into basket(ba_amount, ba_me_id, ba_po_num)
	select 2, 'abc', po_num from product_option where po_pr_num = 1 and po_title = '빨강'; 
*/
insert into basket(ba_amount, ba_me_id, ba_po_num) values(2, 'abc', 1);
    
 -- abc회원이 장바구니에 있는 제품을 구매 하였음. 
 -- 조건 : 적립 포인트는 제품 금액의 10%, 사용 포인트는 없음.
 -- -> 장바구니에 있는 제품을 구매하면 장바구니에 있는 데이터는 사라짐. : 장바구니 데이터 삭제 - delete
 -- -> 구매 테이블에 추가	: order - insert
 -- -> 구매 리스트에 추가	: order_list - insert
 -- -> 제품과 제품옵션에서 구매한 제품에 대한 수량만큼 빠져야 함.	product - update, product_option - update

insert into `order`(or_total_price, or_price, or_use_point, or_add_point, or_state, or_me_id, or_ab_num)
	values(17000*2, 17000*2, 0, 17000*2/10, '구매', 'abc', 1);
-- select pr_price*2, pr_price*2, 0, rloor(pr_price*2/10), 'abc', 1;
insert into order_list(ol_amount, ol_price, ol_po_num, ol_or_num) 
	values(2, 17000, 1, 1);
update product_option 
	set 
		po_amount = po_amount -2
	where 
		po_num = 1;
delete from product pr_amount;