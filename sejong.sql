-- MySQL Script generated by MySQL Workbench
-- Wed Jun  2 22:16:16 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sejong
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sejong
-- -----------------------------------------------------
DROP DATABASE IF EXISTS  sejong;
DROP USER IF EXISTS  madang@localhost;
create user madang@localhost identified WITH mysql_native_password  by 'madang';
create database sejong;
grant all privileges on madang.* to madang@localhost with grant option;
commit;
-- -----------------------------------------------------
-- Schema madang
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sejong
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sejong
-- -----------------------------------------------------
USE `sejong` ;

-- -----------------------------------------------------
-- Table `sejong`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`course` (
  `student_id` INT NOT NULL,
  `lecture_id` INT NOT NULL,
  `prof_id` INT NOT NULL,
  `attendance` VARCHAR(45) NOT NULL,
  `midterm` VARCHAR(45) NULL,
  `final` INT NULL,
  `etc` INT NULL,
  `total` INT NULL,
  `gpa` VARCHAR(10) NULL,
  PRIMARY KEY (`student_id`, `lecture_id`, `prof_id`),
  INDEX `idx_lectureid` (`lecture_id`),
  INDEX `idx_studentid` (`student_id`),
  INDEX `idx_prof_id` (`prof_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sejong`.`club_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`club_member` (
  `club_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  PRIMARY KEY (`club_id`, `student_id`),
  INDEX `idx_clubid` (`club_id`),
  INDEX `idx_studentid` (`student_id`)
)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sejong`.`tuition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`tuition` (
  `id` INT NOT NULL,
  `student_id` INT NOT NULL,
  `year` INT NOT NULL,
  `semester` INT NULL,
  `total_tuition` INT NULL,
  `total_paid` INT NULL,
  `last_paid` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_studentid` (`student_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sejong`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`student` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `dept_id` INT NOT NULL,
  `subdept_id` INT NULL,
  `prof_id` INT NOT NULL,
  `account` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_deptid` (`dept_id`),
  CONSTRAINT `fk_student_course1`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`course` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_club_member1`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`club_member` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_tuition1`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`tuition` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sejong`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`professor` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `dept_id` INT NOT NULL,
  `subdept_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_professor_course`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`course` (`prof_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sejong`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`club` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `student_num` INT NULL,
  `president_id` INT NULL,
  `room` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_club_club_member1`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`club_member` (`club_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `sejong` ;

-- -----------------------------------------------------
-- Table `sejong`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`lecture` (
  `id` INT NOT NULL,
  `class_id` INT NOT NULL,
  `prof_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `day` VARCHAR(45) NULL,
  `period` INT NULL,
  `credit` INT NULL,
  `time` INT NULL,
  `dept_id` INT NULL,
  `room` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_deptid` (`dept_id`),
  CONSTRAINT `fk_lecture_course1`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`course` (`lecture_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sejong`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sejong`.`department` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `office` VARCHAR(15) NULL DEFAULT NULL,
  `headprof_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_department_student1`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`student` (`dept_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_department_lecture1`
    FOREIGN KEY (`id`)
    REFERENCES `sejong`.`lecture` (`dept_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;