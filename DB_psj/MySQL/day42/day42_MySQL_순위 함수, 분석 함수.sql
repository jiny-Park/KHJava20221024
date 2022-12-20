use cgv;
USE shoppingmalltc;

/*
순위 함수 : ROW_NUMBER(), DENSE_RANK(), RANK(), NTILE()
- ROW_NUMBER() : 같은 값이 있을 때 등수가 서로 다름
- DENSE_RANK() : 같은 값이 있을 때 등수가 같음. 같은 값이 있는 행 다음 등수는 같은 값이 있는 등수 +1로 계산
- RANK() : 같은 값이 있을 때 등수가 같음. 같은 값이 있는 행 다음 등수는 같은 값이 있는 등수 + 같은 값이 있는 개수
- NTILE(N) : 등수를 총 N등까지 분할 
*/


SELECT ROW_NUMBER() OVER(ORDER BY pr_amount DESC) AS 보유량순위,
	pr_title AS 제품명,
    pr_amount AS 보유량
 FROM product;
 
SELECT DENSE_RANK() OVER(ORDER BY pr_price DESC) AS 보유량순위,
	pr_title AS 제품명,
    pr_price AS 제품가격
 FROM product;
 
SELECT RANK() OVER(ORDER BY pr_price DESC) AS 보유량순위,
	pr_title AS 제품명,
    pr_price AS 제품가격
 FROM product;
 
 SELECT NTILE(3) OVER(ORDER BY pr_price DESC) AS 보유량순위,
	pr_title AS 제품명,
    pr_price AS 제품가격
 FROM product;
 
 /*
- LEAD(속성) : 속성의 다음 값을 가져옴
- LEAD(속성, n, x) : 속성의 다음 n개의 값을 가져오고 없으면 x로 대체 
- LAG(속성) : 속성의 다음 값을 가져옴
- LAG(속성, n, x) : 속성의 다음 n개의 값을 가져오고 없으면 x로 대체 
- FIRST_VALUE(속성) : 속성의 첫번째 값
- CUME_DIST() : 백분율
 */
 SELECT *, LEAD(pr_title) OVER(ORDER BY pr_num ASC) AS 다음행값 FROM product;
 SELECT 
	ROW_NUMBER() OVER(ORDER BY pr_price DESC)
    pr_title, pr_price,
    pr_price - LEAD(pr_price, 1, 0) OVER(ORDER BY pr_price DESC) AS 가격차이 
    FROM product;
    
 SELECT 
	ROW_NUMBER() OVER(ORDER BY pr_price DESC)
    pr_title, pr_price,
    pr_price - LAG(pr_price, 1, 0) OVER(ORDER BY pr_price DESC) AS 가격차이 
    FROM product;
    
SELECT 
	ROW_NUMBER() OVER(ORDER BY pr_price DESC)
    pr_title, pr_price,
    pr_price - FIRST_VALUE(pr_price) OVER(ORDER BY pr_price DESC) AS 가격차이 
    FROM product;
    
SELECT 
	ROW_NUMBER() OVER(ORDER BY pr_price DESC)
    pr_title, pr_price,
    pr_price - CUME_DIST() OVER(ORDER BY pr_price DESC)*100 AS 백분율
    FROM product;
    
SELECT pr_pc_num AS 분류번호, AVG(pr_price) AS 평균가격 
	FROM product
	GROUP BY(pr_pc_num);
WITH product_avg(분류번호, 평균가격)
	AS 
    (SELECT pr_pc_num, AVG(pr_price) FROM product GROUP BY(pr_pc_num))
SELECT * FROM product_avg ORDER BY 분류번호 ASC;


