CREATE DATABASE Pubs;
USE Pubs;

CREATE TABLE authors(
    au_id VARCHAR(11) PRIMARY KEY,
    au_fname VARCHAR(20),
    au_lname VARCHAR(40),
    city VARCHAR(20),
    state CHAR(2),
    zip CHAR(5),
    contract BIT
);

CREATE TABLE publishers(
    pub_id CHAR(4) PRIMARY KEY,
    pub_name VARCHAR(40),
    city VARCHAR(20),
    state CHAR(2),
    country VARCHAR(30)
);

CREATE TABLE titles(
    title_id VARCHAR(6) PRIMARY KEY,
    title VARCHAR(80),
    type CHAR(12),
    pub_id CHAR(4),
    price MONEY,
    advance MONEY,
    royalty INT,
    ytd_sales INT,
    notes VARCHAR(200),
    pubdate DATETIME,
    CONSTRAINT fk_titles_pub FOREIGN KEY(pub_id) REFERENCES publishers(pub_id)
);

CREATE TABLE titleauthor(
    au_id VARCHAR(11),
    title_id VARCHAR(6),
    au_ord TINYINT,
    royaltyper INT,
    CONSTRAINT fk_ta_author FOREIGN KEY (au_id) REFERENCES authors(au_id),
    CONSTRAINT fk_ta_title FOREIGN KEY (title_id) REFERENCES titles(title_id)
);

CREATE TABLE roysched(
    title_id VARCHAR(6),
    lorange INT,
    hirange INT,
    royalty INT,
    CONSTRAINT fk_roy_title FOREIGN KEY (title_id) REFERENCES titles(title_id)
);

CREATE TABLE sales(
    stor_id CHAR(4),
    ord_num VARCHAR(20),
    ord_date DATETIME,
    qty SMALLINT,
    payterms VARCHAR(12),
    title_id VARCHAR(6),
    CONSTRAINT fk_sales_title FOREIGN KEY (title_id) REFERENCES titles(title_id)
);

SELECT name AS table_name
FROM sys.tables;

-- 1. Add new column to products table that stores tax rate for the products update tax rate to 12% to all products.

ALTER TABLE titles
ADD tax_rate DECIMAL(5,2) DEFAULT 12;

SELECT * FROM publishers;

INSERT INTO publishers (pub_id, pub_name, city, state, country) VALUES
('0736', 'New Age Books', 'New York', 'NY', 'USA'),
('0877', 'Tech Press', 'Boston', 'MA', 'USA'),
('0911', 'Global Reads', 'London', NULL, 'UK'),
('0999', 'Edu World', 'Delhi', NULL, 'India');

SELECT * FROM authors;

INSERT INTO authors (au_id, au_fname, au_lname, city, state, zip, contract) VALUES
('A001', 'Sonika', 'Arisetti', 'Menlo Park', 'CA', '94025', 1),
('A002', 'Dean', 'Martin', 'Boston', 'MA', '02101', 1),
('A003', 'Smith', 'John', 'Menlo Park', 'CA', '94025', 0),
('A004', 'Sara', 'Lee', 'New York', 'NY', '10001', 1),
('A005', 'Steve', 'Brown', 'Chicago', 'IL', '60601', 1);

SELECT * FROM titles;

INSERT INTO titles (title_id, title, type, pub_id, price, advance, royalty, ytd_sales, pubdate) VALUES
('BU1111', 'Business Skills', 'business', '0736', 20.00, 5000, 15, 12000, '2015-06-10'),
('PS2222', 'Psychology Facts', 'psychology', '0877', 18.50, 4000, 18, 8000, '2018-03-15'),
('UN3333', 'Undecided Paths', 'undecided', '0736', NULL, 3000, 10, 4000, '2021-01-20'),
('MC2222', 'Modern Coding', 'technology', '0877', 25.00, 6000, 20, 15000, '2020-11-05'),
('DS4444', 'Data Science', 'technology', '0911', 30.00, 7000, 25, 22000, '1991-07-12');

SELECT * FROM titleauthor;

