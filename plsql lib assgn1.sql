CREATE DATABASE IF NOT EXISTS LibraryDB;
USE LibraryDB;

INSERT INTO Book (title, price, author, publication_house, category, book_count, status)
VALUES('The Great Indian War', 480.00, 'Major Sandeep', 'Warner Bros', 'WAR', 5, 'IN STOCK'),
('Wings of Fire', 300.00, 'Dr. A.P.J. Abdul Kalam', 'Mcgraw Hill', 'Fiction', 12, 'IN STOCK'),
('Comedy Express', 199.00, 'Kapil Sharma', 'DreamFolks', 'COMEDY', 7, 'IN STOCK'),
('Cricket Chronicles', 350.00, 'Sunil Gavaskar', 'DreamFolks', 'SPORTS', 10, 'OUT OF STOCK'),
('My Experiments with Truth', 250.00, 'Mahatma Gandhi', 'Mcgraw Hill', 'Fiction', 6, 'IN STOCK'),
('Laugh India Laugh', 220.00, 'Johnny Lever', 'DreamFolks', 'COMEDY', 8, 'IN STOCK'),
('Battle of Kargil', 550.00, 'Captain Vikram Batra', 'Warner Bros', 'WAR', 4, 'OUT OF STOCK'),
('Hockey Heroics', 310.00, 'Dhanraj Pillay', 'Warner Bros', 'SPORTS', 9, 'IN STOCK');

select * from book;
-- Fetch all Books that are "IN STOCK" and price is less than given value. 
delimiter $$
create procedure book_in_stock(in max_price decimal(10,2))
begin
select * from book where status ='IN STOCK' and price < max_price;
end;
drop procedure book_in_stock;
call book_in_stock(200);
-- Delete books that are from given publication_house. do not activate safe mode. 
set sql_safe_updates=0;

delimiter $$
create procedure del_pub_house(in pub_house varchar(255))
begin
delete from book where publication_house=pub_house;
end;
drop procedure del_pub_house;
call del_pub_house('Warner Bros');

delimiter $$
create procedure Update_Book_Price_By_Category( in category_name varchar(50),in percent_increase decimal(5,2))
BEGIN
	update book set price = price +(price * percent_increase/100)
    where category=category_name;
END;

call Update_Book_Price_By_Category('COMEDY',10);
DELIMITER $$

CREATE PROCEDURE del_pub_house(IN pub_house VARCHAR(255))
BEGIN
    DELETE FROM book
    WHERE id IN (
        SELECT id FROM (
            SELECT id FROM book WHERE publication_house = pub_house
        ) AS temp
    );
END $$
drop procedure del_pub_house;
DELIMITER ;
DELIMITER $$

CREATE PROCEDURE Update_Book_Price_By_Category(
    IN category_name VARCHAR(50),
    IN percent_increase DECIMAL(5,2)
)
BEGIN
    UPDATE book
    SET price = price + (price * percent_increase / 100)
    WHERE id IN (
        SELECT id FROM (
            SELECT id FROM book WHERE category = category_name
        ) AS temp
    );
END $$
drop procedure Update_Book_Price_By_Category ;


