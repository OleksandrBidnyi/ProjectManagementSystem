-- Добавить поле (cost - стоимость) в таблицу Projects .

ALTER TABLE projects ADD COLUMN cost INT;

UPDATE projects SET cost = CASE
    WHEN id = 1 THEN 550000
    WHEN id = 2 THEN 130000
    WHEN id = 3 THEN 220000
    WHEN id = 4 THEN 600000
    WHEN id = 5 THEN 520000
    WHEN id = 6 THEN 480000
    WHEN id = 7 THEN 390000
    WHEN id = 8 THEN 700000
    WHEN id = 9 THEN 300000
    END