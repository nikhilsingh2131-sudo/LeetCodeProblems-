# Write your MySQL query statement below
SELECT w1.id 
FROM Weather w1 
JOIN Weather w2
ON DATEDIFF(w1.recordDate , W2.recordDate)=1
AND w1.temperature > w2.temperature 
