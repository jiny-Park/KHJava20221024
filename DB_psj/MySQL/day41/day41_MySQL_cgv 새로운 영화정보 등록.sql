-- 새로운 영화 정보 등록
INSERT INTO movie_person(mp_name, mp_birth, mp_contry)
	VALUES('안태진', NULL, '한국'),
		  ('류준열', '1986-09-25', '한국'),
          ('유해진', '1970-01-04', '한국'),
          ('최무성', '1968-01-12', '한국'),
          ('조성하', '1966-08-08', '한국'),
          ('박명훈', '1975-05-28', '한국'),
          ('김성철', '1991-12-31', '한국'),
          ('안은진', '1991-05-06', '한국'),
          ('조윤서', '1993-01-04', '한국');
          
INSERT INTO movie_person(mp_name, mp_birth, mp_contry)
	VALUES('미키 타카히로', '1974-08-29', '일본'),
		  ('후쿠모토 리코', '2000-11-25', '일본'),
          ('미치에다 슌스케', '2002-07-25', '일본'),
          ('후루카와 코토네', '1996-10-25', '일본'),
          ('아츠모토 호노카', '1997-02-05', '일본');
          
INSERT INTO movie(mo_title, mo_contents, mo_age, mo_run, mo_openning_date, mo_state)
	VALUES('올빼미', 
		'맹인이지만 뛰어난 침술 실력을 지닌 \‘경수\’는 어의 \‘이형익\’에게 그 재주를 인정받아 궁으로 들어간다.
	그 무렵, 청에 인질로 끌려갔던 \‘소현세자\’가 8년 만에 귀국하고, \‘인조\’는 아들을 향한 반가움도 잠시 정체 모를 불안감에 휩싸인다.
	그러던 어느 밤, 어둠 속에서는 희미하게 볼 수 있는 \‘경수\’가 \‘소현세자\’의 죽음을 목격하게 되고
	진실을 알리려는 찰나 더 큰 비밀과 음모가 드러나며 목숨마저 위태로운 상황에 빠진다.
	아들의 죽음 후 \‘인조\’의 불안감은 광기로 변하여 폭주하기 시작하고
	세자의 죽음을 목격한 ‘경수’로 인해 관련된 인물들의 민낯이 서서히 드러나게 되는데...',
		'15세 이상', 118, '2022-11-23', '현재상영중'); 
        
INSERT INTO movie(mo_title, mo_contents, mo_age, mo_run, mo_openning_date, mo_state)
	VALUES('오늘밤, 세계에서 이 사랑이 사라진다 해도', 
		'\“카미야 토루에 대해 잊지 말 것\”
		자고 일어나면 전날의 기억을 잃는
		\‘선행성 기억상실증\’에 걸린 소녀 \‘마오리\’
		\“내일의 마오리도 내가 즐겁게 해줄 거야\”
		누구에게도 기억되지 않는
        무색무취의 평범한 소년 \‘토루\’
		매일 밤 사랑이 사라지는 세계,
		그럼에도 불구하고,
		다음 날 서로를 향한 애틋한 고백을 반복하는
		두 소년, 소녀의 가장 슬픈 청춘담',
		'12세 이상', 121, '2022-11-30', '현재상영중'); 
        
INSERT INTO movie_genre(mg_mo_num, mg_ge_name) 
	VALUES(2, '스릴러');

INSERT INTO movie_genre(mg_mo_num, mg_ge_name) 
	VALUES(3, '멜로/로맨스');    
    
INSERT INTO movie_casting(mc_role, mc_mp_num, mc_mo_num)
	VALUES('감독' , 9, 2), ('배우' , 10, 2), ('배우' , 11, 2), 
		  ('배우' , 12, 2), ('배우' , 13, 2), ('배우' , 14, 2), 
          ('배우' , 15, 2), ('배우' , 16, 2), ('배우' , 17, 2);

INSERT INTO movie_casting(mc_role, mc_mp_num, mc_mo_num)
	VALUES('감독' , 18, 3), ('배우' , 19, 3), ('배우' , 20, 3), 
		  ('배우' , 21, 3), ('배우' , 22, 3);
          
INSERT INTO trailer(tr_title, tr_file_name, tr_mo_num)
	VALUES('올빼미', 'http://h.vod.cgv.co.kr:80/vodCGVa/86481/86481_210223_1200_128_960_540.mp4', 2);
    
INSERT INTO trailer(tr_title, tr_file_name, tr_mo_num)
	VALUES('오늘밤, 세계에서 이 사랑이 사라진다 해도', 'http://h.vod.cgv.co.kr:80/vodCGVa/86503/86503_208590_1200_128_960_540.mp4', 3);
            
INSERT INTO stillcut(st_file_name, st_mo_num)
	VALUES('https://img.cgv.co.kr/Movie/Thumbnail/StillCut/000086/86481/86481210357_727.jpg', 2);
    
INSERT INTO stillcut(st_file_name, st_mo_num)
	VALUES('https://img.cgv.co.kr/Movie/Thumbnail/StillCut/000086/86503/86503208094_727.jpg', 3);

-- 올빼미 상영시간 등록
INSERT INTO screen_schedule(ss_date, ss_time, ss_total_seat, ss_possible_seat, ss_mo_num, ss_ci_num)
	VALUES('2022-12-20', '13:50:00', 10, 10, 2, 2),  -- 2관
		  ('2022-12-20', '11:00:00', 10, 10, 2, 6), ('2022-12-20', '17:10:00', 10, 10, 2, 6); -- 6관
