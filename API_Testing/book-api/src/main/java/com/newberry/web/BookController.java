package com.newberry.web;

import com.newberry.domain.Book;
import com.newberry.domain.Person;
import com.newberry.service.BookService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(@NotNull BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value="author", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Person addAuthor(@RequestBody @NotNull Person author) {
        this.bookService.addAuthor(author);
        return author;
    }

    @RequestMapping(value="authors", method=RequestMethod.GET, produces = "application/json")
    public List<Person> findAllAuthors() {
        return bookService.findAllAuthors();
    }

    @RequestMapping(value="book", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Book addBook(@RequestBody @NotNull Book book) {
        this.bookService.addBook(book);
        return book;
    }

    @RequestMapping(value="books", method=RequestMethod.GET, produces = "application/json")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @RequestMapping(value="book/isbn/{isbn}", method=RequestMethod.GET, produces = "application/json")
    public List<Book> findBookByISBN(@PathVariable @NotEmpty String isbn) {
        return bookService.findBookByISBN(isbn);
    }

    @RequestMapping(value="books/author/firstName/{firstName}/lastName/{lastName}", method=RequestMethod.GET, produces = "application/json")
    public List<Book> findBookByAuthor(@PathVariable String firstName, @PathVariable String lastName) {
        return bookService.findBookByAuthor(firstName, lastName);
    }
}

