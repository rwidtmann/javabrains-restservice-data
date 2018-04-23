package com.javabrains.restservice.Library;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    private Long id;
    private String authorFirstName;
    private String authorLastName;
    private List<Book> bookList;

    public Author() {
    }

    public Author(long id, String authorFirstName, String authorLastName, List<Book> bookList) {
        this.id = id;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.bookList = bookList;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
