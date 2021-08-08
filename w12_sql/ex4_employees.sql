-- ===========================
-- Ex4. Employees (SOLUTION)
-- ===========================

-- !NOTE: before working on your solution, check/run the separate INIT script!

pragma foreign_keys = on; --make sure FK checks are on

---------------------------------------------------------
-- TODO: YOUR SOLUTION BELOW (after you ran init script)
---------------------------------------------------------
--DONE IN BEAVER
-- select by lenght
select * from employees e2
where LENGTH(FIRST_NAME) >=8;

--Write a query that displays the first name and the length of the first name for all employees whose name starts with letters 'A', 'J' or 'M'.
--Give each column an appropriate label. Sort the results by the employees' first names.

SELECT FIRST_NAME , LENGTH(FIRST_NAME) LENGHT FROM employees e
WHERE FIRST_NAME LIKE 'A%'
OR FIRST_NAME LIKE 'J%'
OR FIRST_NAME LIKE 'M%'
GROUP BY FIRST_NAME;

--Write a query to display the name (first_name, last_name), salary and TAX (15% of salary) of all employees.

SELECT FIRST_NAME , LAST_NAME, SALARY , SALARY * 0.15 AS 'TAX 'FROM employees  e;

--Write a query to list the department ID and name of all the departments where no employee is working.

SELECT DISTINCT d.ID, d.NAME FROM departments d
WHERE d.ID not in (SELECT department_id from employees e2);

--Write a query to display the name (first_name, last_name) and salary of
-- all the employees who earns more than of Mr. Bell.

SELECT first_name , last_name , salary from employees e2
WHERE SALARY > (SELECT SALARY FROM employees e3 WHERE LAST_NAME LIKE 'BELL')
ORDER BY SALARY;

--Write a query to display the employee ID, first name, last name, salary of all employees whose salary
--is above average for their departments.
SELECT ID,FIRST_NAME,LAST_NAME, SALARY FROM employees
AS X
WHERE SALARY>(SELECT AVG(SALARY) FROM employees e3 WHERE department_id = X.DEPARTMENT_ID);

--Write a query to display the job history that were done
--by any employee who is currently earning more than 10000.

SELECT JH. * FROM job_history jh
JOIN  employees e
ON (jh.EMPLOYEE_ID = e.ID)
WHERE SALARY>10000;

--Write a query to display job name, employee name,
--and the difference between the salary of the employee and minimum salary for the job.

SELECT J.NAME, E.FIRST_NAME , E.LAST_NAME , SALARY - J.MIN_SALARY
FROM employees e , jobs j
WHERE J.ID = E.JOB_ID
ORDER BY J.NAME;

--Write a query to display the job name and average salary of employees.


SELECT J.NAME, AVG(salary)
	FROM employees E
		 JOIN jobs J ON (E.JOB_ID = J.ID)
			GROUP BY J.NAME;

--Write a query to display the department name, manager name, and city.


SELECT  D.NAME , E.FIRST_NAME, E.LAST_NAME,L.CITY
FROM departments d
JOIN employees E
ON (D.MANAGER_ID = E.ID)
JOIN locations L ON L.ID = D.LOCATION_ID;

--Write a query to display the department ID and name and first name of manager.

SELECT DISTINCT d.id, d.name, d.manager_id, e.first_name
FROM departments d
JOIN employees e
ON (d.manager_id = e.ID);

--Write a query to find the employee ID, job name,
-- number of days between end date and start date for all jobs in department 110 from job history.

SELECT JH.EMPLOYEE_ID, NAME, end_date-start_date DAYS_WORKED FROM job_history JH
NATURAL JOIN JOBS
WHERE DEPARTMENT_ID=110;

--Write a query to update the portion of the phone_number in the employees table,
-- within the phone number the substring '590' will be replaced by '111'.

UPDATE employees
SET phone_number = REPLACE(phone_number, '590', '111')
WHERE phone_number LIKE '%590%';

--Write a query to append '@wantsome.ro' to email field (but avoid appending it twice).
UPDATE employees
SET email = email || '@wantsome.ro'
WHERE EMAIL != '@wantsome.ro';

SELECT * FROM employees e;

--Write a SQL statement to change salary of employee to 8000 with ID is 105, if the existing salary is less than 5000
UPDATE employees SET SALARY = 8000
WHERE id = 105 AND salary < 5000;

--Write a SQL statement to change job ID of employee with ID = 118 to SH_CLERK if the employee belongs
--to the department with ID 30 and the existing job ID does not start with SH.

UPDATE employees SET JOB_ID= 'SH_CLERK'
WHERE id=118
AND department_id=30
AND NOT JOB_ID LIKE 'SH%';

--Write a SQL statement to increase the salary of employees under the departments 40, 90 and 110 according to the new company rules: salary will be increased by a factor of 2 for the department 40, 3 for department 90 and 10 for
--the department 110 and the rest of the departments will remain the same.

UPDATE employees SET salary= CASE department_id
 WHEN 40 THEN salary+(salary*0.25)
 WHEN 90 THEN salary+(salary*0.15)
 WHEN 110 THEN salary+(salary*0.10)
 ELSE SALARY
 END;
