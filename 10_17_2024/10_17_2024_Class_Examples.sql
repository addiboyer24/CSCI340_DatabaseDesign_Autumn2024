-- CREATE SCHEMA TEST AUTHORIZATION csci340admin
-- CREATE TABLE CSCI340.TEST
-- DEFAULT SCHEMA dbo (Database Owner)
-- R(A1, A2, ..., Am)

CREATE TABLE TEST
(
    -- ATTRUBUTE NAME ATTRIBUTE DATA TYPE ATTRIBUTE CONSTRAINT(S)
    TestId INT NOT NULL
);

DROP TABLE dbo.TEST;

-- INTEGER VALUES TINYINT, SMALLINT, INT, BIGINT, etc...
-- Floating Point Numbers FLOAT, REAL, DOUBLE, DECIMAL
-- DECIMAL(i,j) i - Precision (total number of digits), j - Scale (total number of digits after the decimal)
-- Characters
-- DECLARE @Test INT = 1;
-- DECLARE @Test DECIMAL(2, 1) = 9.9;
-- DECLARE @Test CHAR = 'C';
-- DECLARE @Test CHARACTER(4) = 'CH' -- WHAT HAPPENS HERE? (Fixed Length Strings) - Padded with Whitespace Characters (generally ignored during string comparisons)
-- DECLARE @Test VARCHAR(3) = 'CH'; -- WHAT HAPPENS HERE? (Variable Length Strings) - Not Padded with Whitespace Characters
-- DECLARE @Test BIT = 1;
-- DECLARE @Test DATE = '2024-10-17'; -- 'YYYY-MM-DD';
-- DECLARE @Test TIME = '01:01:01' - 'HH:SS:MM';
-- DECLARE @Test DATETIME = GETDATE();
-- SELECT @Test;

-- SELECT * FROM dbo.TEST;

-- Base Relation (Table) vs. Virtual Relation (View)