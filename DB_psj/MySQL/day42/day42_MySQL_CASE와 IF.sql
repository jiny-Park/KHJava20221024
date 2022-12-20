USE shoppingmalltc;

-- 가격이 20.000원 이상이면 비쌈, 가격이 5.000원 이하이면 쌈, 아니면 적당이라고 분류
SELECT pr_title, pr_price,
	CASE
		WHEN pr_price >= 10
        THEN '비쌈'
        WHEN pr_price <= 2
        THEN '쌈'
		ELSE '적당'
	END AS '가격 판별'
 FROM product;
 
 SELECT pr_title, pr_price,
	IF(pr_price >= 10,
		'비쌈',
		IF(pr_price <= 2,
        '쌈', 
        '적당'
		)
    ) AS '가격 판별'
 FROM product;