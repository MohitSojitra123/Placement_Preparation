CREATE TABLE Products (
    Product_id INT PRIMARY KEY,
    Product_Name VARCHAR(250) NOT NULL,
    Price DECIMAL(10,2) NOT NULL
);

INSERT INTO Products VALUES
(1, 'Smartphone', 35000),
(2, 'Laptop', 65000),
(3, 'Headphones', 5500),
(4, 'Television', 85000),
(5, 'Gaming Console', 32000);


-- Part A

-- 1
DECLARE Product_Cursor CURSOR FOR
    SELECT Product_id, Product_Name, Price FROM Products;

OPEN Product_Cursor;

DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

FETCH NEXT FROM Product_Cursor INTO @id, @name, @price;
WHILE @@FETCH_STATUS = 0
BEGIN
    PRINT CAST(@id AS VARCHAR) + ' - ' + @name + ' - ' + CAST(@price AS VARCHAR);
    FETCH NEXT FROM Product_Cursor INTO @id, @name, @price;
END

CLOSE Product_Cursor;
DEALLOCATE Product_Cursor;


-- 2
DECLARE Product_Cursor_Fetch CURSOR FOR
    SELECT Product_id, Product_Name FROM Products;

OPEN Product_Cursor_Fetch;

DECLARE @id INT, @name VARCHAR(250);

FETCH NEXT FROM Product_Cursor_Fetch INTO @id, @name;
WHILE @@FETCH_STATUS = 0
BEGIN
    PRINT CAST(@id AS VARCHAR) + '_' + @name;
    FETCH NEXT FROM Product_Cursor_Fetch INTO @id, @name;
END

CLOSE Product_Cursor_Fetch;
DEALLOCATE Product_Cursor_Fetch;


-- 3
DECLARE Price_Cursor CURSOR FOR
    SELECT Product_id, Product_Name, Price FROM Products WHERE Price > 30000;

OPEN Price_Cursor;

DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

FETCH NEXT FROM Price_Cursor INTO @id, @name, @price;
WHILE @@FETCH_STATUS = 0
BEGIN
    PRINT CAST(@id AS VARCHAR) + ' - ' + @name + ' - ' + CAST(@price AS VARCHAR);
    FETCH NEXT FROM Price_Cursor INTO @id, @name, @price;
END

CLOSE Price_Cursor;
DEALLOCATE Price_Cursor;


-- 4
DECLARE Product_CursorDelete CURSOR FOR
    SELECT Product_id FROM Products;

OPEN Product_CursorDelete;

DECLARE @id INT;

FETCH NEXT FROM Product_CursorDelete INTO @id;
WHILE @@FETCH_STATUS = 0
BEGIN
    DELETE FROM Products WHERE Product_id = @id;
    FETCH NEXT FROM Product_CursorDelete INTO @id;
END

CLOSE Product_CursorDelete;
DEALLOCATE Product_CursorDelete;


-- Part B

-- 1
DECLARE Product_CursorUpdate CURSOR FOR
    SELECT Product_id, Price FROM Products;

OPEN Product_CursorUpdate;

DECLARE @id INT, @price DECIMAL(10,2);

FETCH NEXT FROM Product_CursorUpdate INTO @id, @price;
WHILE @@FETCH_STATUS = 0
BEGIN
    UPDATE Products SET Price = @price * 1.10 WHERE Product_id = @id;
    FETCH NEXT FROM Product_CursorUpdate INTO @id, @price;
END

CLOSE Product_CursorUpdate;
DEALLOCATE Product_CursorUpdate;


-- 2
DECLARE Round_Cursor CURSOR FOR
    SELECT Product_id, Price FROM Products;

OPEN Round_Cursor;

DECLARE @id INT, @price DECIMAL(10,2);

FETCH NEXT FROM Round_Cursor INTO @id, @price;
WHILE @@FETCH_STATUS = 0
BEGIN
    UPDATE Products SET Price = ROUND(@price, 0) WHERE Product_id = @id;
    FETCH NEXT FROM Round_Cursor INTO @id, @price;
END

