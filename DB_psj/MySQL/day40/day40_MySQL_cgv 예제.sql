CREATE DATABASE IF NOT EXISTS cgv;
use cgv;

DROP TABLE IF EXISTS `movie`;

-- AUTO_INCREMENT는 테이블당 1개만 넣을 수 있으며, 생성할 때 PRIMARY KEY 쿼리를 넣어줘야 기본키를 가지고 생성이 된다. 
CREATE TABLE `movie` (
	`mo_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`mo_title`	VARCHAR(50)	NULL,
	`mo_contents`	LONGTEXT	NULL,
	`mo_age`	VARCHAR(10)	NULL,
	`mo_run`	INT	NULL,
	`mo_opening_date`	date	NULL,
	`mo_state`	VARCHAR(10)	NULL
);

DROP TABLE IF EXISTS `movie_person`;

CREATE TABLE `movie_person` (
	`mp_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`mp_name`	VARCHAR(50)	NULL,
	`mp_birth`	DATE	NULL,
	`mp_contry`	VARCHAR(50)	NULL
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`ge_name`	VARCHAR(10)	NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS `trailer`;

CREATE TABLE `trailer` (
	`tr_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`tr_title`	VARCHAR(50)	NULL,
	`tr_file_name`	VARCHAR(100)	NULL,
	`tr_mo_num`	INT	NOT NULL
);

DROP TABLE IF EXISTS `stillcut`;

CREATE TABLE `stillcut` (
	`st_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`st_file_name`	VARCHAR(100)	NULL,
	`st_mo_num`	INT	NOT NULL
);

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
	`mg_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`mg_mo_num`	INT	NOT NULL,
	`mg_ge_name`	VARCHAR(10)	NOT NULL
);

DROP TABLE IF EXISTS `movie_casting`;

CREATE TABLE `movie_casting` (
	`mc_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`mc_role`	VARCHAR(10)	NULL,
	`mc_mp_num`	INT	NOT NULL,
	`mc_mo_num`	INT	NOT NULL
);

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
	`re_name`	VARCHAR(10)	NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS `therter`;

CREATE TABLE `therter` (
	`th_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`th_name`	VARCHAR(20)	NULL,
	`th_lot_address`	VARCHAR(50)	NULL,
	`th_address`	VARCHAR(50)	NULL,
	`th_trans_info`	LONGTEXT	NULL,
	`th_parking_info`	LONGTEXT	NULL,
	`th_number`	VARCHAR(10)	NULL,
	`th_total_cinema`	INT	NULL,
	`th_total_seat`	INT	NULL,
	`th_re_name`	VARCHAR(10)	NOT NULL
);

DROP TABLE IF EXISTS `cinema`;

CREATE TABLE `cinema` (
	`ci_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`ci_name`	VARCHAR(50)	NULL,
	`ci_seat_count`	INT	NULL,
	`ci_type`	VARCHAR(20)	NULL,
	`ci_th_num`	INT	NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`se_name`	VARCHAR(10)	NULL,
	`se_state`	VARCHAR(10)	NULL,
	`se_price`	INT	NULL,
	`se_ci_num`	INT	NOT NULL
);

DROP TABLE IF EXISTS `screen_schedule`;

CREATE TABLE `screen_schedule` (
	`ss_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`ss_date`	DATE	NULL,
	`ss_time`	TIME	NULL,
	`ss_total_seat`	INT	NULL,
	`ss_possible_seat`	INT	NULL,
	`ss_mo_num`	INT	NOT NULL,
	`ss_ci_num`	INT	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	VARCHAR(20)	NOT NULL PRIMARY KEY,
	`me_pw`	VARCHAR(50)	NULL,
	`me_movie_count`	INT	NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
	`ti_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`ti_amount`	INT	NULL,
	`ti_total_price`	INT	NULL,
	`ti_me_id`	VARCHAR(20)	NOT NULL,
	`ti_ss_num`	INT	NOT NULL
);

DROP TABLE IF EXISTS `ticketing_seat`;

CREATE TABLE `ticketing_seat` (
	`ts_num`	INT AUTO_INCREMENT	NOT NULL PRIMARY KEY,
	`ts_ti_num`	INT	NOT NULL,
	`ts_se_num`	INT	NOT NULL
);

ALTER TABLE `trailer` ADD CONSTRAINT `FK_movie_TO_trailer_1` FOREIGN KEY (
	`tr_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `stillcut` ADD CONSTRAINT `FK_movie_TO_stillcut_1` FOREIGN KEY (
	`st_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_casting` ADD CONSTRAINT `FK_movie_person_TO_movie_casting_1` FOREIGN KEY (
	`mc_mp_num`
)
REFERENCES `movie_person` (
	`mp_num`
);

ALTER TABLE `movie_casting` ADD CONSTRAINT `FK_movie_TO_movie_casting_1` FOREIGN KEY (
	`mc_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `therter` ADD CONSTRAINT `FK_region_TO_therter_1` FOREIGN KEY (
	`th_re_name`
)
REFERENCES `region` (
	`re_name`
);

ALTER TABLE `cinema` ADD CONSTRAINT `FK_therter_TO_cinema_1` FOREIGN KEY (
	`ci_th_num`
)
REFERENCES `therter` (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_cinema_TO_seat_1` FOREIGN KEY (
	`se_ci_num`
)
REFERENCES `cinema` (
	`ci_num`
);

ALTER TABLE `screen_schedule` ADD CONSTRAINT `FK_movie_TO_screen_schedule_1` FOREIGN KEY (
	`ss_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `screen_schedule` ADD CONSTRAINT `FK_cinema_TO_screen_schedule_1` FOREIGN KEY (
	`ss_ci_num`
)
REFERENCES `cinema` (
	`ci_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_member_TO_ticketing_1` FOREIGN KEY (
	`ti_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `FK_screen_schedule_TO_ticketing_1` FOREIGN KEY (
	`ti_ss_num`
)
REFERENCES `screen_schedule` (
	`ss_num`
);

ALTER TABLE `ticketing_seat` ADD CONSTRAINT `FK_ticketing_TO_ticketing_seat_1` FOREIGN KEY (
	`ts_ti_num`
)
REFERENCES `ticketing` (
	`ti_num`
);

ALTER TABLE `ticketing_seat` ADD CONSTRAINT `FK_seat_TO_ticketing_seat_1` FOREIGN KEY (
	`se_num`
)
REFERENCES `seat` (
	`se_num`
);

