package com.javabrains.restservice.Library;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Year;
import java.util.Date;


@Entity
@Table(name="books")
public class Book {
    private Long id;
    private String title;
    private Date yearPublished;
    @JsonIgnore
    private Author author;

    public Book() {
    }

    public Book(Long id, String title, Date yearPublished, Author author) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
        this.author = author;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Date yearPublished) {
        this.yearPublished = yearPublished;
    }

    @ManyToOne
    @JoinColumn(name="author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearPublished=" + yearPublished +
                ", author=" + author +
                '}';
    }
}
