package com.newberry.service;

import com.newberry.domain.Book;
import com.newberry.domain.Person;

import java.util.List;

public interface BookService {
    Person addAuthor(Person author);

    List<Person> findAllAuthors();

    Book addBook(Book book);

    List<Book> findAllBooks();

    List<Book> findBookByISBN(String isbn);

    List<Book> findBookByAuthor(String firstName, String lastName);
}
