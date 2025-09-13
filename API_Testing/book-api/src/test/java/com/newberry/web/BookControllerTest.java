package com.newberry.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newberry.dao.AuthorRepository;
import com.newberry.dao.BookRepository;
import com.newberry.domain.Book;
import com.newberry.domain.Person;
import com.newberry.service.BookService;
import com.newberry.service.CrudBookService;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void before() {
        BookService bookService = new CrudBookService(bookRepository, authorRepository);
        BookController controller = new BookController(bookService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        this.authorRepository.deleteAllInBatch();
        this.bookRepository.deleteAllInBatch();
    }

    @Test
    public void checkBookSearch() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // Check the access urls
        mockMvc.perform(get("/books")).
                andExpect(status().isOk());

        mockMvc.perform(get("/authors")).
                andExpect(status().isOk());

        mockMvc.perform(get("/book/isbn/123456790")).
                andExpect(status().isOk());

        mockMvc.perform(get("/books/author/firstName/Mark/lastName/Tolstoy")).
                andExpect(status().isOk());

        // Create a new book with 2 authors
        Book book = new Book("123456790", "test title", "test description");
        book.getAuthors().add(new Person("Mark",  "Twain", new LocalDate().minusYears(30)));
        book.getAuthors().add(new Person("Leo",  "Tolstoy", new LocalDate().minusYears(40)));

        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Check the access urls and result count
        MvcResult result = mockMvc.perform(get("/books")).
                andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();
        assertNotNull(content);

        mockMvc.perform(get("/authors")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(2)));

        mockMvc.perform(get("/book/isbn/123456790")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(1)));

        mockMvc.perform(get("/books/author/firstName/Mark/lastName/Twain")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(1)));

        mockMvc.perform(get("/books/author/firstName/Leo/lastName/Tolstoy")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(1)));

        mockMvc.perform(get("/books/author/firstName/Mark/lastName/Rowling")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(0)));

        mockMvc.perform(get("/books/author/firstName/Leo/lastName/Shakespeare")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(0)));

        mockMvc.perform(get("/books/author/firstName/Jane/lastName/Twain")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(0)));

        mockMvc.perform(get("/books/author/firstName/Stephen/lastName/Tolstoy")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(0)));

        // Create a new book with no authors
        Book book2 = new Book("123456791", "test title1", "test description1");
        mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(book2))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Check the access urls and result count
        mockMvc.perform(get("/books")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(2)));

        mockMvc.perform(get("/authors")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(2)));

        mockMvc.perform(get("/books/author/firstName/Mark/lastName/Twain")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(1)));

        mockMvc.perform(get("/books/author/firstName/Leo/lastName/Tolstoy")).
                andExpect(status().isOk()).
                andExpect(jsonPath("$.*", hasSize(1)));
    }
}