-- 오늘밤, 세계에서 이 사랑이 사라진다 해도 상영시간 등록
INSERT INTO screen_schedule(ss_date, ss_time, ss_total_seat, ss_possible_seat, ss_mo_num, ss_ci_num)
	VALUES('2022-12-20', '09:00:00', 10, 10, 3, 2), ('2022-12-20', '16:20:00', 10, 10, 3, 2); -- 2관

-- abc 회원이 올빼미 12월 20일 13:50을 3자리 예매(A1, B1, C1)
INSERT INTO ticketing(ti_amount, ti_total_price, ti_me_id, ti_ss_num)
	VALUES(3, 30000, 'abc', 25);

INSERT INTO ticketing_seat(ts_ti_num, ts_se_num)
	VALUES(2, 11), (2, 13), (2, 15);
    
UPDATE screen_schedule
	SET ss_possible_seat = ss_possible_seat -3
    WHERE ss_num = 25;   
    
-- 1. abc 회원이 예매한 올빼미 상영좌석을 조회(관이름과, 좌석번호 조회)
-- 1번문제 서진풀이
SELECT ci_name AS 영화관, se_name AS 좌석번호 
	FROM member
	JOIN ticketing ON me_id = ti_me_id
    JOIN ticketing_seat ON ti_num = ts_ti_num
    JOIN seat ON se_num = ts_se_num
    JOIN cinema ON ci_num = se_ci_num
    JOIN screen_schedule ON ss_ci_num = ci_num
    JOIN movie ON ss_mo_num = mo_num
    WHERE mo_title LIKE '올빼미' 
    AND me_id LIKE 'abc';
    
-- 1번문제 강사님 풀이
SELECT se_name AS 'abc 회원이 예매한 영화 <올빼미> 좌석'
	FROM ticketing
	JOIN screen_schedule ON ti_ss_num = ss_num
    JOIN movie ON ss_mo_num = mo_num
    JOIN ticketing_seat ON ti_num = ts_ti_num
    JOIN seat ON ts_se_num = se_num
    WHERE mo_title LIKE '올빼미'
    AND ti_me_id LIKE 'abc';
   
-- 2. 올빼미 12월 20일에 13:50 상영에 예매 가능한 좌석을 조회
SELECT mo_title AS 영화제목, se_name AS 좌석명, 
	CASE 
		WHEN ts_num IS NULL 
        THEN '0'
        ELSE 'X'
	END AS 가능여부
	FROM (SELECT * FROM screen_schedule where ss_date = '2022-12-20' AND ss_time = '13:50:00') AS ss
	JOIN (SELECT * FROM movie WHERE mo_title LIKE '올빼미')AS mo ON ss_mo_num = mo_num
    JOIN cinema ON ss_ci_num = ci_num
    JOIN seat ON se_ci_num = ci_num
    LEFT JOIN ticketing ON ti_ss_num = ss num
    LEFT JOIN ticketing_seat ON ts_se_num = se_num;
  
-- screen_schedule 영화 제목 속성을 추가하면 movie 테이블과 JOIN을 하지 않아도 됨. 데이터는 중복
-- ticketing_seat에 좌석 이름을 추가하면 좌석명을 알기 위해 seat 테이블과 join 하지 않아도 됨.

-- 영화별 누적 관객 수를 조회
SELECT mo_title AS 영화제목, IFNULL(sum(ti_amount), 0) AS 관객수 FROM movie
	LEFT JOIN (SELECT * FROM screen_schedule WHERE ss_date <= now()) AS ss
    ON ss_mo_num = mo_num
    LEFT JOIN ticketing ON ti_ss_num = ss_num
    GROUP BY mo_num;
    
-- 영화 순위(누적별 관객 수)
SELECT mo_title AS 영화제목, IFNULL(sum(ti_amount), 0) AS 관객수 FROM movie
	LEFT JOIN (SELECT * FROM screen_schedule WHERE ss_date <= now()) AS ss
    ON ss_mo_num = mo_num
    LEFT JOIN ticketing ON ti_ss_num = ss_num
    GROUP BY mo_num
    ORDER BY 관객수 DESC;
	
-- 날짜가 지났을 때 변경되어야 할 쿼리를 작성
-- 회원이 본 영화 수를 체크
SELECT * FROM member;
UPDATE member
	SET me_movie_count = (SELECT count(distinct ss_mo_num) FROM ticketing 
						JOIN screen_schedule ON ti_ss_num = ss_num
						WHERE ss_date < now())
    WHERE me_id = 'abc';
-- 'abc' 회원이 본 영화 목록 개수
SELECT count(distinct ss_mo_num) FROM ticketing 
	JOIN screen_schedule ON ti_ss_num = ss_num
    WHERE ss_date < now();    

-- 올빼미 12월 20일 13:50분 예매를 취소할 때 실행해야 하는 쿼리 작성
-- DELETE 예약 내용을 삭제
-- 예약 좌석을 삭제
DELETE FROM ticketing_seat 
	WHERE ts_ti_num = 2;
-- 예약 내역을 삭제
SELECT * FROM ticketing;
DELETE FROM ticketing 
	WHERE ti_num = 2;
          