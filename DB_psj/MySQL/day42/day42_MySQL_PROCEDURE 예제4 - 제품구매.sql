 USE shoppingmalltc;
-- 제품번호, 수량, 배송지, 우편주소, 아이디가 주어지면 제품을 구매하는 프로시저를 작성

DROP PROCEDURE IF EXISTS 프로시저명;
DELIMITER //
CREATE PROCEDURE 프로시저명(
	IN _num INT,
    IN _amount INT,
    IN _address VARCHAR(50),
    IN _post_num VARCHAR(10),
    IN _id VARCHAR(15)
)
BEGIN
	DECLARE _pr_amount INT DEFAULT 0;
    SET _pr_amount = (select pr_amount from product where pr_num = _num);
	IF _pr_amount >= _amount THEN 
		INSERT INTO buy(bu_num, bu_amount, bu_address, bu_post_num, bu_me_id, bu_pr_num)
		VALUES(concat(_id, left(now(),10)), _amount, _address, _post_num, _id, _num);
		
		UPDATE product SET pr_amount = pr_amount - _amount WHERE pr_num = _num;
	END IF;
END //
DELIMITER ;
CALL 프로시저명(17, 2, '서울시 강남', '12345', 'abc');