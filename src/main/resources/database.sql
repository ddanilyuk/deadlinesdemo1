# CREATE DATABASE if not exists projectdemo1;
# USE projectdemo1;
#
# DROP TABLE IF EXISTS deadline ;
# DROP TABLE IF EXISTS project ;

# -- -----------------------------------------------------
# -- Table Project
# -- -----------------------------------------------------
# CREATE TABLE IF NOT EXISTS project (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `project_name` VARCHAR(200) NOT NULL,
#     `project_description` VARCHAR(200) NULL,
#     PRIMARY KEY (`id`)
# )
# ENGINE = InnoDB;
#
#
# -- -----------------------------------------------------
# -- Table `mydb`.`Deadline`
# -- -----------------------------------------------------
# CREATE TABLE IF NOT EXISTS deadline (
#      `deadline_id` INT NOT NULL AUTO_INCREMENT,
#      `deadline_name` VARCHAR(200) NOT NULL,
#      `deadline_description` VARCHAR(45) NULL,
#      `project_deadline_id` INT NOT NULL,
#      PRIMARY KEY (`deadline_id`),
#      INDEX `fk_Deadline_Project_idx` (`project_deadline_id` ASC) VISIBLE,
#      CONSTRAINT `fk_Deadline_Project`
#          FOREIGN KEY (`project_deadline_id`)
#              REFERENCES project (`id`)
#              ON DELETE NO ACTION
#              ON UPDATE NO ACTION
# )
# ENGINE = InnoDB;