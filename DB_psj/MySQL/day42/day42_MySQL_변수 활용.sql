SET @num = 10;	-- @num에 10을 저장
SELECT @num := 20; -- @num에 20을 저장한 후, 출력
SELECT @num;
SELECT @@sql_mode;	-- 시스템변수(글로벌 변수) SQL_MODE를 조회

SHOW VARIABLES; -- 시스템변수들을 조회

-- 실수 1.23을 정수 1로 변환
SELECT CAST(1.23 AS SIGNED INTEGER);
SELECT CONVERT(1.23, SIGNED INTEGER);