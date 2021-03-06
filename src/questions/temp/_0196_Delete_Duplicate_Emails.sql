--Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
--
--+----+------------------+
--| Id | Email            |
--+----+------------------+
--| 1  | john@example.com |
--| 2  | bob@example.com  |
--| 3  | john@example.com |
--+----+------------------+
--Id is the primary key column for this table.
--For example, after running your query, the above Person table should have the following rows:
--
--+----+------------------+
--| Id | Email            |
--+----+------------------+
--| 1  | john@example.com |
--| 2  | bob@example.com  |
--+----+------------------+
--Note:
--
--Your output is the whole Person table after executing your sql. Use delete statement.




# Write your MySQL query statement below
-- Solution1
DELETE FROM PERSON WHERE ID NOT IN (SELECT ID FROM (SELECT MIN(ID) ID FROM PERSON GROUP BY EMAIL) AS P);

-- Solution2
DELETE P1 FROM PERSON P1 INNER JOIN PERSON P2 WHERE P1.EMAIL = P2.EMAIL AND P1.ID > P2.ID;