INSERT INTO titleauthor (au_id, title_id, au_ord, royaltyper) VALUES
('A001', 'BU1111', 1, 60),
('A002', 'BU1111', 2, 40),
('A003', 'PS2222', 1, 100),
('A001', 'UN3333', 1, 100),
('A004', 'MC2222', 1, 100),
('A005', 'DS4444', 1, 100),
('A001', 'DS4444', 2, 50);

SELECT * FROM sales;

INSERT INTO sales (stor_id, ord_num, ord_date, qty, payterms, title_id) VALUES
('S001', 'ORD01', '2022-01-10', 10, 'Net 30', 'BU1111'),
('S002', 'ORD02', '2021-05-15', 5, 'Net 60', 'PS2222'),
('S003', 'ORD03', '2020-08-20', 20, 'Net 30', 'MC2222'),
('S004', 'ORD04', '2019-11-11', 15, 'Net 30', 'DS4444');

SELECT * FROM roysched;

INSERT INTO roysched (title_id, lorange, hirange, royalty) VALUES
('BU1111', 0, 5000, 10),
('BU1111', 5001, 20000, 15),
('PS2222', 0, 10000, 12),
('MC2222', 0, 20000, 20),
('DS4444', 0, 30000, 25);

--2. Display tiles that End with 's'/'t'.

SELECT * FROM titles;

SELECT * FROM titles
WHERE title LIKE '%s' OR title LIKE '%t';

-- 3. Display books of type business, psychology & undecided.

SELECT * FROM titles 
WHERE type IN ('business','psychology','undecided');

-- 4. Display titles where the sales>5,000 & royality<20.

SELECT * FROM titles
WHERE ytd_sales>5000 AND royalty<20;

--5. Display titles in the ascending of sales for publisher 0736.

SELECT title FROM titles
WHERE pub_id=0736
ORDER BY ytd_sales;

--6. Display the difference between maximum & minimum royality of books published day publisher 0877.

SELECT MAX(royalty) - MIN(royalty) AS royalty_diff
FROM titles
WHERE pub_id=0877;

--7. Display author_id & no of books written by Author

SELECT * FROM titleauthor;

SELECT au_id AS author_id, COUNT(title_id) AS no_of_books
FROM titleauthor
GROUP BY au_id;

--8. Display how many authors are there for each title.

SELECT COUNT(au_id) AS no_of_authors, title_id
FROM titleauthor
GROUP BY title_id;

--9. Display average royality % for authors with order 1.

SELECT * FROM titleauthor;

SELECT AVG(royaltyper) AS avg_royalty_percentage FROM titleauthor
WHERE au_ord=1;

--10. Display titles in the order of price if sales are in the range 10k to 20k.

SELECT title,price,ytd_sales FROM titles
WHERE ytd_sales BETWEEN 10000 AND 20000
ORDER BY price;

-- 11. Display how many authors are in the city Menlo park.

SELECT COUNT(au_id) AS no_of_authors
FROM authors
WHERE city='Menlo Park';

--12. Display state and no of authors we have in the state in the order of state.

SELECT state,COUNT(au_id) AS no_of_authors
FROM authors
GROUP BY state
ORDER BY state;

--13. Display States in which we have more than 2 authors, with 1st name starting with 's'.

SELECT * FROM authors;

SELECT state FROM authors
WHERE au_fname LIKE 's%'
GROUP BY state
HAVING COUNT(au_id)>=2;

-- 14. Display title after replacing all spaces with (dots) and (hypens) with (stars).

SELECT 
    REPLACE(
        REPLACE(title,' ','.'),
        '-','*'
    ) AS modified_title
FROM titles;

--15. Display title by Removing all spaces.

SELECT REPLACE(title,' ','') AS modified_title
FROM titles;

--16. Display first word in the title.

SELECT LEFT(title, CHARINDEX(' ',title+' ')-1) AS first_word
FROM titles;

-- 17. Display month and no of books published.
SELECT * FROM titles;

SELECT 
    MONTH(pubdate) AS publish_month,
    COUNT(title_id) AS no_of_books
