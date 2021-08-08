-- ========================
-- Ex2. Suppliers
-- ========================

pragma foreign_keys = on; --make sure FK checks are on

----------------------------------------------
-- Init script - tables + sample data
-----------------------------------------------

-- Drop existing tables? (run this manually if needed: select whole text of the row, without the '--' prefix, then: Alt+X)
-- drop table suppliers;

create table suppliers (
  supplier_id int not null primary key,
  supplier_name varchar(50) not null,
  city varchar(50), 
  state varchar(25));

insert into suppliers (supplier_id, supplier_name, city, state) values (100, 'Microsoft', 'Redmond', 'Washington');
insert into suppliers (supplier_id, supplier_name, city, state) values (200, 'Google', 'Mountain View', 'California');
insert into suppliers (supplier_id, supplier_name, city, state) values (300, 'Oracle', 'Redwood City', 'California');
insert into suppliers (supplier_id, supplier_name, city, state) values (400, 'Kimberly-Clark', 'Irving', 'Texas');
insert into suppliers (supplier_id, supplier_name, city, state) values (500, 'Tyson Foods', 'Springdale', 'Arkansas');
insert into suppliers (supplier_id, supplier_name, city, state) values (600, 'SC Johnson', 'Racine', 'Wisconsin');
insert into suppliers (supplier_id, supplier_name, city, state) values (700, 'Dole Food Company', 'Westlake Village', 'California');
insert into suppliers (supplier_id, supplier_name, city, state) values (800, 'Flowers Foods', 'Thomasville', 'Georgia');
insert into suppliers (supplier_id, supplier_name, city, state) values (900, 'Electronic Arts', 'Redwood City', 'California');

select count() suppliers_count from suppliers;

----------------------------------------------
-- TODO: YOUR SOLUTION BELOW
----------------------------------------------

--just to check if all suppliers were added
SELECT * FROM suppliers s2;


--Select the names of cities that reside in the state of California, without any duplicates, ordering the results in descending order.
SELECT DISTINCT city from suppliers s2
WHERE state = 'California'
ORDER BY city DESC
;

--Select all records and order them in ascending order after state and city.

SELECT * FROM suppliers s2
ORDER BY state,city;

--Select the count all suppliers (from all states).

select count() suppliers  from suppliers;

--Return the list of states and the count of suppliers per each state; list should be ordered by state name.
SELECT state , count() count_suppliers from suppliers
GROUP BY state;


