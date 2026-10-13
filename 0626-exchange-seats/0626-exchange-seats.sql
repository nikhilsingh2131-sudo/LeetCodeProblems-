# Write your MySQL query statement below
select 
case 
when id= (SELECT MAX(id) FROM Seat) and id%2=1 then id
when id%2=1 then id+1 else id-1 end as id,
student
from Seat
order by id