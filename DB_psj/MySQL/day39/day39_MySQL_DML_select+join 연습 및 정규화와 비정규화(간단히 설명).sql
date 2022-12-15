-- 의류 제품들을 높은 가격순으로 조회 (정렬 : 오름차순(ASC), 내림차순(DESC))
SELECT mc_name as 분류, pr_title as 제품명, pr_price as 가격 FROM product 
    JOIN sub_category ON pr_sc_num = sc_num
	JOIN main_category ON mc_num = sc_mc_num
	WHERE mc_name = '의류'
	ORDER BY pr_price DESC;
-- 낮은 가격
SELECT mc_name as 분류, pr_title as 제품명, pr_price as 가격 FROM product 
    JOIN sub_category ON pr_sc_num = sc_num
	JOIN main_category ON mc_num = sc_mc_num
	WHERE mc_name = '의류'
	ORDER BY pr_price ASC;


-- 성능 개선 -> 위 코드랑 결과는 똑같지만 아래의 코드가 더 빠르다. 만약에 1억개의 테이블이 조인한다고 생각했을 때 아래와 같이 성능을 개선(효율)할 필요가 있다.
SELECT mc_name AS 분류, pr_title AS 제품명, pr_price AS 가격 FROM product 
    JOIN sub_category ON pr_sc_num = sc_num
	JOIN (SELECT * FROM main_category WHERE mc_name = '의류') AS mc ON mc_num = sc_mc_num
	ORDER BY pr_price ASC;

CREATE table aa(
	aa INT NOT NULL AUTO_INCREMENT
);    
-- 제품별 판매량을 조회 : 제품명, 판매량을 조회
-- -> 기준 : product, 필요한 table : order, order_list
SELECT * FROM order_list;
SELECT pr_title AS 제품명, ifnull(ol_amount, '판매된 제품 없음') AS 판매량 FROM product
	LEFT JOIN order_list ON ol_or_num = pr_num;
-- 강사님 풀이
SET sql_mode = (SELECT replace(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));
SELECT pr_title AS 제품명, ifnull(SUM(ol_amount), 0) AS 판매량 FROM order_list
	RIGHT JOIN product_option ON po_num = ol_po_num
    RIGHT JOIN product ON po_pr_num = pr_num
    GROUP BY po_pr_num
    ORDER BY 판매량 DESC;
    
-- 의류 제품중 제품별 판매량을 조회, 제품명, 판매량을 조회
SELECT mc_name AS 의류, pr_title AS 제품명, ifnull(SUM(ol_amount), 0) AS 판매량 FROM order_list
	RIGHT JOIN product_option ON po_num = ol_po_num
    RIGHT JOIN product ON po_pr_num = pr_num
    JOIN sub_category ON sc_num = pr_sc_num	
    JOIN main_category ON mc_num = sc_mc_num
    WHERE mc_name = '의류'
    GROUP BY po_pr_num
    ORDER BY 판매량 DESC; 
-- JOIN을 줄여줌으로 속도 향상(효율)을 높여준다. 이는 테이블의 속성을 추가함으로 JOIN을 줄여줌으로 속도 향상(효율)을 높여줄 수 있다(반(비)정규화식).
SELECT mc_name AS 의류, pr_title AS 제품명, pr_amount AS 판매량 FROM product
    JOIN sub_category ON sc_num = pr_sc_num	
    JOIN main_category ON mc_num = sc_mc_num
    WHERE mc_name = '의류'
    ORDER BY 판매량 DESC; 

-- 제품별 최신순으로 조회	
SELECT * FROM product
	ORDER BY pr_reg_date DESC;

-- 제품별 최신순으로 조회, 60개씩 보기
SELECT * FROM product
	ORDER BY pr_reg_date DESC
    LIMIT 60; -- or LIMIT 0, 60
    


    
    
    
    
    
    


