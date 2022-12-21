/*
-- 트리거에서 추가/수정/삭제된 데이터를 가져올 때 NEW | OLD를 사용
-- INSERT : NEW(추가된 데이터)
	-- INSERT된 데이터는 트리거에서 수정할 수 없음
-- UPDATE : OLD(값이 변경전 데이터), NEW(값이 변경 후 데이터)
-- DELETE : OLD(삭제된 데이터)

DROP TRIGGER IF EXISTS 트리거명;
DELIMITER //
CREATE TRIGGER 트리거명 -- 트리거 이름
BEFORE|AFTER DELETE|INSERT|UPDATE -- 삭제 후에 작동하도록 지정
-- BEFORE : 테이블에 데이터가 삭제|추가| 수정 되기 전에 트리거가 실행
-- AFTER : 테이블에 데이터가 삭제|추가| 수정 된 후에 트리거가 실행
ON 테이블명 -- 트리거를 부착할 테이블
FOR EACH ROW -- 각 행마다 적용
BEGIN
-- 실행코드
END //
DELIMITER ;
*/
use shoppingmalltc;
DROP TRIGGER IF EXISTS INSERT_BUY;
DELIMITER //
CREATE TRIGGER INSERT_BUY AFTER INSERT
ON BUY 
FOR EACH ROW 
BEGIN
-- 추가된 데이터는 NEW를 통해 가져옴.
UPDATE product SET PR_AMOUNT = PR_AMOUNT - NEW.BU_AMOUNT
WHERE PR_NUM = NEW.BU_PR_NUM;
END //
DELIMITER ;
INSERT INTO BUY(BU_NUM, BU_AMOUNT, BU_ADDRESS, BU_POST_NUM, BU_ME_ID, BU_PR_NUM)
VALUES('ABC202212211711', 5, '서울시 강남', '12345', 'abc', 16);

SELECT * FROM BUY;