use cgv;
-- 1. 아바타-물의 길에 출연한 감독 및 배우들을 조회하는 커리
-- 1번문제 서진풀이
SELECT mo_title AS 영화, mp_name AS 출연배우 FROM movie
	JOIN movie_casting ON mo_num = mc_mo_num
    JOIN movie_person ON mc_mp_num = mp_num
    WHERE mo_num = 1;
-- 1번문제 강사님 풀이
SELECT mo_title AS 영화제목, mp_name AS 출연진, mc_role AS 역할
FROM movie_person
JOIN movie_casting ON mc_mp_num = mp_num
JOIN movie ON mo_num = mc_mo_num
WHERE mo_title LIKE '아바타-물의 길';

-- 2. 제임스 카메론의 참여 영화 리스트를 조회하는 커피
-- 2번문제 서진풀이
SELECT mp_name AS 영화인, mo_title AS '참여 영화'
	FROM movie_person
	JOIN movie_casting ON mp_num = mc_mp_num
    JOIN movie ON mo_num = mc_mo_num
    WHERE mp_name LIKE '제임스 카메론';
    
-- 2번문제 강사님 풀이
SELECT mo_title AS 영화제목, mc_role AS 역할
	FROM movie_person
	JOIN movie_casting ON mp_num = mc_mp_num
    JOIN movie ON mo_num = mc_mo_num
    WHERE mp_name LIKE '제임스 카메론';
    
-- 3. 아바타 누적 관객수를 조회하는 쿼리
SELECT sum(ti_amount) AS '아바타 누적 관객수'  	-- sum(ti_amount) -> 집계 함수
	FROM ticketing
	JOIN screen_schedule ON ss_num = ti_ss_num
    JOIN movie ON mo_num = ss_mo_num
    WHERE now() >= ss_date AND mo_title LIKE '아바타-물의 길';

-- 4. 누적 관객 수가 1명 이상인 영화를 조회하는 쿼리
SELECT * FROM ticketing;
SELECT mo_title AS 영화제목, sum(ti_amount) AS 누적관객수  
	FROM ticketing
	JOIN screen_schedule ON ss_num = ti_ss_num
    JOIN movie ON mo_num = ss_mo_num
    WHERE now() >= ss_date 
    GROUP BY mo_num
    HAVING 누적관객수 >= 1;
    
SELECT mo_title AS 영화제목, sum(ti_amount) AS '누적 관객수'  
	FROM ticketing
	JOIN screen_schedule ON ss_num = ti_ss_num
    JOIN movie ON mo_num = ss_mo_num
    WHERE now() >= ss_date 
    GROUP BY mo_num
    HAVING `누적 관객수` >= 1; -- ''을 위에서 사용시 HAVING에서 ``을 사용해야 함.




    
    
    
    