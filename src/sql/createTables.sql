create event_management;
use event_management;
CREATE TABLE IF NOT EXISTS `User` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(100) UNIQUE,
	`first_name` VARCHAR(100),
	`last_name` VARCHAR(100),
	`password` VARCHAR(20),
	PRIMARY KEY (`code`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;