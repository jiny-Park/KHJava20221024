/*
C.R.U.D 
- C = insert : 데이터를 DBMS에 추가
- R = select : DBMS에 있는 데이터를 조회
- U = update : DBMS에 있는 데이터를 수정
- D = delete : DBMS에 있는 데이터를 삭제 
*/
use shoppingmalltc;
-- *은 속성을 의미함
select * pr_pc_num from product;
-- all은 중복이 있어도 보여주겠다는 것. 중복 처리와 관련된 문법임
select all pr_pc_num from product;

-- create table ... select
-- - 기존 테이블 검색 결과를 이용하여 새 테이블을 생성
-- - 제약 조건은 복사가 안됨(외래키와 같은)
-- - 검색된 데이터들이 추가 됨
select * from board;
-- 기존 운영되는 테이블에서 새로 테이블을 생성해야 할 때(엄청 중요하게 사용하진 않음)
create table board2(select bo_num as num, 
						   bo_title as title,
						   bo_contents as contents,
                           bo_reg_date as reg_date,
                           bo_views as views,
                           bo_me_id as writer
					from board);
select * from board2;


