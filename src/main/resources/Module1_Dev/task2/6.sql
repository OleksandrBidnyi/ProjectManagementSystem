-- Вычислить, среднюю ЗП программистов в проекте, который приносит наименьшую прибыль.

SELECT projects.name, projects.cost, avg(salary) FROM developers
INNER JOIN developers_projects ON developers.id = developers_projects.developer_id
INNER JOIN projects ON developers_projects.project_id = projects.id
WHERE projects.cost = (SELECT min(cost) FROM projects);