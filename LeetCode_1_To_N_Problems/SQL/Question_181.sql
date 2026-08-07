-- 181. Employees Earning More Than Their Managers


select name as Employee from employee e1 where salary > (select salary from employee e2 where e1.managerId = e2.id ) 