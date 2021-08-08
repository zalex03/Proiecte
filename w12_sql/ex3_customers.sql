-- ========================
-- Ex3. Customers
-- ========================

pragma foreign_keys = on; --make sure FK checks are on

----------------------------------------------
-- Init script - tables + sample data
-----------------------------------------------

-- Drop existing tables? (run this manually if needed: select whole text of the row, without the '--' prefix, then: Alt+X)
-- drop table orders; drop table customers;

create table customers (
  customer_id      int         not null primary key,
  last_name        varchar(50) not null,
  first_name       varchar(50) not null,
  favorite_website varchar(50));

create table orders (
  order_id    int not null primary key,
  customer_id int references customers(customer_id),
  order_date  datetime);

insert into customers (customer_id, last_name, first_name, favorite_website) values (4000, 'Jackson', 'Joe', 'techonthenet.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (5000, 'Smith', 'Jane', 'digminecraft.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (6000, 'Ferguson', 'Samantha', 'bigactivities.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (7000, 'Reynolds', 'Allen', 'checkyourmath.com');
insert into customers (customer_id, last_name, first_name, favorite_website) values (8000, 'Anderson', 'Paige', null);
insert into customers (customer_id, last_name, first_name, favorite_website) values (9000, 'Johnson', 'Derek', 'techonthenet.com');

insert into orders (order_id, customer_id, order_date) values (1,7000,datetime('2018-04-18'));
insert into orders (order_id, customer_id, order_date) values (2,5000,datetime('2018-04-18'));
insert into orders (order_id, customer_id, order_date) values (3,8000,datetime('2018-04-19'));
insert into orders (order_id, customer_id, order_date) values (4,4000,datetime('2018-04-20'));
insert into orders (order_id, customer_id, order_date) values (5,null,datetime('2018-05-01'));
insert into orders (order_id, customer_id, order_date) values (6,4000,datetime('2018-05-02'));

select * from
	(select count() customers from customers),
	(select count() orders from orders);

----------------------------------------------
-- TODO: YOUR SOLUTION BELOW
----------------------------------------------

--just to view the table

SELECT * FROM customers c2;
SELECT * FROM orders o2;

--Select the customer_id and last_name from the customers table
--and select the order_date from the orders table where there is a matching customer_id value in both the customers and orders tables.
--Order the results by customer_id in descending order.

SELECT c.customer_id , c.last_name , o.order_date
FROM customers c , orders o
WHERE c.customer_id = o.customer_id
ORDER by c.customer_id DESC;

--Select the first_name and last_name of customers who initiated
-- an order in the last month (the last one with data present in table).

SELECT c.first_name , c.last_name, o.order_date
from customers c, orders o
WHERE c.customer_id = o.customer_id AND o.order_date >= '2018-05-00';

--Select the distinct favorite_websites of customers who made orders in April 2018.

SELECT DISTINCT c.favorite_website, o.order_date ,COUNT(c.customer_id) numberOfOrders
from customers c , orders o
WHERE c.customer_id = o.customer_id AND o.order_date BETWEEN  '2018-04-00' AND '2018-05-00'
GROUP BY o.order_date;

SELECT COUNT(c.customer_id) numberOfOrders
from customers c , orders o
WHERE c.customer_id = o.customer_id AND o.order_date BETWEEN  '2018-04-00' AND '2018-05-00'

--Select the customer_id and last_name from the customers table where there is a record in the orders table for that customer id.
--Order the results in ascending order by last_name and then descending order by customer_id.

SELECT c.customer_id , c.last_name
from customers c, orders o
where c.customer_id = o.customer_id
ORDER BY last_name ASC , c.customer_id DESC;




