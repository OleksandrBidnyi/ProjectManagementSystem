-- Вычислить общую ЗП всех Java разработчиков. 

-- first way
select sum(developers.salary) from ((developers
inner join developers_skills on developers.id = developers_skills.developer_id)
inner join skills on developers_skills.skill_id = skills.id)
where skills.skill like 'Java';

-- second way
SELECT sum(developers.salary) FROM developers
INNER JOIN developers_skills INNER JOIN skills
WHERE developers.id = developers_skills.developer_id AND developers_skills.skill_id = skills.id
      AND skills.skill LIKE 'Java'
      

