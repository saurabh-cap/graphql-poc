package com.capillary.graphqlresolver.controller;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Comment;
import com.capillary.graphqlresolver.models.Post;
import com.capillary.graphqlresolver.repository.AuthorRepository;
import com.capillary.graphqlresolver.util.GraphQLQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/author", produces = "application/json")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll() {
        return GraphQLQueryBuilder.build(Author.class);
    }
}
