-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema desafio_Jsp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `desafio_Jsp` DEFAULT CHARACTER SET utf8 ;
USE `desafio_Jsp` ;

-- -----------------------------------------------------
-- Table `desafio_Jsp`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `sobrenome` VARCHAR(45) NULL,
  `cpf` INT(11) NULL,
  `ativo` TINYINT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`regiao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`regiao` (
  `idRegiao` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NULL,
  `aplicaBairro` TINYINT NULL,
  `aplicaEstado` TINYINT NULL,
  `ativo` TINYINT NULL,
  PRIMARY KEY (`idRegiao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`estado` (
  `idEstado` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `uf` VARCHAR(2) NULL,
  `regiao` VARCHAR(15) NULL,
  `regiao_idregiao` INT NOT NULL,
  PRIMARY KEY (`idEstado`),
  INDEX `fk_estado_regiao1_idx` (`regiao_idregiao` ASC) VISIBLE,
  CONSTRAINT `fk_estado_regiao1`
    FOREIGN KEY (`regiao_idregiao`)
    REFERENCES `desafio_Jsp`.`regiao` (`idRegiao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`cidade` (
  `idCidade` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `estado_idestado` INT NOT NULL,
  PRIMARY KEY (`idCidade`),
  INDEX `fk_cidade_estado_idx` (`estado_idestado` ASC) VISIBLE,
  CONSTRAINT `fk_cidade_estado`
    FOREIGN KEY (`estado_idestado`)
    REFERENCES `desafio_Jsp`.`estado` (`idEstado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`bairro` (
  `idBairro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NULL,
  `cidade_idcidade` INT NOT NULL,
  `regiao_idregiao` INT NOT NULL,
  PRIMARY KEY (`idBairro`),
  INDEX `fk_bairro_cidade1_idx` (`cidade_idcidade` ASC) VISIBLE,
  INDEX `fk_bairro_regiao1_idx` (`regiao_idregiao` ASC) VISIBLE,
  CONSTRAINT `fk_bairro_cidade1`
    FOREIGN KEY (`cidade_idcidade`)
    REFERENCES `desafio_Jsp`.`cidade` (`idCidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bairro_regiao1`
    FOREIGN KEY (`regiao_idregiao`)
    REFERENCES `desafio_Jsp`.`regiao` (`idRegiao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`rua`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`rua` (
  `idRua` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `bairro_idbairro` INT NOT NULL,
  PRIMARY KEY (`idRua`),
  INDEX `fk_rua_bairro1_idx` (`bairro_idbairro` ASC) VISIBLE,
  CONSTRAINT `fk_rua_bairro1`
    FOREIGN KEY (`bairro_idbairro`)
    REFERENCES `desafio_Jsp`.`bairro` (`idBairro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `numero` INT(8) NULL,
  `principal` TINYINT NULL,
  `ativo` TINYINT NULL,
  `rua_idrua` INT NOT NULL,
  `usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idEndereco`),
  INDEX `fk_endereco_rua1_idx` (`rua_idrua` ASC) VISIBLE,
  INDEX `fk_endereco_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_rua1`
    FOREIGN KEY (`rua_idrua`)
    REFERENCES `desafio_Jsp`.`rua` (`idRua`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `desafio_Jsp`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`email` (
  `idEmail` INT NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(75) NULL,
  `ativo` TINYINT NULL,
  PRIMARY KEY (`idEmail`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`telefone` (
  `idTelefone` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(9) NULL,
  `ddd` VARCHAR(2) NULL,
  `principal` TINYINT NULL,
  `ativo` TINYINT NULL,
  PRIMARY KEY (`idTelefone`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desafio_Jsp`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desafio_Jsp`.`contato` (
  `idContato` INT NOT NULL AUTO_INCREMENT,
  `usuario_idUsuario` INT NOT NULL,
  `telefone_idtelefone` INT,
  `email_idemail` INT,
  PRIMARY KEY (`idContato`),
  INDEX `fk_contato_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_contato_telefone1_idx` (`telefone_idtelefone` ASC) VISIBLE,
  INDEX `fk_contato_email1_idx` (`email_idemail` ASC) VISIBLE,
  CONSTRAINT `fk_contato_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `desafio_Jsp`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contato_telefone1`
    FOREIGN KEY (`telefone_idtelefone`)
    REFERENCES `desafio_Jsp`.`telefone` (`idTelefone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contato_email1`
    FOREIGN KEY (`email_idemail`)
    REFERENCES `desafio_Jsp`.`email` (`idEmail`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- Inserts --
insert into regiao (nome, aplicaBairro, aplicaEstado, ativo) VALUES
("Norte",1,1,1),
("Sul",1,1,1),
("Leste",1,1,1),
("Oeste",1,1,1),
("Centro",1,0,1),
("Sudeste",0,1,1),
("Centro-Oeste",0,1,1),
("Nordeste ",0,1,1);

insert into estado(nome, uf, regiao_idregiao) VALUES
("Santa Catarina","SC",2),
("Paraná","PR",2),
("São Paulo","SP",6);

insert into cidade(nome, estado_idestado) VALUES
("Blumenau",1),
("Londrina",2),
("Bauru",3),
("Gaspar",1);

insert into bairro(nome, cidade_idcidade, regiao_idregiao) VALUES
("Itoupava Central",1,1),
("Badenfurt",1,4),
("Jardim Califórnia",2,3),
("Estoril",3,2);

insert into rua(nome, bairro_idbairro) VALUES
("Pedro Zimmermann",1),
("Werner Duwe",2),
("Atenas",3),
("Aviador Gomer Ribeiro",4);