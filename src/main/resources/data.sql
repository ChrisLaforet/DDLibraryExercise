INSERT INTO catalog (isbn, title, author) VALUES ('0130895725', 'Plague Distribution', 'Dr. Samuel Xerces');
INSERT INTO catalog (isbn, title, author) VALUES ('13028419x', 'Utilizing the Web Effectively', 'Susan Simone');
INSERT INTO catalog (isbn, title, author) VALUES ('198718721', 'Adventures in Lawncare', 'Hank R. Arugula');

INSERT INTO book (id, isbn, price, is_restricted_copy) VALUES (1, '0130895725', 74.99, 1);
INSERT INTO book (id, isbn, price, is_restricted_copy) VALUES (2, '0130895725', 74.99, 1);
INSERT INTO book (id, isbn, price, is_restricted_copy) VALUES (3, '0130895725', 74.99, 0);
INSERT INTO book (id, isbn, price, is_restricted_copy) VALUES (4, '13028419x', 24.95, 0);
INSERT INTO book (id, isbn, price, is_restricted_copy) VALUES (5, '198718721', 19.99, 0);

INSERT INTO `patron` (id, is_researcher, full_name) VALUES (1, 0, 'John Doe');
INSERT INTO `patron` (id, is_researcher, full_name) VALUES (2, 1, 'Joan Researcher');
