
---------------------------------------------------------------------------------------

create table temp1(
    id int,
    name varchar(20)
)

insert into temp1 values (101,'mohit'),(NULL,'mohit'),(102,NULL),(103,'mohit'),(104,NULL)

select * from temp1

select count(*) from temp1
select count(id) from temp1
select count(name) from temp1
select avg(id) from temp1
select sum(id) / count(*) from temp1

---------------------------------------------------------------------------------------



