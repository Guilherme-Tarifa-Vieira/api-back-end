CREATE TABLE tb_user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255)          NOT NULL,
    last_name  VARCHAR(255)          NOT NULL,
    email      VARCHAR(120)          NOT NULL,
    password   VARCHAR(120)          NOT NULL,
    role       VARCHAR(55)           NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (ID)

);

CREATE TABLE tb_author
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    name      VARCHAR(155)          NOT NULL,
    birth_day DATE                  NULL,
    CONSTRAINT pk_author PRIMARY KEY (ID)
);

CREATE TABLE tb_book
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    title  VARCHAR(155)          NOT NULL,
    isbn   VARCHAR(55)           NOT NULL,
    status VARCHAR(30)           NULL,
    CONSTRAINT pk_book PRIMARY KEY (ID)
);

CREATE TABLE tb_book_user_favorites
(
    user_id BIGINT NULL,
    book_id BIGINT NULL
);

ALTER TABLE tb_book_user_favorites
    ADD CONSTRAINT fk_book_on_user FOREIGN KEY (user_id) REFERENCES tb_user (id);

ALTER TABLE tb_book_user_favorites
    ADD CONSTRAINT fk_book_on_book FOREIGN KEY (book_id) REFERENCES tb_book (id);

ALTER TABLE tb_book
    ADD COLUMN author_id BIGINT NULL;

ALTER TABLE tb_book
    ADD CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES tb_author (id);



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
VALUES (1, 'Salem', 1, '23124132.32123', 'READING');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (2, 'Harry Potter e a Câmara Secreta', 2, '23111111.31111', 'TO_READ');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (3, 'A Dança dos Dragões', 3, '222224132.322222', 'READ');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (4, 'Filho de Netuno', 4, '333333333.333333', 'READ');
INSERT INTO tb_book(id, title, author_id, isbn, status)
VALUES (5, 'Maze Runner', 5, '2344443211.32444', 'TO_READ');