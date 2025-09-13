package com.newberry.dao;

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
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Before
    public void setup() throws Exception {
        authorRepository.deleteAllInBatch();
    }

    @Test
    public void verifyAuthorUpdates() throws Exception{
        // No Authors
        assertEquals(0, authorRepository.findAll().size());
        // Create a new author
        authorRepository.save(new Person("Charles",  "Dickens", new LocalDate().minusYears(30)));
        assertNotNull(authorRepository.findAll());
        assertEquals(1, authorRepository.findAll().size());
        // Create another author
        authorRepository.save(new Person("William",  "Shakespeare", new LocalDate().minusYears(40)));
        assertNotNull(authorRepository.findAll());
        assertEquals(2, authorRepository.findAll().size());
    }
}
