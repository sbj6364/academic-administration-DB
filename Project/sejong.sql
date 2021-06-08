-- MySQL Script generated by MySQL Workbench
-- Wed Jun  2 22:16:16 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP DATABASE IF EXISTS  madang;
DROP USER IF EXISTS  madang@localhost;
create user madang@localhost identified WITH mysql_native_password  by 'madang';
create database madang;
grant all privileges on madang.* to madang@localhost with grant option;
commit;

USE `madang`;

-- -----------------------------------------------------
-- Table `madang`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`course` (
  `student_id` INT NOT NULL,
  `lecture_id` INT NOT NULL,
  `prof_id` INT NOT NULL,
  `class_id` INT NOT NULL,
  `attendance` INT NOT NULL DEFAULT 0,
  `midterm` INT NULL DEFAULT 0,
  `final` INT NULL DEFAULT 0,
  `etc` INT NULL DEFAULT 0,
  `total` INT NOT NULL DEFAULT 0,
  `gpa` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `lecture_id`, `prof_id`, `class_id`),
  INDEX `idx_lectureid` (`lecture_id` ASC) VISIBLE,
  INDEX `idx_studentid` (`student_id` ASC) VISIBLE,
  INDEX `idx_prof_id` (`prof_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `madang`.`club_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`club_member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `club_id` INT NOT NULL,
  `student_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_clubid` (`club_id` ASC) VISIBLE,
  INDEX `idx_studentid` (`student_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



-- -----------------------------------------------------
-- Table `madang`.`tuition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`tuition` (
  `student_id` INT NOT NULL,
  `year` INT NOT NULL,
  `semester` INT NULL DEFAULT NULL,
  `total_tuition` INT NULL DEFAULT NULL,
  `total_paid` INT NULL DEFAULT NULL,
  `last_paid` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  INDEX `idx_studentid` (`student_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `madang`.`student`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `madang`.`student` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `dept_id` INT NOT NULL,
  `subdept_id` INT NULL DEFAULT NULL,
  `prof_id` INT NOT NULL,
  `account` VARCHAR(45) NOT NULL,
  INDEX `idx_deptid` (`dept_id` ASC) VISIBLE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;




-- -----------------------------------------------------
-- Table `madang`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`professor` (
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
    REFERENCES `madang`.`course` (`prof_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `madang`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`club` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `student_num` INT NULL DEFAULT NULL,
  `president_id` INT NULL DEFAULT NULL,
  `room` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `madang`.`lecture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`lecture` (
  `id` INT NOT NULL,
  `class_id` INT NOT NULL,
  `prof_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `day` VARCHAR(45) NULL DEFAULT NULL,
  `period` INT NULL DEFAULT NULL,
  `credit` INT NULL DEFAULT NULL,
  `time` INT NULL DEFAULT NULL,
  `dept_id` INT NULL DEFAULT NULL,
  `room` VARCHAR(45) NULL DEFAULT NULL,
  `year` INT NULL,
  `semester` INT NULL,
  PRIMARY KEY (`id`, `class_id`),
  INDEX `idx_deptid` (`dept_id` ASC) VISIBLE,
  CONSTRAINT `fk_lecture_course1`
    FOREIGN KEY (`id`)
    REFERENCES `madang`.`course` (`lecture_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;






-- -----------------------------------------------------
-- Table `madang`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `madang`.`department` (
  `id` INT NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `office` VARCHAR(15) NULL DEFAULT NULL,
  `headprof_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_department_student1`
    FOREIGN KEY (`id`)
    REFERENCES `madang`.`student` (`dept_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_department_lecture1`
    FOREIGN KEY (`id`)
    REFERENCES `madang`.`lecture` (`dept_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;




# 스마트기기공학과 3232
# 무인이동체공학과 3231
# 데이터사이언스학과 3225
# 소프트웨어학과 3220
# 컴퓨터공학과 3210
# 미디어커뮤니케이션학과 2233
# 정보보호학과 3215
# 건축공학부 2769
# 화학과 2433
# 전자정보통신공학과 2930
# 


INSERT INTO `student` VALUES(17011801, '김진명', '경기도 광주시', '010-2345-2341', 'kmj@madang.ac.kr', 3232, NULL, 130010, '케이뱅크 123-123456-12413');
INSERT INTO `student` VALUES(17011802, '박세환', '경기도 화성시', '010-5423-1435', 'psh@madang.ac.kr', 3231, NULL, 130009, '국민은행 535-234252-45235');
INSERT INTO `student` VALUES(17011803, '장재호', '서울특별시 은평구', '010-7634-5632', 'jjh@madang.ac.kr', 3220, NULL, 130007, '농협 343-523263-34231');
INSERT INTO `student` VALUES(17011804, '배성현', '경상남도 포항시', '010-3646-2468', 'bsh@madang.ac.kr', 3231, NULL, 130009, '농협 342-234212-23415');
INSERT INTO `student` VALUES(17011805, '강민수', '경기도 여주시', '010-4573-2346', 'kms@madang.ac.kr', 3231, NULL, 130009, '국민은행 734-452346-23456');
INSERT INTO `student` VALUES(17011806, '서병준', '서울특별시 광진구', '010-4181-6364', 'sbj6364@daum.net', 3232, 3225, 130010, '기업은행 979-012182-01-012');
INSERT INTO `student` VALUES(17011807, '윤혜정', '서울특별시 중랑구', '010-2356-8364', 'yhj@madang.ac.kr', 3225, NULL, 130008, '국민은행 646-352536-43523');
INSERT INTO `student` VALUES(17011808, '곽경민', '서울특별시 광진구', '010-7234-1786', 'kkm@madang.ac.kr', 2233, NULL, 130004, '농협 123-42352-234125');
INSERT INTO `student` VALUES(17011809, '문이선', '광주광역시 서구', '010-5362-2351', 'mis@madang.ac.kr', 3232, 3225, 130010, '우리은행 12343-45456-342');
INSERT INTO `student` VALUES(17011810, '이주혁', '서울특별시 광진구', '010-3472-3646', 'ljh@madang.ac.kr', 3220, NULL, 130007, '국민은행 3425-3423-235673');
# 10 아래부터 과, 교수님, 계좌번호 바꿔야 함
INSERT INTO `student` VALUES(17011811, '공성호', '경상남도 창원시', '010-6753-2341', 'kshmadang.ac.kr', 2769, NULL, 130003, '새마을금고 143-123456-12413');
INSERT INTO `student` VALUES(17011812, '김진현', '경상남도 창원시', '010-5423-5323', 'kjh@madang.ac.kr', 2433, NULL, 130005, '카카오뱅크 234-234252-45235');
INSERT INTO `student` VALUES(17011813, '안병건', '서울특별시 노원구', '010-6477-5632', 'abk@madang.ac.kr', 2930, NULL, 130002, '신한은행 343-324553-34231');
INSERT INTO `student` VALUES(17011814, '이종욱', '서울특별시 노원구', '010-3646-4532', 'ljw@madang.ac.kr', 2930, NULL, 130002, '신한은행 342-234212-65347');
INSERT INTO `student` VALUES(17011815, '권승필', '경기도 화성시', '010-3456-2346', 'ksp@madang.ac.kr', 3215, NULL, 130006, '하나은행 734-345236-23456');
INSERT INTO `student` VALUES(17011816, '권도윤', '서울특별시 노원구', '010-6453-4643', 'kdy@daum.net', 3225, NULL, 130008, '기업은행 346-012182-01-012');
INSERT INTO `student` VALUES(17011817, '김민석', '경상남도 통영시', '010-4532-8364', 'kms@madang.ac.kr', 3232, NULL, 130010, '경남은행 646-267573-43523');
INSERT INTO `student` VALUES(17011818, '김지오', '경기도 분당시', '010-7234-6472', 'kjo@madang.ac.kr', 3225, NULL, 130008, '농협 123-42352-53452');
INSERT INTO `student` VALUES(17011819, '김연우', '경기도 분당시', '010-3426-2351', 'kyw@madang.ac.kr', 3232, NULL, 130010, '우리은행 34253-545656-745');
INSERT INTO `student` VALUES(17011820, '문승재', '제주특별자치도 서귀포시', '010-3472-4367', 'msj@madang.ac.kr', 3225, NULL, 130008, '기업은행 453-534657-54534');
# 20
INSERT INTO `student` VALUES(17011821, '박준희', '경기도 분당시', '010-8765-2371', 'pjh@madang.ac.kr', 3232, NULL, 130010, '국민은행 536-564574-12413');
INSERT INTO `student` VALUES(17011822, '안정연', '서울특별시 광진구', '010-5423-5673', 'ajy@madang.ac.kr', 3210, NULL, 130001, '국민은행 786-234252-652788');
INSERT INTO `student` VALUES(17011823, '원종서', '서울특별시 광진구', '010-4532-5632', 'wjs@madang.ac.kr', 3210, NULL, 130001, '하나은행 560-875408-02345');
INSERT INTO `student` VALUES(17011824, '윤상혁', '서울특별시 광진구', '010-3646-1634', 'ysh@madang.ac.kr', 3210, NULL, 130001, '신한은행 245-657489-45347');
INSERT INTO `student` VALUES(17011825, '이다은', '경기도 포천시', '010-4674-6453', 'lde@madang.ac.kr', 3232, NULL, 130010, '국민은행 236-564322-76483');

-- INSERT INTO `student` VALUES(17011826, '홍길동', '서울특별시 광진구', '010-1234-2323', 'hgd@madang.ac.kr', 3232, NULL, 130001, '국민은행 236-342243-76483');


-- ------------------------------
-- Professor
-- 교수 - 학생 관계 특성상 10명만 insert
-- ------------------------------
INSERT INTO `professor` VALUES (130001, '신동일', '서울특별시 광진구', '02-3408-3241', 'dshin@madang.ac.kr', 3210, NULL);
INSERT INTO `professor` VALUES (130002, '김연아', '서울특별시 중랑구', '02-3408-2000', 'kya@madang.ac.kr', 2930, NULL); 
INSERT INTO `professor` VALUES (130003, '장미란', '서울특별시 광진구', '02-3408-2001', 'jmr@madang.ac.kr', 2769, NULL);
INSERT INTO `professor` VALUES (130004, '추신수', '서울특별시 노원구', '02-3408-2002', 'css@madang.ac.kr', 2233, NULL);
INSERT INTO `professor` VALUES (130005, '박세리', '서울특별시 은평구', '02-3408-2003', 'psr@madang.ac.kr', 2433, NULL);
INSERT INTO `professor` VALUES (130006, '박지성', '서울특별시 마포구', '02-3408-2004', 'pjs@madang.ac.kr', 3215, NULL);
INSERT INTO `professor` VALUES (130007, '손흥민', '서울특별시 영등포구', '02-3408-2005', 'shm@madang.ac.kr', 3220, NULL); 
INSERT INTO `professor` VALUES (130008, '이강인', '경기도 분당시', '02-3408-2006', 'lki@madang.ac.kr', 3225, NULL);
INSERT INTO `professor` VALUES (130009, '서장훈', '서울특별시 광진구', '02-3408-2007', 'sjh@madang.ac.kr', 3231, NULL);
INSERT INTO `professor` VALUES (130010, '유재석', '서울특별시 마포구', '02-3408-2008', 'yjs@madang.ac.kr', 3232, NULL);
-- 10
INSERT INTO `professor` VALUES (130011, '강호동', '서울특별시 관악구', '02-3408-2009', 'khd@madang.ac.kr', 3232, NULL);


-- ------------------------------
-- Department
-- DB 특성상 10개만 insert
-- ------------------------------
# 스마트기기공학과 3232
# 무인이동체공학과 3231
# 데이터사이언스학과 3225
# 소프트웨어학과 3220
# 컴퓨터공학과 3210
# 미디어커뮤니케이션학과 2233
# 정보보호학과 3215
# 건축공학부 2769
# 화학과 2433
# 전자정보통신공학과 2930
-- ------------------------------
INSERT INTO `department` VALUES (2233, '미디어커뮤니케이션학과', '집506', 130004); 
INSERT INTO `department` VALUES (2433, '화학과', '영215', 130005); 
INSERT INTO `department` VALUES (2769, '건축공학부', '충225', 130003); 
INSERT INTO `department` VALUES (2930, '전자정보통신공학과', '충922', 130002); 
INSERT INTO `department` VALUES (3210, '컴퓨터공학과', '센442', 130001); 
INSERT INTO `department` VALUES (3215, '정보보호학과', '센404', 130006); 
INSERT INTO `department` VALUES (3220, '소프트웨어학과', '센402', 130007); 
INSERT INTO `department` VALUES (3225, '데이터사이언스학과', '센403', 130008); 
INSERT INTO `department` VALUES (3231, '무인이동체공학과', '센405', 130009); 
INSERT INTO `department` VALUES (3232, '스마트기기공학전공', '센405', 130010); 




-- ------------------------------
-- Lecture
-- DB 특성상 15개만 insert
-- ------------------------------
# 스마트기기공학과 3232 기계학습
# 무인이동체공학과 3231 동역학
# 데이터사이언스학과 3225 데이터시각화
# 소프트웨어학과 3220 JAVA프로그래밍
# 컴퓨터공학과 3210 데이터베이스
# 미디어커뮤니케이션학과 2233 정보리터러시
# 정보보호학과 3215 대칭키암호론
# 건축공학부 2769 건축개론
# 화학과 2433 무기화학
# 전자정보통신공학과 2930 디지털신호처리
-- ------------------------------
INSERT INTO `lecture` VALUES (301, 01, 130001, '데이터베이스', 'TUE', 1, 3, 90, 3210, '센B103', 2021, 1);
INSERT INTO `lecture` VALUES (301, 02, 130001, '데이터베이스', 'TUE', 2, 3, 90, 3210, '센B103', 2021, 1);
INSERT INTO `lecture` VALUES (302, 01, 130002, '디지털신호처리', 'WED', 1, 3, 90, 2930, '충410', 2021, 1);
INSERT INTO `lecture` VALUES (303, 01, 130003, '건축개론', 'MON', 1, 3, 180, 2769, '이103', 2021, 1);
INSERT INTO `lecture` VALUES (304, 01, 130004, '조직커뮤니케이션', 'MON', 4, 3, 90, 2233, '집403', 2021, 1);
INSERT INTO `lecture` VALUES (305, 01, 130005, '무기화학', 'TUE', 1, 3, 90, 2433, '영302', 2021, 1);
INSERT INTO `lecture` VALUES (305, 02, 130005, '무기화학', 'TUE', 2, 3, 90, 2433, '영302', 2021, 1);
INSERT INTO `lecture` VALUES (306, 01, 130006, '대칭키암호론', 'THU', 2, 3, 90, 3215, '센B210', 2021, 1);
INSERT INTO `lecture` VALUES (307, 01, 130007, 'JAVA프로그래밍', 'FRI', 5, 3, 90, 3220, '센B209', 2021, 1);
INSERT INTO `lecture` VALUES (308, 01, 130008, '데이터시각화', 'THU', 6, 3, 90, 3225, '센B101', 2021, 1);
# 10
INSERT INTO `lecture` VALUES (309, 01, 130009, '동역학', 'WED', 1, 3, 180, 3231, '율201', 2021, 1);
INSERT INTO `lecture` VALUES (309, 02, 130009, '동역학', 'WED', 4, 3, 180, 3231, '율201', 2021, 1);
INSERT INTO `lecture` VALUES (310, 01, 130010, '기계학습', 'MON', 2, 3, 90, 3232, '센B102', 2021, 1);
INSERT INTO `lecture` VALUES (310, 02, 130010, '기계학습', 'MON', 4, 3, 90, 3232, '센B102', 2021, 1);
INSERT INTO `lecture` VALUES (310, 03, 130011, '기계학습', 'WED', 2, 3, 90, 3232, '센B102', 2021, 1);


-- ------------------------------
-- Course
-- ------------------------------
INSERT INTO `course` VALUES (17011801, 310, 130010, 1, 20, 30, 20, 20, 90, 'A0');
INSERT INTO `course` VALUES (17011802, 309, 130009, 1, 20, 20, 30, 20, 90, 'A0');
INSERT INTO `course` VALUES (17011803, 307, 130007, 1, 20, 10, 30, 15, 75, 'B+');
INSERT INTO `course` VALUES (17011804, 309, 130009, 1, 20, 30, 20, 0, 70, 'B+');
INSERT INTO `course` VALUES (17011805, 309, 130009, 2, 20, 20, 20, 20, 80, 'A0');
INSERT INTO `course` VALUES (17011806, 301, 130001, 2, 20, 30, 30, 20, 100, 'A+');
INSERT INTO `course` VALUES (17011806, 308, 130008, 1, 20, 30, 30, 20, 100, 'A+');
INSERT INTO `course` VALUES (17011806, 310, 130010, 1, 20, 30, 30, 20, 100, 'A+');
INSERT INTO `course` VALUES (17011807, 308, 130008, 1, 17, 30, 30, 20, 97, 'A+');
INSERT INTO `course` VALUES (17011808, 304, 130004, 1, 15, 30, 30, 10, 85, 'A0');
# 10
INSERT INTO `course` VALUES (17011809, 310, 130010, 2, 20, 30, 30, 10, 90, 'A0');
INSERT INTO `course` VALUES (17011810, 307, 130007, 1, 20, 30, 10, 20, 80, 'A0');
INSERT INTO `course` VALUES (17011811, 303, 130003, 1, 0, 10, 30, 10, 50, 'C0');
INSERT INTO `course` VALUES (17011812, 305, 130005, 1, 20, 10, 10, 20, 60, 'C+');
INSERT INTO `course` VALUES (17011813, 302, 130002, 1, 20, 25, 30, 20, 95, 'A+');
INSERT INTO `course` VALUES (17011814, 302, 130002, 1, 20, 30, 0, 20, 70, 'B+');
INSERT INTO `course` VALUES (17011815, 306, 130006, 1, 20, 30, 30, 20, 100, 'A+');
INSERT INTO `course` VALUES (17011816, 301, 130001, 2, 20, 0, 0, 10, 30, 'F');
INSERT INTO `course` VALUES (17011817, 304, 130004, 1, 20, 0, 10, 20, 50, 'C0');
INSERT INTO `course` VALUES (17011818, 301, 130001, 1, 20, 20, 10, 30, 80, 'A0');
# 20
INSERT INTO `course` VALUES (17011819, 308, 130008, 1, 15, 20, 15, 20, 70, 'B+');
INSERT INTO `course` VALUES (17011819, 310, 130011, 3, 20, 25, 30, 20, 95, 'A+');
INSERT INTO `course` VALUES (17011820, 301, 130001, 1, 20, 10, 15, 20, 65, 'B0');
INSERT INTO `course` VALUES (17011821, 310, 130011, 3, 20, 10, 10, 20, 60, 'C+');
INSERT INTO `course` VALUES (17011822, 301, 130001, 2, 20, 10, 10, 20, 80, 'A0');
INSERT INTO `course` VALUES (17011823, 301, 130001, 1, 20, 0, 15, 0, 35, 'F');
INSERT INTO `course` VALUES (17011824, 301, 130005, 2, 20, 25, 25, 20, 90, 'A0');
INSERT INTO `course` VALUES (17011825, 310, 130011, 3, 20, 30, 30, 20, 100, 'A+');


-- ------------------------------
-- Club
-- ------------------------------
-- DB 특성상 5개만 insert
-- ------------------------------
INSERT INTO `club` VALUES (1, 'InterFace', 4, 17011801, '학B201');
INSERT INTO `club` VALUES (2, 'SoundPlus', 5, 17011824, '학B202');
INSERT INTO `club` VALUES (3, 'Rammus', 10, 17011809, '학B203');
INSERT INTO `club` VALUES (4, 'NineSix', 4, 17011803, '학B204');
INSERT INTO `club` VALUES (5, 'Intro', 6, 17011819, '학B205');


-- ------------------------------
-- Club Member
-- ------------------------------
INSERT INTO `club_member` (`club_id`, `student_id`)  VALUES (1, 17011801);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (1, 17011806);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (1, 17011809);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (1, 17011820);

INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (2, 17011806);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (2, 17011808);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (2, 17011811);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (2, 17011812);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (2, 17011824);

INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011802);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011803);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011806);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011807);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011809);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011814);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011815);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011817);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011821);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (3, 17011822);

INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (4, 17011803);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (4, 17011818);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (4, 17011824);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (4, 17011825);

INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (6, 17011804);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (6, 17011810);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (6, 17011816);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (6, 17011819);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (6, 17011823);
INSERT INTO `club_member` (`club_id`, `student_id`) VALUES (6, 17011824);



-- ------------------------------
-- Tuition
-- ------------------------------
-- 
-- ------------------------------
INSERT INTO `tuition` VALUES (17011801, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011802, 2020, 2, 3974000, 3974000, STR_TO_DATE('2021-02-19','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011803, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011804, 2021, 1, 4274000, 2137000, STR_TO_DATE('2021-02-19','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011805, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-19','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011806, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-19','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011807, 2021, 1, 4142000, 4142000, STR_TO_DATE('2021-02-19','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011808, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-19','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011809, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-20','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011810, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 

INSERT INTO `tuition` VALUES (17011811, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-17','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011812, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011813, 2021, 1, 4503000, 4503000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011814, 2021, 1, 4503000, 4503000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011815, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-19','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011816, 2021, 1, 4142000, 4142000, STR_TO_DATE('2021-02-20','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011817, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011818, 2021, 1, 4142000, 4142000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011819, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-20','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011820, 2021, 1, 4142000, 2071000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 

INSERT INTO `tuition` VALUES (17011821, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011822, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011823, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011824, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 
INSERT INTO `tuition` VALUES (17011825, 2021, 1, 4274000, 4274000, STR_TO_DATE('2021-02-18','%Y-%m-%d')); 

commit;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
