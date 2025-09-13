package com.newberry.dao

import com.newberry.domain.Book
import com.newberry.domain.Person
import org.joda.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration
@DataJpaTest
class BookRepositorySpec extends Specification{

    @Autowired
    BookRepository bookRepository

    void setup() {
        bookRepository.deleteAll()
    }

    def "add a new book"() {
        when:'a new book is added'
        Book book = new Book("123456790", "test title", "test description");
        book.getAuthors().add(new Person("Mark",  "Twain", new LocalDate().minusYears(30)));
        book.getAuthors().add(new Person("Leo",  "Tolstoy", new LocalDate().minusYears(40)));
        bookRepository.save(book);

        then:'check the number of books and authors'
        bookRepository.findAll().size() == 1
    }
}
