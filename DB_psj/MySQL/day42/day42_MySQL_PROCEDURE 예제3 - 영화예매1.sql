/*
영화를 예매하면, 예매내역을 추가하는 프로시저를 작성하세요.
INSERT INTO ticketing(ti_amount, ti_total_price, ti_me_id, ti_ss_num)
	VALUES(3, 30000, 'abc', 25);
INSERT INTO ticketing_seat(ts_ti_num, ts_se_num)
	VALUES(3, 11), (3, 13), (3, 15);
UPDATE screen_schedule
	SET ss_possible_seat = ss_possible_seat -3
    WHERE ss_num = 25; 
-- 해당 프로시저는 좌석을 3개 고정으로 선택
-- 아이디, 영화상영, 좌석명을 전달
*/  

DROP PROCEDURE IF EXISTS MOVIE_TICKETING;
DELIMITER //
CREATE PROCEDURE MOVIE_TICKETING(
		IN _ID VARCHAR(20),
		IN _SS_NUM INT,
		IN _SEAT1 VARCHAR(10),
		IN _SEAT2 VARCHAR(10),
		IN _SEAT3 VARCHAR(10)
)
BEGIN
	DECLARE _COUNT INT DEFAULT 0;
    DECLARE _TOTAL_PRICE INT DEFAULT 0;
    DECLARE _SE_NUM INT DEFAULT 0;
    DECLARE _TI_NUM INT DEFAULT 0;
    
    IF _SEAT1 IS NOT NULL THEN
		SET _COUNT = _COUNT + 1;
        SET _TOTAL_PRICE = _TOTAL_PRICE + (SELECT se_price FROM screen_schedule 
							JOIN cinema ON ss_ci_num = ci_num
							JOIN seat ON se_ci_num = ci_num
							WHERE SS_NUM = _SS_NUM AND se_name = _SEAT1);
	END IF;
    
	IF _SEAT2 IS NOT NULL THEN
		SET _COUNT = _COUNT + 1;
		SET _TOTAL_PRICE = _TOTAL_PRICE + (SELECT se_price FROM screen_schedule 
							JOIN cinema ON ss_ci_num = ci_num
							JOIN seat ON se_ci_num = ci_num
							WHERE SS_NUM = _SS_NUM AND se_name = _SEAT2);
	END IF;
    
	IF _SEAT3 IS NOT NULL THEN
		SET _COUNT = _COUNT + 1;
		SET _TOTAL_PRICE = _TOTAL_PRICE + (SELECT se_price FROM screen_schedule 
							JOIN cinema ON ss_ci_num = ci_num
							JOIN seat ON se_ci_num = ci_num
							WHERE SS_NUM = _SS_NUM AND se_name = _SEAT3);
	END IF;
    
    INSERT INTO TICKETING(TI_AMOUNT, TI_TOTAL_PRICE, TI_ME_ID, TI_SS_NUM)
    VALUES(_COUNT, _TOTAL_PRICE, _ID, _SS_NUM);
    
    -- 예매 좌석을 등록
    SET _TI_NUM = (SELECT MAX(TI_NUM) FROM TICKETING);
	IF _SEAT1 IS NOT NULL THEN
        SET _SE_NUM = (SELECT se_num FROM screen_schedule 
							JOIN cinema ON ss_ci_num = ci_num
							JOIN seat ON se_ci_num = ci_num
							WHERE SS_NUM = _SS_NUM AND se_name = _SEAT1);
		INSERT INTO ticketing_seat(ts_ti_num, ts_se_num) VALUES(_TI_NUM, _SE_NUM);
	END IF;
	
	IF _SEAT2 IS NOT NULL THEN
        SET _SE_NUM = (SELECT se_num FROM screen_schedule 
							JOIN cinema ON ss_ci_num = ci_num
							JOIN seat ON se_ci_num = ci_num
							WHERE SS_NUM = _SS_NUM AND se_name = _SEAT2);
		INSERT INTO ticketing_seat(ts_ti_num, ts_se_num) VALUES(_TI_NUM, _SE_NUM);
	END IF;
    
	IF _SEAT3 IS NOT NULL THEN
        SET _SE_NUM = (SELECT se_num FROM screen_schedule 
							JOIN cinema ON ss_ci_num = ci_num
							JOIN seat ON se_ci_num = ci_num
							WHERE SS_NUM = _SS_NUM AND se_name = _SEAT3);
		INSERT INTO ticketing_seat(ts_ti_num, ts_se_num) VALUES(_TI_NUM, _SE_NUM);
	END IF;
    
    -- 예매 가능 좌석을 수정
	UPDATE screen_schedule
		SET ss_possible_seat = ss_possible_seat - _COUNT
		WHERE ss_num = _SS_NUM;

END //
DELIMITER ;
CALL MOVIE_TICKETING('abc', 27, 'A1', 'A2', NULL);

