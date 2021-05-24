DROP TABLE IF EXISTS patron;

CREATE TABLE patron(
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    is_researcher BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS catalog;

CREATE TABLE catalog(
    isbn VARCHAR(20) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100)
);

DROP TABLE IF EXISTS book;

CREATE TABLE book(
    id INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(20) NOT NULL,
    price DOUBLE NOT NULL,
    is_restricted_copy BOOLEAN NOT NULL
);

DROP TABLE IF EXISTS book_checkout;

CREATE TABLE book_checkout(
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT NOT NULL,
    patron_id INT NOT NULL,
    checked_out DATE NOT NULL
);


DROP TABLE IF EXISTS title_hold;

CREATE TABLE title_hold(
    id INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(20) NOT NULL,
    isClosedEnded BOOLEAN NOT NULL,
    patronId INT NOT NULL,
    notified DATE
);

