CREATE SCHEMA students; 
use students;
-- DROP TABLE students;

CREATE TABLE IF NOT EXISTS  `students`.`students`(
  `id` INT NOT NULL  AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `mark` INT,
   PRIMARY KEY (`id`));
  

--DROP PROCEDURE IF EXISTS insert_new_students;
--DELIMITER $$
--
--CREATE PROCEDURE insert_new_students ()
--BEGIN
--  DECLARE i INT;
--  DECLARE studentName VARCHAR(45);
--  DECLARE mark INT DEFAULT 5;
--  SET i = 1;
--  START TRANSACTION;
--	WHILE i < 1001 DO
--		SET studentName = 'Джон';
--		SET studentName = concat(studentName, convert(i, char));
--		INSERT INTO students (name, mark)
--		VALUES(studentName, 5);
--		SET i = i + 1;
--	END WHILE;
--  COMMIT;
--END$$
--DELIMITER ;
--
--CALL insert_new_students();


