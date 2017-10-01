create database phoenix;

use phoenix;

-- -----------------------------------------------------
-- Table `phoenix`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phoenix`.`role` ;

CREATE  TABLE IF NOT EXISTS `phoenix`.`role` (
  `role` VARCHAR(15) NOT NULL ,
  `accessPrivilege` VARCHAR(45) NULL ,
  PRIMARY KEY (`role`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `role_UNIQUE` ON `phoenix`.`role` (`role` ASC) ;


-- -----------------------------------------------------
-- Table `phoenix`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phoenix`.`user` ;

CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `role_index` (`role`),
  KEY `name_index` (`name`)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `phoenix`.`user` (`id` ASC) ;

CREATE INDEX `role_index` ON `phoenix`.`user` (`role` ASC) ;

-- -----------------------------------------------------
-- Table `phoenix`.`radio-program`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phoenix`.`radio-program` ;

CREATE TABLE IF NOT EXISTS `phoenix`.`radio-program` (
  `name` VARCHAR(45) NOT NULL ,
  `desc` VARCHAR(100) NULL ,
  `typicalDuration` TIME NULL ,
  PRIMARY KEY (`name`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `phoenix`.`radio-program` (`name` ASC) ;


-- -----------------------------------------------------
-- Table `phoenix`.`annual-schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phoenix`.`annual-schedule` ;

CREATE  TABLE IF NOT EXISTS `phoenix`.`annual-schedule` (
  `year` INT NOT NULL ,
  `assingedBy` VARCHAR(45) NULL ,
  PRIMARY KEY (`year`) ,
  CONSTRAINT `id_as`
    FOREIGN KEY (`assingedBy` )
    REFERENCES `phoenix`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `id_annual_schedule` ON `phoenix`.`annual-schedule` (`assingedBy` ASC) ;

-- -----------------------------------------------------
-- Table `phoenix`.`program-slot`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phoenix`.`program-slot` ;

CREATE TABLE `program-slot` (
  `duration` int NOT NULL,
  `dateOfProgram` date NOT NULL,
  `startTime` time NOT NULL,
  `program-name` varchar(45) NOT NULL,
  `presenter` varchar(45) DEFAULT NULL,
  `producer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dateOfProgram`,`program-name`,`startTime`),
  KEY `name_program_slot` (`program-name`),
  KEY `presenter_idx` (`presenter`),
  KEY `producer_idx` (`producer`),
  CONSTRAINT `name` FOREIGN KEY (`program-name`) REFERENCES `radio-program` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `presenter` FOREIGN KEY (`presenter`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `producer` FOREIGN KEY (`producer`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

CREATE INDEX `name_program_slot_idx` ON `phoenix`.`program-slot` (`program-name` ASC) ;

-- CREATE UNIQUE INDEX `dateOfProgram_UNIQUE` ON `phoenix`.`program-slot` (`dateOfProgram` ASC) ;


-- -----------------------------------------------------
-- Table `phoenix`.`weekly-schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phoenix`.`weekly-schedule` ;
CREATE  TABLE IF NOT EXISTS `phoenix`.`weekly-schedule` (
  `weekNo` VARCHAR(16),
  `startDate` DATETIME NOT NULL ,
  `assignedBy` VARCHAR(45) NULL ,
  PRIMARY KEY (`startDate`) ,
  CONSTRAINT `id_ws`
    FOREIGN KEY (`assignedBy` )
    REFERENCES `phoenix`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `startDate_UNIQUE` ON `phoenix`.`weekly-schedule` (`startDate` ASC) ;

CREATE INDEX `id_assigned_by` ON `phoenix`.`weekly-schedule` (`assignedBy` ASC) ;
