-- MySQL Script generated by MySQL Workbench
-- 03/03/17 17:52:35
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';



-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mall
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mall
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mall` DEFAULT CHARACTER SET utf8 ;
USE `mall` ;


-- -----------------------------------------------------
-- table PERSISTENT_LOGINS  remember-me
-- -----------------------------------------------------
create table PERSISTENT_LOGINS
(
  username  VARCHAR(64) not null,
  series   VARCHAR(64) not null,
  token     VARCHAR(64) not null,
  last_used DATE not null
);
alter table PERSISTENT_LOGINS
  add constraint PK_PERSISTENT_LOGIN primary key (series

-- -----------------------------------------------------
-- Table `mall`.`account_state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mall`.`account_state` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COMMENT = '账户状态表';


-- -----------------------------------------------------
-- Table `mall`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mall`.`account` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(32) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `nickname` VARCHAR(32) NOT NULL,
  `age` INT(11) NOT NULL,
  `state_id` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `account_UNIQUE` (`account` ASC),
  INDEX `fk_account_state_id_idx` (`state_id` ASC),
  CONSTRAINT `fk_account_state_id`
    FOREIGN KEY (`state_id`)
    REFERENCES `mall`.`account_state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COMMENT = '账户表';


-- -----------------------------------------------------
-- Table `mall`.`user_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mall`.`user_profile` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8
COMMENT = '用户类型表';


-- -----------------------------------------------------
-- Table `mall`.`account_user_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mall`.`account_user_profile` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `account_id` INT(11) NULL DEFAULT NULL,
  `user_profile_id` INT(11) NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`account_id` ASC),
  INDEX `fk_user_profile_id_idx` (`user_profile_id` ASC),
  CONSTRAINT `fk_account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `mall`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_profile_id`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `mall`.`user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8
COMMENT = '账户-用户类型关联状态表';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
