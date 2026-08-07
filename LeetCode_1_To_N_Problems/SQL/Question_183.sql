-- 183. Customers Who Never Order

select Customers.name as Customers from Customers where id not in (select customerid from Orders)

SELECT c.name AS Customers
FROM Customers c
LEFT JOIN Orders o
ON c.id = o.customerId
WHERE o.id IS NULL;