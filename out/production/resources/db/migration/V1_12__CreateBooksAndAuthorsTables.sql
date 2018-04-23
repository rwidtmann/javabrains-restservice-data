DROP TABLE IF EXISTS authors;
CREATE TABLE authors (
  id BIGINT AUTO_INCREMENT,
  author_first_name VARCHAR(255) NOT NULL,
  author_last_name VARCHAR(255) NOT NULL,
  books_id BIGINT,
  PRIMARY KEY (id)
);


DROP TABLE IF EXISTS books;
CREATE TABLE books (
  id BIGINT AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  year_published DATE NOT NULL,
  author_id BIGINT,
  PRIMARY KEY(id),
  FOREIGN KEY(author_id)
    REFERENCES authors(id)
    ON DELETE CASCADE
);




