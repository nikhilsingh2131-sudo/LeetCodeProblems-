# Write your MySQL query statement below
select p.product_name ,
SUM(o.unit) AS unit
from Products p
join Orders o
on p.product_id =o.product_id
WHERE o.order_date >= '2020-02-01'
AND o.order_date < '2020-03-01'
group by  p.product_id , p.product_name   
having sum(o.unit)>=100  ;