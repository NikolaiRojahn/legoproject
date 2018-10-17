-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lego
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lego
-- -----------------------------------------------------
USE `lego`;
DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS orders;
DROP DATABASE IF EXISTS lego;

CREATE DATABASE `lego`;
CREATE SCHEMA IF NOT EXISTS `lego` DEFAULT CHARACTER SET utf8 ;
USE `lego` ;
-- -----------------------------------------------------
-- Table `lego`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
   UNIQUE KEY (`email`),
   PRIMARY KEY (`id`))

ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lego`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `u_id` INT NOT NULL,
  `orderdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `shipped` VARCHAR(15) DEFAULT "NOT SHIPPED",
  PRIMARY KEY (`order_id`),
  INDEX `u_id_idx` (`u_id` ASC),
  CONSTRAINT `Link_to_user_id`
    FOREIGN KEY (`u_id`)
    REFERENCES `lego`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lego`.`order_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lego`.`order_details` (
  `o_id` INT NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `heigth` INT NOT NULL,
  CONSTRAINT `order_id`
    FOREIGN KEY (`o_id`)
    REFERENCES `lego`.`orders` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
