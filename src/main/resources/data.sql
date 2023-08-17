INSERT INTO tb_author(id, name, birth_day)
VALUES (1, 'Stephen King', '2018-07-07');
INSERT INTO tb_author(id, name, birth_day)
VALUES (2, 'J.K. Rolling', '2018-07-07');
INSERT INTO tb_author(id, name, birth_day)
VALUES (3, 'Georgie R.R. Martin', '2018-07-07');
INSERT INTO tb_author(id, name, birth_day)
VALUES (4, 'Rick Riordan', '2018-07-07');
INSERT INTO tb_author(id, name, birth_day)
VALUES (5, 'James Dashner', '2018-07-07');

INSERT INTO tb_user(id, first_name, last_name, email, password, role)
VALUES (1, 'Guilherme', 'Tarifa', 'Vieira@gmail.gloob', '1234554', 'MANAGER');

INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (1, 'Salem', 1, '23124132.32123', 'TO_READ');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (2, 'Harry Potter e a Câmara Secreta', 2, '23111111.31111', 'READING');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (3, 'A Dança dos Dragões', 3, '222224132.322222', 'READ');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (4, 'Filho de Netuno', 4, '333333333.333333', 'READ');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (5, 'James Dashner', 5, '2344443211.32444', 'READ');