package com.capillary.graphqlresolver.repository;

import com.capillary.graphqlresolver.models.Author;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class AuthorRepository {
    public Author findOne(String authorId) {
        return null;
    }

    public Author save(Author author) {
        return null;
    }

    public void delete(String id) {

    }

    public List<Author> findAll() {
        Author author1=new Author();
        author1.setId("1");
        author1.setName("saurabh");
        return Arrays.asList(author1);
    }
}
