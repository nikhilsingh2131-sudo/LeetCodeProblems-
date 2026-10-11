
SELECT
    ROUND(
        SUM(IF(min_order_date = min_pref, 1, 0)) * 100.0
        / COUNT(min_order_date),
        2
    ) AS immediate_percentage
FROM (
    SELECT
        delivery_id,
        customer_id,
        order_date AS min_order_date,
        customer_pref_delivery_date AS min_pref
    FROM Delivery
    WHERE (customer_id, order_date) IN (
        SELECT customer_id, MIN(order_date)
        FROM Delivery
        GROUP BY customer_id
    )
) AS new_table;
