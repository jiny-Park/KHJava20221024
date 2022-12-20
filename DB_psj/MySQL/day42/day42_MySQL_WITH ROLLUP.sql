USE shoppingmalltc;

SELECT * FROM product;
SELECT * FROM product_category;
SELECT pr_pc_num, sum(pr_amount) FROM product GROUP BY pr_pc_num WITH ROLLUP; 

USE cgv;
SELECT ss_mo_num, ss_ci_num, sum(ss_possible_seat) AS '예매 가능 총 좌석'
 FROM screen_schedule
 GROUP BY ss_mo_num, ss_ci_num
 WITH ROLLUP;
