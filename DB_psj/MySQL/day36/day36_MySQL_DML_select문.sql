use shoppingmalltc;
/*
select 
	[distinct] -- 행의 중복을 제거
    속성 | 식 등
	[from 테이블명]
    [where 조건절] -> 조건에 맞는 결과를 조회, ==가 아닌 =을 이용하여 비교.
					같지 않은 경우는 !=를 이용
                    
	-- 속성명1로 정렬(오름차순 | 내림차순) 한 후, 속성명1의 값이 같은 행들을 속성명2로 정렬(오름 | 내림)
    (정렬방법이 생략되면 asc(오름차순)이 기본으로 들어감)
	[order by 속성명1 [asc | desc], 속성명2[asc | desc]]
    
    -- 검색 결과의 개수를 제한
    -- limit 번지, 개수 : 지정번지부터 개수
    -- limit  개수 : 0번지부터 개수
    [limit절];
*/
-- member table의 me_id와 me_pw를 조회(검색) *select는 조회 및 검색이라고 생각하면 편함
select me_id, me_pw
	from member;
-- member table에 있는 모든 회원 정보를 조회
select * from member;
-- member table에 아이디가 abc인 회원 정보를 조회
-- id만 볼 경우
select me_id from member where me_id = 'abc';
-- abc id를 가진 모든 정보를 볼 경우
select * from member where me_id = 'abc';
-- 관리자의 아이디를 조회
insert into member values('admin', 'admin', '관리자', '1900-03-02', 'ADMIN');
select me_id from member where me_authority = 'ADMIN';
-- 일반 회원의 아이디를 조회
select me_id from member where me_authority = 'MEMBER';
select me_id from member where me_authority != 'ADMIN';
select me_id from member where me_authority <> 'ADMIN'; -- <> 같지 않다

-- 회원들을 아이디순으로 오름차순으로 정렬
select * from member order by me_id;
-- 회원들을 생일순으로 내림차순으로 정렬
select * from member order by me_birth desc;

-- 회원들을 아이디순으로 오름차순으로 정렬하여 처음 2명만 조회
select * from member 
	order by me_id
    limit 0, 2;
-- 회원들을 아이디순으로 오름차순으로 정렬하여 2번째 2명만 조회
select * from member
	order by me_id
    limit 2, 2;
-- 회원들을 아이디순으로 오름차순으로 정렬하여 3번째 2명만 조회
    select * from member
	order by me_id
    limit 4, 2;
-- *중요 : n번째 x명 조회 limit는 "n-1 * x, x"로 기억 

-- 게시글에서 조회수가 1이상 100이하인 게시글들을 조회
select * from board where bo_views >= 1 and bo_views <= 100;
-- between A and B : A이상 B이하
select * from board where bo_views between 1 and 100; 

-- 게시글에서 카테고리번호가 1번(공지) 또는 2번(자유)인 게시글 전체를 조회
select * from board where bo_bc_num = 1 or bo_bc_num = 2;
select * from board_category;
select * from board_category where bc_name = '공지사항' or bc_name = '자유';
-- 속성 in(a,b) : 속성이 a 또는 b값을 가지는 경우. 단, 같은 속성이여야하며 모두 or로 있어야 한다.
select * from board where bo_bc_num in(1,2);
/*
- = 는 두 문자열이 동일해야 true 로 판단
- like를 이용하여 문자열1이 문자열2에 있는지 확인할 수 있다.
ex) ... where 속성명 like 문자열
- _ : 한 글자를 의미
ex) ... where bo_title like '_ _ _' : 제목이 3글자인 게시글들을 가져옴.
- % : 0글자 이상을 의미
ex) ... where bo_title like '공지%' : 제목이 공지로 시작하는 모든 게시글들
ex) ... where bo_title like '%공지' : 제목이 공지로 끝나는 모든 게시글들
ex) ... wherer bo title like '%공지%' : 제목이 공지가 들어가는 모든 게시글들
*/
-- 2022년도에 작성된 게시글들을 조회(날짜를 문자열처럼 취급)
select * from board;
select * from board where bo_reg_date like '2022%';
-- 이런식으로 날짜도 between and를 사용할 수 있다.
select * from board where bo_reg_date between '2022-01-01 00:00:00' and '2022-12-31 23:59:59'; 
-- 공지라고 제목이 들어간 게시글들 조회
select * from board where bo_title like '%공지%';

-- 카테고리가 공지사항인 게시글들을 조회
select * from board_category;
select * from board 
	where bo_bc_num =(select bc_num from board_category where bc_name = '공지사항');
    
-- 가전 제품(제품카테고리1) 중 가장 비싼 제품보다 가격이 높은 제품들
select * from product 
	where pr_price > all(select pr_price from product where pr_pc_num = 1);
-- 가전 제품(제품카테고리1) 중 가장 싼 제품보다 가격이 높은 제품들
select * from product 
	where pr_price > any(select pr_price from product where pr_pc_num = 1);
-- 가전 제품(제품카테고리1)과 같은 가격들이 있는 제품들
select * from product 
	where pr_price = any(select pr_price from product where pr_pc_num = 1);
select * from product 
	where pr_price in(select pr_price from product where pr_pc_num = 1);

-- 모든 회원의 권한을 출력(권한만 출력하기 때문에 중복이 가능)
select me_authority from member;
-- 모든 회원의 권한을 출력(권한만 출력하기 때문에 중복이 가능) - distinct 중복 제거
select distinct me_authority from member;

-- A as B : A의 이름을 B로 수정(일시적) - select문으로 검색 결과를 출력할 때, 곧 db에 저장되어 있는 값은 변하지 않음. 이건 alter로 수정.
select distinct me_authority as '권한' from member;