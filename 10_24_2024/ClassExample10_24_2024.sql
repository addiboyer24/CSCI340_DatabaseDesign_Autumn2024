CREATE TABLE EMPLOYEE
(
    Ssn SSN_TYPE /*NOT NULL*/ CONSTRAINT PK_EMPLOYEE_SSN PRIMARY KEY,
    FName VARCHAR(256) NOT NULL CONSTRAINT DF_EMPLOYEE_FNAME DEFAULT 'JOHN',
    MInit CHAR(1) NULL,
    LName VARCHAR(256) NULL,
    [Address] VARCHAR(256) NULL,
    Salary DECIMAL(8,2) NULL CONSTRAINT CK_EMPLOYEE_SALARY CHECK (Salary > 0),
    BDate DATE NULL,
    Sex CHAR(1) NOT NULL CONSTRAINT CK_EMPLOYEE_SEX CHECK (Sex IN ('M', 'F'))
);

CREATE TYPE NAME_TYPE FROM VARCHAR(256);

CREATE TABLE DEPENDENT
(
    [Name] NAME_TYPE NOT NULL,
    Sex CHAR NOT NULL CONSTRAINT CK_DEPENDENT_SEX CHECK (Sex IN ('M', 'F')),
    BirthDate DATE NULL,
    Relationship VARCHAR(50),
    Ssn SSN_TYPE NOT NULL
);

ALTER TABLE DEPENDENT
ADD CONSTRAINT PK_DEPENDENT_NAME_SSN
PRIMARY KEY(Name, Ssn);

ALTER TABLE DEPENDENT
ADD CONSTRAINT FK_DEPENDENT_SSN
FOREIGN KEY(Ssn) REFERENCES EMPLOYEE(Ssn) ON DELETE CASCADE;


INSERT INTO EMPLOYEE VALUES ('123456789', 'JOHN', 'W', 'SMITH', '123 EASY STREET MADISON, WI', 100000, '1980-04-01', 'M');
INSERT INTO EMPLOYEE (Ssn, FName, Sex) VALUES ('987654321', 'JANE', 'F');

-- Get the first name of all females at the company.
SELECT FName
FROM EMPLOYEE
WHERE Sex = 'F';

INSERT INTO DEPENDENT VALUES ('JOHN JUNIOR', 'M', '2021-04-01', 'SON', '123456789');

-- Get the name of all dependents of employees with a birthday on april 1st 1980.
SELECT D.Name
FROM DEPENDENT AS D, EMPLOYEE AS E
WHERE E.BDate = '1980-04-01' -- Selection condition
AND E.Ssn = D.Ssn; -- Join condition

/* Updates tuples within a single relation */
UPDATE EMPLOYEE
SET LName = 'SMITH', Salary = 80000
WHERE Ssn = '987654321';

/* Selects all attributes i.e. * */
SELECT *
FROM EMPLOYEE;


INSERT INTO EMPLOYEE (Ssn, FName, Sex) VALUES ('111111111', 'JACK', 'M');
INSERT INTO EMPLOYEE (Ssn, FName, Sex) VALUES ('222222222', 'JANE', 'F');
-- Get me a list of distinct employees names that share a first name with another employee (not themselves).
SELECT ALL E1.FName
FROM EMPLOYEE E1, EMPLOYEE E2
WHERE E1.Fname = E2.Fname
AND E1.Ssn <> E2.Ssn;