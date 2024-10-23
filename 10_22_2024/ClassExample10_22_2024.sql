-- Java typename varname = literal value;
DECLARE @VarName INTEGER = 1;
SET @VarName = 2;
SELECT @VarName;

-- i (precision) total number of digits, j (scale) total number of digits after the decimal
-- i = 1, j = 1 What's the largest number .9
DECLARE @FloatValue DECIMAL(1,1) = .9;
SELECT @FloatValue;

DECLARE @StringValue CHARACTER(9) = '94345345'; -- Fixed Length Strings (Padded Blanks)
SELECT @StringValue;

DECLARE @VariableStringValue VARCHAR(9) = '94345345';
SELECT @VariableStringValue;

DECLARE @Date DATE = '2024-10-22';
DECLARE @Today DATE = GETDATE();
SELECT @Date, @Today;

DECLARE @Time TIME = '1:1:1';
SELECT @Time;

DECLARE @DateAndTime DATETIME = GETDATE();
SELECT @DateAndTime;

DECLARE @TrueOrFalseOrNull BIT = 0;
SELECT @TrueOrFalseOrNull;

-- Creating our own datatypes (Domain)
-- Data type, Logical Definition, Format, Unit of Measurement.
CREATE TYPE SSN_TYPE FROM CHARACTER(9);
-- How do we define the schema we're creating an object within?
-- Explicitly or Implicitly

DECLARE @Ssn SSN_TYPE = '94345345'
SELECT @Ssn;

CREATE TABLE EMPLOYEE
(
    -- ATTRIBUTE NAME ATTRIBUTE DATATYPE CONSTRAINT(S)
    -- How do we name constraints?
    Ssn SSN_TYPE CONSTRAINT PK_EMPLOYEE_SSN PRIMARY KEY, -- What constraint would we violate allowing null values for this attribute ssn? Entity Integrity Constraint*
    Fname VARCHAR(666) NOT NULL CONSTRAINT DF_EMPLOYEE_FNAME DEFAULT 'JOHN',
    Salary DECIMAL(8, 2) NOT NULL CONSTRAINT CK_EMPLOYEE_SALARY CHECK (Salary > 0)
);

-- When the primary key is simple we can define as part of the create table statement*
-- otherwise we have to do so afterwards.

-- How do we add tuples to the EMPLOYEE relation?
INSERT INTO EMPLOYEE VALUES ('123456789', 'JANE', 136000.14); -- Not explicitly defining attribute list

INSERT INTO EMPLOYEE (Ssn, Salary) VALUES ('987654321', 80000); -- Explicitly definining attribute list (we let the default constraints do their work)

-- How do we retrieve data from the database. (DCMS)
-- Which of our employees (their first name and ssn) makes 6 figures?
-- SELECT ATTRIBUTE LIST
-- FROM TABLE NAME LIST
-- WHERE SOME PREDICATE THAT EVALUATES TO TRUE OR FALSE.

SELECT E.Fname AS FN, E.Ssn AS S
FROM EMPLOYEE AS E
WHERE E.Salary >= 100000;

SELECT Ssn, Fname, Salary
FROM EMPLOYEE;

SELECT E.*
FROM EMPLOYEE E;