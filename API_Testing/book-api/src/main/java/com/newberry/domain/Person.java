package com.newberry.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.newberry.serializers.LocalDateDeserializer;
import com.newberry.serializers.LocalDateSerializer;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String firstName;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String lastName;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    Person(){

    }

    public Person(String firstName, String lastName, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Long getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @JsonIgnore
    public Set<Book> getBooks() {
        return books;
    }

}
