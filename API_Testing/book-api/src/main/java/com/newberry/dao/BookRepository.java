package com.newberry.dao;

import com.newberry.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIsbn(String isbn);

    @Query("FROM Book b INNER JOIN b.authors b where b.firstName = :firstName and b.lastName = :lastName")
    List<Book> findByAuthor(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<Book> findAll();

}