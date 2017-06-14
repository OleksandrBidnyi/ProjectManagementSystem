-- Добавить разаработчикам поле (salary - зарплата). 

ALTER TABLE developers ADD COLUMN salary INT;

UPDATE developers SET salary = CASE
    WHEN id = 1 THEN 5255
    WHEN id = 2 THEN 4200
    WHEN id = 3 THEN 3550
    WHEN id = 4 THEN 3320
    WHEN id = 5 THEN 5625
    WHEN id = 6 THEN 6500
    WHEN id = 7 THEN 4900
    WHEN id = 8 THEN 3720
    WHEN id = 9 THEN 4555
    END ;