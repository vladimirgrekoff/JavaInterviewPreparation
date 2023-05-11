-- drop TABLE cinema.cinema_session;   
-- drop TABLE cinema.tickets;   
-- drop TABLE cinema.films;   
-- drop SCHEMA cinema;


CREATE SCHEMA cinema; 
USE cinema;
CREATE TABLE IF NOT EXISTS  `cinema`.`films`(
  `cinema_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `year` INT,
  `director` varchar(45),
  `duration` INT NOT NULL,
  PRIMARY KEY (`cinema_id`));

INSERT INTO cinema.films
VALUES (1,'Куб ', 1997, 'Винченцо Натали', 90),
       (2,'Паприка', 2006, 'Сэиси Минаками', 90),
       (3,'Самый лучший босс', 2021, 'Фернандо Леон Де Араноа', 120),
       (4,'Человек с Земли', 2007, 'Ричард Шенкман', 90);
       
CREATE TABLE IF NOT EXISTS  `cinema`.`tickets`(
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `price` BigInt,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`ticket_id`));       
       
INSERT INTO cinema.tickets
VALUES (1, 200, 80),
       (2, 300, 100),
       (3, 400, 200),
       (4, 600, 250);       
  
CREATE TABLE IF NOT EXISTS `cinema`.`cinema_session`(
`session_id` INT PRIMARY KEY AUTO_INCREMENT,
`start_time` time,
`film_id` INT NOT NULL,
`category` INT NOT NULL,
CONSTRAINT  `session_ibfk_1` FOREIGN KEY  (`film_id`) REFERENCES `cinema`.`films`(`cinema_id`),
CONSTRAINT  `session_ibfk_2` FOREIGN KEY  (`category`) REFERENCES `cinema`.`tickets`(`ticket_id`));

INSERT INTO cinema.cinema_session
VALUES (1, '14:00', 1, 1), 
       (2, '16:00', 4, 2),
       (3, '18:00', 2, 2),
       (4, '20:00', 4, 3),
       (5, '22:00', 3, 4);       
       
       
