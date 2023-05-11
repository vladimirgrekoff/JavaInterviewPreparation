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
select film_id as `№`,
(select name from films where films.cinema_id = cinema_session.film_id) as `Фильм`,
(select price from tickets where ticket_id = cinema_session.category) as `Цена`, 
(select quantity from tickets where ticket_id = cinema_session.category) as `Продано`,
((select price from tickets where ticket_id = cinema_session.category) * 
(select quantity from tickets where ticket_id = cinema_session.category)) as `Выручка` from cinema_session
order by `Выручка`, `Фильм`;

