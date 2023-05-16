use cinema;
-- Длительность перерывов между сеансами в порядке уменьшения
SELECT session_id AS `Сеанс`,
(SELECT films.name FROM films WHERE cinema_id = cinema_session.film_id) AS `Фильм`, 
start_time AS `Начало`, 
(SELECT films.duration FROM films WHERE cinema_id = cinema_session.film_id) AS `Длительность`,
(SELECT start_time FROM cinema_session WHERE session_id = `Сеанс` + 1 ) AS `Следующий`,
round(((time_to_sec(TIME((SELECT start_time FROM cinema_session WHERE session_id = `Сеанс` + 1)
 - (SELECT start_time FROM cinema_session WHERE session_id = `Сеанс`)))
 - (SELECT (films.duration) FROM films WHERE cinema_id = cinema_session.film_id)*60)/60)) AS `Перерыв`
FROM cinema_session
ORDER by `Перерыв` DESC; 

-- use cinema;
-- продажа билетов по сеансам
SELECT session_id AS `Сеанс`,
(SELECT name FROM films WHERE films.cinema_id = cinema_session.film_id) AS `Фильм`,
(SELECT price FROM tickets WHERE ticket_id = cinema_session.category) AS `Цена`,
(SELECT quantity FROM tickets WHERE ticket_id = cinema_session.category) AS `Продано`,
((SELECT price FROM tickets WHERE ticket_id = cinema_session.category) *
(SELECT quantity FROM tickets WHERE ticket_id = cinema_session.category)) AS `Выручка` FROM cinema_session
-- order by film_id, `Выручка`, `Фильм`;
ORDER BY session_id;

-- use cinema;
-- продажа билетов по названию фильма
(SELECT film_id AS `№`, films.name AS `Фильм`, COUNT(films.name) AS `Демонстрации`, SUM(tickets.quantity) AS `Продано`,
		SUM(tickets.quantity*tickets.price) AS `Выручка` FROM cinema_session
JOIN films ON films.cinema_id = film_id
JOIN tickets ON tickets.ticket_id = category
GROUP BY films.name
ORDER BY film_id)
UNION ALL
SELECT 'Итого:','','','', SUM(quantity*price)  FROM cinema_session
JOIN tickets ON tickets.ticket_id = category;



