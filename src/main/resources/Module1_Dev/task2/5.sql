-- Найти клиента (customer), которая приносит меньше всего прибыли компании (company) для каждой из компаний .

CREATE TEMPORARY TABLE profit_from_customer
  SELECT
    companies.name AS company_name,
    customers.name AS customer_name,
    sum(projects.cost) AS profit
  FROM companies INNER JOIN projects ON companies.id = projects.company_id
  INNER JOIN customers ON projects.customer_id = customers.id
  GROUP BY company_name, customer_name;

CREATE TEMPORARY TABLE min_profit
SELECT company_name, min(profit) AS profit
FROM profit_from_customer
GROUP BY company_name;

SELECT p.company_name, p.customer_name, p.profit FROM profit_from_customer p
  INNER JOIN
  min_profit ON p.profit = min_profit.profit
                 AND p.company_name = min_profit.company_name
