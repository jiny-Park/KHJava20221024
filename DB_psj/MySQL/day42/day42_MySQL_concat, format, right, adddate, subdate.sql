USE shoppingmalltc;
-- 제품명에 TV가 들어가는 제품 조회
SELECT * FROM product
	WHERE pr_title LIKE '%TV%';
SET @a = 'TV';
SELECT @a;
SELECT * FROM product
	WHERE pr_title LIKE '%@a%';
SELECT * FROM product
	WHERE pr_title LIKE concat('%', @a, '%');
-- FORMAT(100000, 3) : 100,000 숫자표시할 시 ,를 찍어줌. 3은 소수점을 몇자리까지 찍어줄건지 정하는 것.
SELECT format(1000000, 3);
-- 파일명이 주어졌을 때, 확장자를 추출하는 예제
SELECT right('test.txt', 3);

-- adddate 이후 , subdate 이전
SELECT adddate(now(), interval 1 day);
SELECT adddate(now(), interval 1 week);
SELECT adddate(now(), interval 1 month);
SELECT adddate(now(), interval 1 year);
SELECT subdate(now(), interval 1 day);
SELECT subdate(now(), interval 1 week);
SELECT subdate(now(), interval 1 month);
SELECT subdate(now(), interval 1 year);