CLOSE Round_Cursor;
DEALLOCATE Round_Cursor;


-- Part C

-- 1
CREATE TABLE NewProducts (
    Product_id INT PRIMARY KEY,
    Product_Name VARCHAR(250),
    Price DECIMAL(10,2)
);

DECLARE Laptop_Cursor CURSOR FOR
    SELECT Product_id, Product_Name, Price FROM Products WHERE Product_Name = 'Laptop';

OPEN Laptop_Cursor;

DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

FETCH NEXT FROM Laptop_Cursor INTO @id, @name, @price;
WHILE @@FETCH_STATUS = 0
BEGIN
    INSERT INTO NewProducts VALUES (@id, @name, @price);
    FETCH NEXT FROM Laptop_Cursor INTO @id, @name, @price;
END

CLOSE Laptop_Cursor;
DEALLOCATE Laptop_Cursor;


-- 2
CREATE TABLE ArchivedProducts (
    Product_id INT PRIMARY KEY,
    Product_Name VARCHAR(250),
    Price DECIMAL(10,2)
);

DECLARE Archive_Cursor CURSOR FOR
    SELECT Product_id, Product_Name, Price FROM Products WHERE Price > 50000;

OPEN Archive_Cursor;

DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

FETCH NEXT FROM Archive_Cursor INTO @id, @name, @price;
WHILE @@FETCH_STATUS = 0
BEGIN
    INSERT INTO ArchivedProducts VALUES (@id, @name, @price);
    DELETE FROM Products WHERE Product_id = @id;
    FETCH NEXT FROM Archive_Cursor INTO @id, @name, @price;
END

CLOSE Archive_Cursor;
DEALLOCATE Archive_Cursor;


-- CREATE TABLE Products (
--     Product_id INT PRIMARY KEY,
--     Product_Name VARCHAR(250) NOT NULL,
--     Price DECIMAL(10,2) NOT NULL
-- );

-- INSERT INTO Products (Product_id, Product_Name, Price) VALUES
-- (1, 'Smartphone', 35000),
-- (2, 'Laptop', 65000),
-- (3, 'Headphones', 5500),
-- (4, 'Television', 85000),
-- (5, 'Gaming Console', 32000);

-- --A

-- --1

-- DECLARE Product_Cursor CURSOR FOR
-- SELECT Product_id, Product_Name, Price FROM Products;

-- DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

-- OPEN Product_Cursor
-- FETCH NEXT FROM Product_Cursor INTO @id, @name, @price

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     PRINT CAST(@id AS VARCHAR) + ' - ' + @name + ' - ' + CAST(@price AS VARCHAR)
--     FETCH NEXT FROM Product_Cursor INTO @id, @name, @price
-- END

-- CLOSE Product_Cursor
-- DEALLOCATE Product_Cursor

-- --2

-- DECLARE Product_Cursor_Fetch CURSOR FOR
-- SELECT Product_id, Product_Name FROM Products;

-- DECLARE @id INT, @name VARCHAR(250);

-- OPEN Product_Cursor_Fetch
-- FETCH NEXT FROM Product_Cursor_Fetch INTO @id, @name

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     PRINT CAST(@id AS VARCHAR) + '_' + @name
--     FETCH NEXT FROM Product_Cursor_Fetch INTO @id, @name
-- END

-- CLOSE Product_Cursor_Fetch
-- DEALLOCATE Product_Cursor_Fetch

-- --3

-- DECLARE HighPrice_Cursor CURSOR FOR
-- SELECT Product_id, Product_Name, Price FROM Products WHERE Price > 30000;

-- DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

-- OPEN HighPrice_Cursor
-- FETCH NEXT FROM HighPrice_Cursor INTO @id, @name, @price

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     PRINT 'Product: ' + @name + ' | Price: ' + CAST(@price AS VARCHAR)
--     FETCH NEXT FROM HighPrice_Cursor INTO @id, @name, @price
-- END

-- CLOSE HighPrice_Cursor
-- DEALLOCATE HighPrice_Cursor

-- --4

-- DECLARE Product_CursorDelete CURSOR FOR
-- SELECT Product_id FROM Products;

