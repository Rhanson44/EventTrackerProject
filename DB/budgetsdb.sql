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
-- Table `Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Category` ;

CREATE TABLE IF NOT EXISTS `Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Transaction` ;

CREATE TABLE IF NOT EXISTS `Transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `description` VARCHAR(300) NULL,
  `payment_date` DATETIME NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Transaction_Category_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_Transaction_Category`
    FOREIGN KEY (`category_id`)
    REFERENCES `Category` (`id`)
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
-- Data for table `Category`
-- -----------------------------------------------------
START TRANSACTION;
USE `budgetsdb`;
INSERT INTO `Category` (`id`, `name`) VALUES (1, 'Work');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Transaction`
-- -----------------------------------------------------
START TRANSACTION;
USE `budgetsdb`;
INSERT INTO `Transaction` (`id`, `type`, `amount`, `description`, `payment_date`, `category_id`) VALUES (1, 'Income', 10.00, NULL, NULL, 1);

COMMIT;

