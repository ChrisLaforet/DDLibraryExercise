DROP TABLE IF EXISTS patron;

CREATE TABLE patron(
    id INT AUTO_INCREMENT PRIMARY_KEY,
    name VARCHAR(100) NOT NULL
);

INSERT INTO patron (name) VALUES
    ('John Doe'),
    ('Joan Researcher');


DROP TABLE IF EXISTS catalog;

CREATE TABLE catalog(
    isbn VARCHAR(20) PRIMARY_KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100)
);

INSERT INTO catalog (isbn, title, author) VALUES
    ('0130895725', 'Plague Distribution', 'Dr. Samuel Xerces'),
    ('13028419x', 'Utilizing the Web Effectively', 'Susan Simone'),
    ('198718721', 'Adventures in Lawncare', 'Hank R. Arugula');


DROP TABLE IF EXISTS book;

CREATE TABLE book(
    id INT AUTO_INCREMENT PRIMARY_KEY,
    isbn VARCHAR(20) NOT NULL,
    price DOUBLE NOT NULL,
    isRestrictedCopy BOOLEAN NOT NULL
);

INSERT INTO book (isbn, price, isRestrictedCopy) VALUES
    ('0130895725', 74.99, 1),
    ('0130895725', 74.99, 1),
    ('0130895725', 74.99, 0),
    ('13028419x', 24.95, 0),
    ('198718721', 19.99, 0);


DROP TABLE IF EXISTS book_checkout;

CREATE TABLE book_checkout(
    id INT AUTO_INCREMENT PRIMARY_KEY,
    bookId INT NOT NULL,
    patronId INT NOT NULL,
    checkedOut DATE NOT NULL
);


DROP TABLE IF EXISTS title_hold;

CREATE TABLE title_hold(
    id INT AUTO_INCREMENT PRIMARY_KEY,
    isbn VARCHAR(20) NOT NULL,
    isClosedEnded BOOLEAN NOT NULL
    patronId INT NOT NULL,
    notified DATE,
);

