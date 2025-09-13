package com.newberry.service;

import com.newberry.dao.AuthorRepository;
import com.newberry.dao.BookRepository;
import com.newberry.domain.Book;
import com.newberry.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class CrudBookService implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public CrudBookService(@NotNull BookRepository bookRepository, @NotNull AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public Person addAuthor(@NotNull Person author) {
        this.authorRepository.save(author);
        return author;
    }

     @Override
     public List<Person> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional
    public Book addBook(@NotNull Book book) {
        this.bookRepository.save(book);
        return book;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Book> findBookByISBN(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Book> findBookByAuthor(String firstName, String lastName) {
        return bookRepository.findByAuthor(firstName, lastName);
    }

}
