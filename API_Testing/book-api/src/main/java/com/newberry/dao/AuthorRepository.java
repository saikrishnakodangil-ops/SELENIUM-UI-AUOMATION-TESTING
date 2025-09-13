package com.newberry.dao;

import com.newberry.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AuthorRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

}
