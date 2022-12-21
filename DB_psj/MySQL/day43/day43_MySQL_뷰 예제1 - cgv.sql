USE CGV;
-- 예매한 영화이름, 영화관, 좌석이름, 아이디, 상영시간을 조회
SELECT mo_title, ss_date, ss_time, ci_name, se_name, ti_me_id FROM ticketing
	JOIN ticketing_seat ON ti_num = ts_ti_num
    JOIN seat ON ts_se_num = se_num
    JOIN screen_schedule ON ti_ss_num = ss_num
    JOIN movie ON ss_mo_num = mo_num
    JOIN cinema ON ci_num = ss_ci_num;
    
-- 위에처럼 JOIN을 여러번 해야할 경우 '뷰'를 사용하여 간편하게 조회할 수도 있다.
CREATE VIEW TICKET_DETAIL
AS
SELECT * FROM ticketing
	JOIN ticketing_seat ON ti_num = ts_ti_num
    JOIN seat ON ts_se_num = se_num
    JOIN screen_schedule ON ti_ss_num = ss_num
    JOIN movie ON ss_mo_num = mo_num
    JOIN cinema ON ci_num = ss_ci_num;
SELECT * FROM TICKET_DETAIL;

CREATE VIEW TICKET_DETAIL2
AS
SELECT mo_title, ss_date, ss_time, ci_name, se_name, ti_me_id FROM ticketing
	JOIN ticketing_seat ON ti_num = ts_ti_num
    JOIN seat ON ts_se_num = se_num
    JOIN screen_schedule ON ti_ss_num = ss_num
    JOIN movie ON ss_mo_num = mo_num
    JOIN cinema ON ci_num = ss_ci_num;
    
SELECT * FROM TICKET_DETAIL2;

-- abc 회원이 영화 예매를 위해 사용한 금액은?
SELECT sum(se_price) AS '예매 금액' FROM TICKET_DETAIL;

	