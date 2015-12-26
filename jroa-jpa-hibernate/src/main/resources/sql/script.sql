--mysql
create database jpademo DEFAULT CHARACTER SET latin1;

use jpademo;

CREATE TABLE EMPLOYEE (
ID INTEGER NOT NULL, 
NAME VARCHAR(255), 
SALARY BIGINT, 
NUMBER INTEGER, 
constraint employee_id PRIMARY KEY (ID)
);

