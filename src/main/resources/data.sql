INSERT INTO user (id, full_name, username) VALUES (1, 'Carey Baccus', 'baccuss1');
INSERT INTO user (id, full_name, username) VALUES (2, 'Josephina Yeates', 'josephinaa');
INSERT INTO user (id, full_name, username) VALUES (3, 'Leanna Ridge', 'leana23');

INSERT INTO task (id, title, description, deadline, manager_id) VALUES (1, 'task 1', 'simple task 1', '2020-10-20 11:08:04', 1);
INSERT INTO task (id, title, description, deadline, manager_id) VALUES (2, 'task 2', 'simple task 2', '2020-11-18 17:31:51', 1);

INSERT INTO user_task (user_id, task_id) VALUES (1, 1);
INSERT INTO user_task (user_id, task_id) VALUES (2, 1);
INSERT INTO user_task (user_id, task_id) VALUES (2, 2);
INSERT INTO user_task (user_id, task_id) VALUES (3, 1);
INSERT INTO user_task (user_id, task_id) VALUES (3, 2);
