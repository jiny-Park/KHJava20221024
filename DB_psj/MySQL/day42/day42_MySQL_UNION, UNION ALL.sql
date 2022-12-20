USE shoppingmalltc;

SELECT * 
	FROM product
    WHERE pr_amount > 10;
SELECT * 
	FROM product
    WHERE pr_price > 10;
    
/*
- UNION, UNION ALL : 합집합, 속성 이름들이 같아야 함
- UNION : 중복을 제거
- UNION ALL : 중복을 제거하지 않음, UNION보다 빠름(중복을 제거하지 않기 때문)
*/
SELECT * FROM product WHERE pr_amount > 10
    UNION
SELECT * FROM product WHERE pr_price > 5;

SELECT * FROM product WHERE pr_amount > 10
    UNION ALL
SELECT * FROM product WHERE pr_price > 5;
    
SELECT pr_num AS 번호, pr_title AS 내용 FROM product
	UNION
SELECT pc_num AS 번호, pc_name AS 내용 FROM product_category;