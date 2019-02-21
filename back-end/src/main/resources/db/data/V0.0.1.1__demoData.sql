INSERT INTO product(id, version, title, price, type)
VALUES (1, 0, 'Paranoid', 20.00, 'Lp');
INSERT INTO product(id, version, title, price, type)
VALUES (2, 0, 'The Richest Man In Babylon', 18.00, 'Lp');
INSERT INTO product(id, version, title, price, type)
VALUES (3, 0, 'Journey In Satchidananda', 25.00, 'Lp');
INSERT INTO product(id, version, title, price, type)
VALUES (4, 0, 'League of Legends', 1.00, 'Game');
INSERT INTO product(id, version, title, price, type)
VALUES (5, 0, 'Minecraft', 23.95, 'Game');
INSERT INTO product(id, version, title, price, type)
VALUES (6, 0, 'Artifact', 17.95, 'Game');
INSERT INTO product(id, version, title, price, type)
VALUES (7, 0, 'The Kite Runner', 11.95, 'Fiction');
INSERT INTO product(id, version, title, price, type)
VALUES (8, 0, 'The Help', 9.95, 'Fiction');
INSERT INTO product(id, version, title, price, type)
VALUES (9, 0, 'The Oxford History of Ancient Egypt', 12.99, 'Non fiction');
INSERT INTO product(id, version, title, price, type)
VALUES (10, 0, 'Cooking Basics for Dummies', 14.99, 'Non fiction');

INSERT INTO lp(id, artist, lp_genre)
VALUES (1, 'Black Sabbath', 'ROCK');
INSERT INTO lp(id, artist, lp_genre)
VALUES (2, 'Thievery Corporation', 'ELECTRONIC');
INSERT INTO lp(id, artist, lp_genre)
VALUES (3, 'Alice Coltrane', 'JAZZ');

INSERT INTO game(id, publisher, min_age, game_genre)
VALUES (4, 'Riot Games', 12, 'MOBA');
INSERT INTO game(id, publisher, min_age, game_genre)
VALUES (5, 'Mojang', 42, 'SANDBOX');
INSERT INTO game(id, publisher, min_age, game_genre)
VALUES (6, 'Valve', 12, 'RTS');

INSERT INTO book(id, author, isbn, pages)
VALUES (7, 'Khaled Hosseini', '978-15-9448-000-3', '371');
INSERT INTO book(id, author, isbn, pages)
VALUES (8, 'Kathryn Stockett', '978-03-9915-534-5', '465');
INSERT INTO book(id, author, isbn, pages)
VALUES (9, 'Ian Shaw', '978-01-9815-034-3', '554');
INSERT INTO book(id, author, isbn, pages)
VALUES (10, 'Bryan Miller', '978-07-6457-206-7', '436');

INSERT INTO fiction(id, fiction_genre, summary)
VALUES (7, 'THRILLER',
        'A sweeping story of family, love, and friendship told against the devastating backdrop of the history of Afghanistan over the last thirty years, The Kite Runner is an unusual and powerful novel that has become a beloved, one-of-a-kind classic.');
INSERT INTO fiction(id, fiction_genre, summary)
VALUES (8, 'ROMANCE',
        'Twenty-two-year-old Skeeter has just returned home after graduating from Ole Miss. She may have a degree, but it is 1962, Mississippi, and her mother will not be happy till Skeeter has a ring on her finger.');

INSERT INTO non_fiction(id, nonfiction_subject)
VALUES (9, 'HISTORY');
INSERT INTO non_fiction(id, nonfiction_subject)
VALUES (10, 'COOKBOOK');