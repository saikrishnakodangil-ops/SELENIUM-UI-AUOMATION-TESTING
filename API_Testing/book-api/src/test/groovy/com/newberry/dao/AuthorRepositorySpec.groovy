package com.newberry.dao

import com.newberry.domain.Person
import org.joda.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.InvalidDataAccessApiUsageException
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolationException

@SpringBootTest
@ContextConfiguration
@DataJpaTest
class AuthorRepositorySpec extends Specification{

    @Autowired
    AuthorRepository authorRepository

    void setup() {
        authorRepository.deleteAll()
    }

    @Unroll
    def "add new Authors"() {
        when:'a new author is added'

        authorRepository.findAll().size() == 0

        authors.collect { author -> authorRepository.save(author) }

        then:'check the number of authors'
        authorRepository.findAll().size() == totalAuthors

        where: 'following are the authors'
        authors                                                                  | totalAuthors
        [new Person('Charles',   'Dickens', new LocalDate().minusYears(30))]     | 1
        [new Person('Charles',  'Dickens', null)]                                | 1
        [new Person('Charles',   'Dickens', new LocalDate().minusYears(30))
         , new Person('William', 'Shakespeare', new LocalDate().minusYears(30))] | 2
    }

    @Unroll
    def "invalid data for author is added"() {
        when:'invalid data for the author is added'

        authorRepository.findAll().size() == 0

        authorRepository.save(authors)

        then:'check the number of authors'
        thrown error

        where: 'following are the authors'
        authors                                                            | totalAuthors | error
        [new Person('',  'Dickens', new LocalDate().minusYears(30))]       | 0            | ConstraintViolationException
        [new Person('Charles',  '', new LocalDate().minusYears(30))]       | 0            | ConstraintViolationException
        [new Person('',  '', new LocalDate().minusYears(30))]              | 0            | ConstraintViolationException
         null                                                              | 0            | InvalidDataAccessApiUsageException
    }

}