FROM titles
GROUP BY MONTH(pubdate)
ORDER BY publish_month;

--18. Display title publisher name for titles where the publisher is in USA.

SELECT * FROM publishers;

SELECT pub_name FROM publishers
WHERE country='USA';

--19. Display publisher name and average price of books.

SELECT * FROM titles;

SELECT p.pub_name,AVG(t.price) FROM publishers p
INNER JOIN titles t
ON p.pub_id = t.pub_id
GROUP BY p.pub_name;

--20. Display City of author and then no of books written by authors in the City.

SELECT a.city,COUNT(ta.title_id) AS no_of_books
FROM authors a 
INNER JOIN titleauthor ta
  ON a.au_id=ta.au_id
INNER JOIN titles t
 ON ta.title_id = t.title_id
GROUP BY a.city;

--21. Display auther name, title for all authors including the once without a title.


SELECT 
    a.au_fname + ' ' + a.au_lname AS author_name,
    t.title
FROM authors a
LEFT JOIN titleauthor ta
    ON a.au_id = ta.au_id
LEFT JOIN titles t
    ON ta.title_id = t.title_id;

--22. Display title publisher name and author name of the primary author.


SELECT t.tile,p.pub_name,a.au_fname+ ' '+a.au_lname AS author_name
FROM titles t
INNER JOIN publishers p
    ON t.pub_id = p.pub_id
INNER JOIN titleauthor ta
    ON t.title_id = ta.title_id
INNER JOIN authors a
    ON ta.au_id = a.au_id
WHERE ta.au_ord = 1;

--23. Display City of publisher and maximum price of all titles.

SELECT p.city,MAX(t.price) AS max_price
FROM publishers p
INNER JOIN titles t
 ON p.pub_id=t.pub_id
 GROUP BY p.city;

--24. Display titles written by any author in City (menlo park).
SELECT * FROM authors;
SELECT * FROM titles;
SELECT * FROM titleauthor;

SELECT DISTINCT t.title FROM titles t
INNER JOIN titleauthor ta
   ON t.title_id=ta.title_id
INNER JOIN authors a 
   ON ta.au_id = a.au_id
WHERE a.city = 'Menlo Park';

--26. Display titles not published in USA.

SELECT t.title FROM titles t
INNER JOIN publishers p
ON t.pub_id=p.pub_id
WHERE p.country <> 'USA';

--27. Display titles either published in USA (or) having price <5.

SELECT DISTINCT t.title
FROM titles t
INNER JOIN publishers p
ON t.pub_id = p.pub_id
WHERE p.country='USA'
OR t.price<5;

--29. Display publishers who published books by author who wrote more than 2 titles.

SELECT au_id
FROM titleauthor
GROUP BY au_id
HAVING COUNT(title_id)>2;

SELECT DISTINCT p.pub_name
FROM publishers p
INNER JOIN titles t
ON p.pub_id=t.pub_id
INNER JOIN titleauthor ta
ON t.title_id= ta.title_id
WHERE ta.au_id IN(
    SELECT au_id
    FROM titleauthor
    GROUP BY au_id
    HAVING COUNT(title_id)>2
);

--30. Delete rows from title author for author with first_name as dean.

DELETE FROM titleauthor
WHERE au_id IN(
    SELECT au_id
    FROM authors
    WHERE au_fname='Dean'
);

SELECT * FROM titleauthor;

--31. Update the price of the book BU1111 with the Price of book MC2222.

UPDATE titles
SET price =(
    SELECT price
    FROM titles
    WHERE title_id='MC2222'
)
WHERE title_id='BU1111';

--32. Display titles published in last 25 years.

SELECT title,pubdate
FROM titles
WHERE pubdate>= DATEADD(YEAR, -25, GETDATE());

--33. Display titles published by any publisher who published a title in 2021.

SELECT title, pubdate, pub_id
FROM titles
WHERE pub_id IN (
    SELECT DISTINCT pub_id
    FROM titles
    WHERE YEAR(pubdate) = 2021
);
