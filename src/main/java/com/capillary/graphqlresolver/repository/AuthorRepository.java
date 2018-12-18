package com.capillary.graphqlresolver.repository;

import com.capillary.graphqlresolver.models.Author;
import org.springframework.stereotype.Repository;

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
        return Collections.emptyList();
    }
}
