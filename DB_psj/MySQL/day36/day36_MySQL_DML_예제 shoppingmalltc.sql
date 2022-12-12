use shoppingmalltc;
-- 가전제품을 조회
select * from product 
	where pr_pc_num = (select pc_num from product_category where pc_name = '가전');
-- 제품명으로 TV를 검색하여 조회 *tip : 조건이 걸리면 where이 들어간다고 생각하기!
select * from product where pr_title like '%TV%';
-- abc회원이 구매 확정한 목록을 조회 *tip : 기준이 되는 테이블을 먼저 파악
select * from buy;
select * from buy where bu_me_id = 'abc' and bu_state  = '구매확정';

