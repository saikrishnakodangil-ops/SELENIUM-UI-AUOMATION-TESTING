package com.newberry.service;

import com.newberry.dao.AuthorRepository;
import com.newberry.dao.BookRepository;
import com.newberry.domain.Book;
import com.newberry.domain.Person;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookServiceTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private BookService bookService;

    @Before
    public void setup() throws Exception {
        bookService = new CrudBookService(bookRepository, authorRepository);
        authorRepository.deleteAllInBatch();
        bookRepository.deleteAllInBatch();
    }

    @Test
    public void verifyAuthorUpdates() throws Exception{
        // No Authors
        assertEquals(0, authorRepository.findAll().size());
        // Create a new author
        bookService.addAuthor(new Person("Charles",  "Dickens", new LocalDate().minusYears(30)));
        assertNotNull(authorRepository.findAll());
        assertEquals(1, authorRepository.findAll().size());
        // Create another author
        bookService.addAuthor(new Person("William",  "Shakespeare", new LocalDate().minusYears(40)));
        assertNotNull(authorRepository.findAll());
        assertEquals(2, authorRepository.findAll().size());
    }

    @Test
    public void verifyBookUpdates() throws Exception{
        // No Books or Authors
        assertEquals(0, bookRepository.findAll().size());
        assertEquals(0, authorRepository.findAll().size());

        // Create a new book with 2 authors
        Book book = new Book("123456790", "test title", "test description");
        book.getAuthors().add(new Person("Mark",  "Twain", new LocalDate().minusYears(30)));
        book.getAuthors().add(new Person("Leo",  "Tolstoy", new LocalDate().minusYears(40)));
        bookService.addBook(book);
        assertEquals(1, bookService.findAllBooks().size());
        assertEquals(2, bookService.findAllAuthors().size());
        assertEquals(1, bookService.findBookByISBN("123456790").size());
        assertEquals(1, bookService.findBookByAuthor("Mark", "Twain").size());
        assertEquals(1, bookService.findBookByAuthor("Leo", "Tolstoy").size());
        assertEquals(0, bookService.findBookByISBN("9123456790").size());
        assertEquals(0, bookService.findBookByAuthor("Mark", "Rowling").size());
        assertEquals(0, bookService.findBookByAuthor("Leo", "Shakespeare").size());
        assertEquals(0, bookService.findBookByAuthor("Jane", "Twain").size());
        assertEquals(0, bookService.findBookByAuthor("Stephen", "Tolstoy").size());

        // Remove all the authors from the book
        book.getAuthors().clear();
        bookService.addBook(book);
        assertEquals(1, bookService.findAllBooks().size());
        assertEquals(2, bookService.findAllAuthors().size());
        assertEquals(0, bookService.findBookByAuthor("Mark", "Twain").size());
        assertEquals(0, bookService.findBookByAuthor("Leo", "Tolstoy").size());

        // Create a new book with the already existing authors
        Book book2 = new Book("123456791", "test title", "test description");
        book2.getAuthors().addAll(authorRepository.findAll());
        bookService.addBook(book2);
        assertEquals(2, bookService.findAllBooks().size());
        assertEquals(2, bookService.findAllAuthors().size());
        assertEquals(1, bookService.findBookByAuthor("Mark", "Twain").size());
        assertEquals(1, bookService.findBookByAuthor("Leo", "Tolstoy").size());

    }
}