-- DECLARE @id INT;

-- OPEN Product_CursorDelete
-- FETCH NEXT FROM Product_CursorDelete INTO @id

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     DELETE FROM Products WHERE Product_id = @id
--     PRINT 'Deleted Product ID: ' + CAST(@id AS VARCHAR)
--     FETCH NEXT FROM Product_CursorDelete INTO @id
-- END

-- CLOSE Product_CursorDelete
-- DEALLOCATE Product_CursorDelete

-- --B

-- --1

-- DECLARE Product_CursorUpdate CURSOR FOR
-- SELECT Product_id, Price FROM Products;

-- DECLARE @id INT, @price DECIMAL(10,2);

-- OPEN Product_CursorUpdate
-- FETCH NEXT FROM Product_CursorUpdate INTO @id, @price

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     UPDATE Products
--     SET Price = @price * 1.10
--     WHERE Product_id = @id

--     PRINT 'Updated Price for Product ID: ' + CAST(@id AS VARCHAR)
--     FETCH NEXT FROM Product_CursorUpdate INTO @id, @price
-- END

-- CLOSE Product_CursorUpdate
-- DEALLOCATE Product_CursorUpdate

-- --2

-- DECLARE RoundPrice_Cursor CURSOR FOR
-- SELECT Product_id, Price FROM Products;

-- DECLARE @id INT, @price DECIMAL(10,2);

-- OPEN RoundPrice_Cursor
-- FETCH NEXT FROM RoundPrice_Cursor INTO @id, @price

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     UPDATE Products
--     SET Price = ROUND(@price, 0)
--     WHERE Product_id = @id

--     PRINT 'Rounded Price for Product ID: ' + CAST(@id AS VARCHAR)
--     FETCH NEXT FROM RoundPrice_Cursor INTO @id, @price
-- END

-- CLOSE RoundPrice_Cursor
-- DEALLOCATE RoundPrice_Cursor


-- --C

-- --1

-- -- Create NewProducts Table
-- CREATE TABLE NewProducts (
--     Product_id INT PRIMARY KEY,
--     Product_Name VARCHAR(250) NOT NULL,
--     Price DECIMAL(10,2) NOT NULL
-- );

-- DECLARE Laptop_Cursor CURSOR FOR
-- SELECT Product_id, Product_Name, Price FROM Products WHERE Product_Name = 'Laptop';

-- DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

-- OPEN Laptop_Cursor
-- FETCH NEXT FROM Laptop_Cursor INTO @id, @name, @price

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     INSERT INTO NewProducts VALUES (@id, @name, @price)
--     PRINT 'Inserted Laptop into NewProducts'
--     FETCH NEXT FROM Laptop_Cursor INTO @id, @name, @price
-- END

-- CLOSE Laptop_Cursor
-- DEALLOCATE Laptop_Cursor

-- --2

-- -- Create Archive Table
-- CREATE TABLE ArchivedProducts (
--     Product_id INT PRIMARY KEY,
--     Product_Name VARCHAR(250) NOT NULL,
--     Price DECIMAL(10,2) NOT NULL
-- );

-- DECLARE Archive_Cursor CURSOR FOR
-- SELECT Product_id, Product_Name, Price FROM Products WHERE Price > 50000;

-- DECLARE @id INT, @name VARCHAR(250), @price DECIMAL(10,2);

-- OPEN Archive_Cursor
-- FETCH NEXT FROM Archive_Cursor INTO @id, @name, @price

-- WHILE @@FETCH_STATUS = 0
-- BEGIN
--     -- Insert into Archive
--     INSERT INTO ArchivedProducts VALUES (@id, @name, @price)

--     -- Delete from Original
--     DELETE FROM Products WHERE Product_id = @id

--     PRINT 'Moved Product ID ' + CAST(@id AS VARCHAR) + ' to ArchivedProducts'

--     FETCH NEXT FROM Archive_Cursor INTO @id, @name, @price
-- END

-- CLOSE Archive_Cursor
-- DEALLOCATE Archive_Cursor