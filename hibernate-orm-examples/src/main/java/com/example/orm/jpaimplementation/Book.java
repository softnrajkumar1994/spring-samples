package com.example.orm.jpaimplementation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.ISBN;

@Getter
@Setter
@Entity(name = "book")
public class Book {
    @Id
    private String id;
    private String name;
    @ISBN
    private String isbn;
    private String author;
    @Email
    private String authorEmail;
}
