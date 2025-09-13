package com.newberry.dao;

import com.newberry.domain.Book;
import com.newberry.domain.Person;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Before
    public void setup() throws Exception {
        authorRepository.deleteAllInBatch();
        bookRepository.deleteAllInBatch();
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
        bookRepository.save(book);
        assertEquals(1, bookRepository.findAll().size());
        assertEquals(2, authorRepository.findAll().size());
        assertEquals(1, bookRepository.findByIsbn("123456790").size());
        assertEquals(1, bookRepository.findByAuthor("Mark", "Twain").size());
        assertEquals(1, bookRepository.findByAuthor("Leo", "Tolstoy").size());
        assertEquals(0, bookRepository.findByIsbn("9123456790").size());
        assertEquals(0, bookRepository.findByAuthor("Mark", "Rowling").size());
        assertEquals(0, bookRepository.findByAuthor("Leo", "Shakespeare").size());
        assertEquals(0, bookRepository.findByAuthor("Jane", "Twain").size());
        assertEquals(0, bookRepository.findByAuthor("Stephen", "Tolstoy").size());

        // Remove all the authors from the book
        book.getAuthors().clear();
        bookRepository.save(book);
        assertEquals(1, bookRepository.findAll().size());
        assertEquals(2, authorRepository.findAll().size());
        assertEquals(0, bookRepository.findByAuthor("Mark", "Twain").size());
        assertEquals(0, bookRepository.findByAuthor("Leo", "Tolstoy").size());

        // Create a new book with the already existing authors
        Book book2 = new Book("123456791", "test title", "test description");
        book2.getAuthors().addAll(authorRepository.findAll());
        bookRepository.save(book2);
        assertEquals(2, bookRepository.findAll().size());
        assertEquals(2, authorRepository.findAll().size());
        assertEquals(1, bookRepository.findByAuthor("Mark", "Twain").size());
        assertEquals(1, bookRepository.findByAuthor("Leo", "Tolstoy").size());

    }
}
