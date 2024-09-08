-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema budgetsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `budgetsdb` ;

-- -----------------------------------------------------
-- Schema budgetsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `budgetsdb` DEFAULT CHARACTER SET utf8 ;
USE `budgetsdb` ;

-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transaction_party`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transaction_party` ;

CREATE TABLE IF NOT EXISTS `transaction_party` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transaction` ;

CREATE TABLE IF NOT EXISTS `transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `description` VARCHAR(300) NULL,
  `payment_date` DATETIME NULL,
  `category_id` INT NOT NULL,
  `transaction_party_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Transaction_Category_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_transaction_transaction_party1_idx` (`transaction_party_id` ASC) VISIBLE,
  CONSTRAINT `fk_Transaction_Category`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_transaction_party1`
    FOREIGN KEY (`transaction_party_id`)
    REFERENCES `transaction_party` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account` ;

CREATE TABLE IF NOT EXISTS `account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NULL,
  `balance` DOUBLE NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_account_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_account_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS budgetuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'budgetuser'@'localhost' IDENTIFIED BY 'budgetuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'budgetuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `budgetsdb`;
INSERT INTO `category` (`id`, `name`) VALUES (1, 'Work');

COMMIT;


-- -----------------------------------------------------
-- Data for table `transaction_party`
-- -----------------------------------------------------
START TRANSACTION;
USE `budgetsdb`;
INSERT INTO `transaction_party` (`id`, `name`) VALUES (1, 'FirstBank');

COMMIT;


-- -----------------------------------------------------
-- Data for table `transaction`
-- -----------------------------------------------------
START TRANSACTION;
USE `budgetsdb`;
INSERT INTO `transaction` (`id`, `type`, `amount`, `description`, `payment_date`, `category_id`, `transaction_party_id`) VALUES (1, 'Income', 10.00, NULL, NULL, 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `budgetsdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`) VALUES (1, 'user', 'user', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `account`
-- -----------------------------------------------------
START TRANSACTION;
USE `budgetsdb`;
INSERT INTO `account` (`id`, `type`, `balance`, `user_id`) VALUES (1, 'Checking', 100.00, 1);

COMMIT;

