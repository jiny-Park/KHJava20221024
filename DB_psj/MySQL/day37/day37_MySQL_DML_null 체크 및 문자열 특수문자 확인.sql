use shoppingmalltc;
use small_tc;
select * from member;
-- null 체크는 is null 또는 in not null을 이용
-- select * from member where me_name != null;
select * from member where me_name is not null;
-- select * from member where me_name = null;
select * from member where me_name is null;

-- 문자열에서 특수문자 표현 : \ 를 이용
select * from member where me_id like '%\_%';