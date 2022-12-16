-- 1. 영화 아바타 상영 시간을 조회하는 쿼리를 작성
-- 정렬은 영화관순으로
SELECT ss_date AS 상영일, ss_time AS 상영시간, ci_name AS 상영관, 
	   ss_possible_seat AS 예매가능좌석수
	FROM screen_schedule
	JOIN movie ON mo_num = ss_mo_num
    JOIN cinema ON ss_ci_num = ci_num
    WHERE mo_title LIKE '아바타-물의 길' 
    AND mo_state = '현재 상영중'
    AND ss_date >= now()
    ORDER BY ss_ci_num;

-- 2. 강남CGV 1관에서 18일 9시 50분에 상영하는 아바타의 예매 가능 좌석들을 조회

-- 2번 문제. 서진 쿼리문
SELECT th_name AS 극장, ss_date AS 날짜, ss_time AS 시간, 
	   mo_title AS 영화, ss_possible_seat AS 예매가능좌석수 
	FROM screen_schedule
	JOIN movie ON mo_num = ss_mo_num
	JOIN cinema ON ci_num = ss_ci_num
	JOIN therter ON th_num = ci_th_num
    WHERE ss_date = '2022-12-18'
    AND ss_time = '09:50:00'
    AND ss_possible_seat > 0;
-- 2번 문제. 강사님 쿼리문
SELECT se_name AS 좌석명, 
	CASE
		WHEN ts_num IS NULL
        THEN '0'
        ELSE 'X'
    END AS 예약가능
	FROM screen_schedule
	JOIN movie ON mo_num = ss_mo_num
    JOIN cinema ON ss_ci_num = ci_num
    JOIN seat ON ci_num = se_ci_num
    LEFT JOIN ticketing_seat ON ts_se_num = se_num
    WHERE mo_title LIKE '아바타-물의 길' 
    AND mo_state = '현재 상영중'
    AND ss_date = '2022-12-18'
	AND ss_time = '09:50:00'
    AND se_state = '가능';
    
-- LEFT JOIN과 RIGHT JOIN은?
SELECT * FROM cinema;
SELECT * FROM movie
	LEFT JOIN cinema ON ci_num = mo_num;
    
-- 3. abc 회원이 18일 9:50분에 상영하는 아바타를 A1, A2 두자리를 예매했다. 이때 필요한 작업을 쿼리로 작성
-- 단, 작업편의를 위해 18일 9:50분에 상영하는 아바타라는 정보대신 상영번호 5번으로 활용

-- 3번 문제. 서진 쿼리문
-- 예매를 하면 예매 테이블 데이터가 추가되고, 좌석수 관련된 테이블에서는 예매한 만큼의 좌석수가 빠져야겠지?

-- 1. 예매하기(총 2장, 가격 20.000원, 좌석 -> A1, A2)
INSERT INTO ticketing(ti_amount, ti_total_price, ti_me_id, ti_ss_num)
    SELECT 2, 20000, 'abc', ss_num FROM screen_schedule WHERE ss_date = '2022-12-18' AND ss_time = '09:50:00';
    
-- 2. 좌석
SELECT * FROM screen_schedule;
SELECT * FROM ticketing;
SELECT * FROM ticketing_seat;
SELECT * FROM seat;
INSERT INTO ticketing_seat(ts_ti_num, ts_se_num)
	SELECT;


-- 3번 문제. 강사님 쿼리문
-- 예매 
INSERT INTO ticketing(ti_amount, ti_total_price, ti_me_id, ti_ss_num)
	VALUES(2, 20000, 'abc', 1);
-- 좌석 예매
INSERT INTO ticketing_seat(ts_ti_num, ts_se_num)
	SELECT 1, se_num FROM seat WHERE se_name = 'A1' AND se_ci_num = 1;
INSERT INTO ticketing_seat(ts_ti_num, ts_se_num)
	SELECT 1, se_num FROM seat WHERE se_name = 'A2' AND se_ci_num = 1;

-- 상영정보에 가능 좌석 수정
UPDATE screen_schedule
	SET ss_possible_seat = ss_possible_seat -2
    WHERE ss_num = 1;
    
-- 4.'아바타-물의 길'을 상영하는 극장 정보 출력
SELECT th_name FROM screen_schedule 
	JOIN movie ON ss_mo_num = mo_num 
    JOIN cinema ON ci_num = ss_ci_num
    JOIN therter ON ci_th_num = th_num
    WHERE mo_title LIKE '아바타-물의 길'
    AND ss_date >= now()
    GROUP BY th_name;

-- 5. CGV강남에서 상영하는 영화를 조회
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
SELECT mo_title FROM therter
	JOIN cinema ON th_num = ci_th_num
    JOIN screen_schedule ON ci_num = ss_ci_num
    JOIN movie ON ss_mo_num = mo_num
    WHERE th_name LIKE 'CGV강남' AND ss_date >= now()
    GROUP BY ss_mo_num;
    
    
