INSERT INTO companies (name) VALUES
  ('Amazon'),
  ('Oracle'),
  ('Yandex');

INSERT INTO customers (name) VALUES
  ('LG'),
  ('MSI'),
  ('Samsung');

INSERT INTO skills (skill) VALUES
  ('C++'),
  ('Java'),
  ('mySQL'),
  ('C'),
  ('PHP');  

INSERT INTO developers (name, company_id) VALUES
  ('Nikolay', 1),
  ('Natali', 1),
  ('Sasha', 1),
  ('Oleg', 2),
  ('Svetlana', 2),
  ('Aleks', 2),
  ('Vladimir', 3),
  ('Egor', 3),
  ('Masha', 3);

INSERT INTO developers_skills VALUES
  (1, 1),
  (1, 3),
  (1, 2),
  (2, 2),
  (2, 5),
  (3, 5),
  (4, 4),
  (4, 1),
  (5, 3),
  (5, 4),
  (6, 2),
  (6, 1),
  (7, 2),
  (7, 3),
  (7, 5),
  (8, 5),
  (9, 4),
  (9, 3);

INSERT INTO projects VALUES
  (1, 'IOS', 1, 1),
  (2, '3D game', 1, 2),
  (3, 'Search System', 1, 3),
  (4, 'Image editor', 2, 1),
  (5, 'Voice translater', 2, 2),
  (6, 'File manager', 2, 3),
  (7, 'Video editor', 3, 1),
  (8, 'Messenger', 3, 2),
  (9, 'Mobile Browser', 3, 2);

INSERT INTO developers_projects VALUES
  (1,1),
  (1,2),
  (2,2),
  (2,3),
  (3,1),
  (3,2),
  (4,4),
  (4,5),
  (4,6),
  (5,6),
  (5,5),
  (6,4),
  (6,5),
  (7,7),
  (7,9),
  (8,8),
  (8,7),
  (9,8),
  (1,9);
