-- Найти самый дорогой проект (исходя из ЗП разработчиков). 

SELECT projects.name, sum(developers.salary)
from projects INNER JOIN developers_projects INNER JOIN developers
WHERE projects.id = developers_projects.project_id AND developers_projects.developer_id = developers.id
GROUP BY project_id
ORDER BY sum(developers.salary) DESC
LIMIT 1