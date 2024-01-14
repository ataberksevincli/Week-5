SELECT DISTINCT replacement_cost FROM film;
SELECT COUNT(DISTINCT replacement_cost) FROM film;
SELECT COUNT(DISTINCT title LIKE 'T%' AND rating = 'G') FROM film;
SELECT COUNT(length(country) = 5) FROM country;
SELECT COUNT(length(country) = 5) FROM country;
SELECT COUNT(city) FROM city WHERE city ILIKE '%r';