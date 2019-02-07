-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema shopr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopr` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shopr` ;

-- -----------------------------------------------------
-- Table `shopr`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`book` (
  `author` VARCHAR(255) NULL DEFAULT NULL,
  `isbn` VARCHAR(255) NULL DEFAULT NULL,
  `pages` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`fiction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`fiction` (
  `fiction_genre` VARCHAR(255) NULL DEFAULT NULL,
  `summary` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`flyway_schema_history` (
  `installed_rank` INT(11) NOT NULL,
  `version` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `script` VARCHAR(1000) NOT NULL,
  `checksum` INT(11) NULL DEFAULT NULL,
  `installed_by` VARCHAR(100) NOT NULL,
  `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` INT(11) NOT NULL,
  `success` TINYINT(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  INDEX `flyway_schema_history_s_idx` (`success` ASC) VISIBLE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`game` (
  `game_genre` VARCHAR(255) NULL DEFAULT NULL,
  `min_age` INT(11) NULL DEFAULT NULL,
  `publisher` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`lp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`lp` (
  `artist` VARCHAR(255) NULL DEFAULT NULL,
  `lp_genre` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`non_fiction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`non_fiction` (
  `nonfiction_subject` VARCHAR(255) NULL DEFAULT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`product` (
  `type` VARCHAR(31) NOT NULL,
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `price` DOUBLE NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `version` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = MyISAM
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `shopr`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `shopr`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `version` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = MyISAM
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;