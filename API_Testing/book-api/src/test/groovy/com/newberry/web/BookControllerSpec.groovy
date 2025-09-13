package com.newberry.web

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.newberry.dao.AuthorRepository
import com.newberry.dao.BookRepository
import com.newberry.domain.Person
import com.newberry.service.CrudBookService
import org.joda.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@ContextConfiguration
@DataJpaTest
class BookControllerSpec extends Specification{

    def mockMvc

    @Autowired
    AuthorRepository authorRepository

    @Autowired
    BookRepository bookRepository

    void setup() {
        def bookService = new CrudBookService(bookRepository, authorRepository)
        def controller = new BookController(bookService)
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
        authorRepository.deleteAllInBatch()
        bookRepository.deleteAllInBatch()
    }

    @Unroll
    def "add new Authors"() {
        when:'a new author is added'
        def mapper = new ObjectMapper()

        authorRepository.findAll().size() == 0
        bookRepository.findAll().size()   == 0

        authors.collect { author -> mockMvc.perform(post('/author')
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(author))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())}

        then:'check the number of authors'
        authorRepository.findAll().size() == totalAuthors
        authorRepository.findAll().any{ar -> authors.any { a -> ar.firstName == a.firstName && ar.lastName == a.lastName && ar.birthDate == a.birthDate }}

        MvcResult result = mockMvc.perform(get("/authors")).
                andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn()

        def resultContent = result.getResponse().getContentAsString()

        def authorsResult = mapper.readValue(resultContent, new TypeReference<List<Person>>(){})
        authorsResult.size() == totalAuthors

        authorsResult.any{ar -> authors.any { a -> ar.firstName == a.firstName && ar.lastName == a.lastName && ar.birthDate == a.birthDate }}

        where: 'following are the authors'
        authors                                                                  | totalAuthors
        [new Person('Charles',   'Dickens', new LocalDate().minusYears(30))]     | 1
        [new Person('Charles',  'Dickens', null)]                                | 1
        [new Person('Charles',   'Dickens', new LocalDate().minusYears(30))
         , new Person('William', 'Shakespeare', new LocalDate().minusYears(30))] | 2
    }
}
