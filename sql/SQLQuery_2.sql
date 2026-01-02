--34. Create a view to display publisher name, city, and no of books published.

CREATE VIEW vw_publisher_books
AS 
SELECT p.pub_name, p.city, COUNT(t.title_id) AS no_of_books
FROM publishers p
LEFT JOIN titles t
 ON p.pub_id = t.pub_id
GROUP BY p.pub_name, p.city;