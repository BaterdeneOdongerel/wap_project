create database event_management;
use event_management;
CREATE TABLE IF NOT EXISTS `User` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(100) UNIQUE,
	`user_name` VARCHAR(20),
	`first_name` VARCHAR(100),
	`last_name` VARCHAR(100),
	`password` VARCHAR(20),
	PRIMARY KEY (`id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

insert into User(`email`, `user_name`, `first_name`, `last_name`, `password`) values ('vanthuyphan@gmail.com', 'vanthuyphan', 'van', 'phan', '123456');
insert into User(`email`, `user_name`, `first_name`, `last_name`, `password`) values ('bati@gmail.com', 'bati', 'bati', 'bati', '123456');


CREATE TABLE IF NOT EXISTS `Event` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(100),
	`start_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`end_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`begin_location` VARCHAR(50),
	`end_location` VARCHAR(50),
	`distance` FLOAT,
	`comment` VARCHAR(100),
	`status` VARCHAR(100),
	`accident_location` VARCHAR(100),
	`accident_description` VARCHAR(100),
	`owner` BIGINT,
	`hasAccident` SMALLINT,
	PRIMARY KEY (`id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

insert into Event(`title`, `start_date`, `end_date`, `begin_location`, `end_location`, `distance`, `comment`, `status`, `accident_location`, `accident_description`, `hasAccident`, `owner`)
values ('Test Event', '2018-04-25', '2018-04-27', 'London', 'Paris', 120, 'Windy Road', 'On Going', '', '', 0, 1);

CREATE TABLE IF NOT EXISTS `UserEvent` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` BIGINT,
	`event_id` BIGINT,
	`owner` SMALLINT DEFAULT 0,
	PRIMARY KEY (`id`)
) ENGINE MyISAM DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
INSERT INTO `userevent` (`user_id`, `event_id`, `owner`) VALUES ('1', '1', '0');
