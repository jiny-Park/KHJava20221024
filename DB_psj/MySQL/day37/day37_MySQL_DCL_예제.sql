-- test 계정 추가, 비번 설정 없이
create user test;
-- test1 계정 추가, 비번 1234
create user test1 identified by '1234';

-- 권한 부여
grant insert, create on * to test@'%'; 
-- test1 계정에게 small_tc DB에 있는 모든 테이블의 select 권한을 부여
-- '%' : 외부에서 접근 허용, 'localhost' : 내부에서 접근 허용
grant select on small_tc.* to test1@'%';
-- test1 계정에게 small_tc DB에 있는 모든 테이블의 모든 권한을 부여
grant all privileges on small_tc.* to test1@'%';

-- 권한 회수
-- .* : 모든 테이블
revoke all on small_tc.* from test1;

-- 계정 삭제
drop user test;