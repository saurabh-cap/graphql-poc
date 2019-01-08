package com.capillary.graphqlresolver.controller;

import com.capillary.graphqlresolver.datafetcher.AllAuthorsDataFetcher;
import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.repository.AuthorRepository;
import com.capillary.graphqlresolver.util.QueryBuilder;
import com.capillary.graphqlresolver.util.QueryUtil;
import com.capillary.graphqlresolver.util.impl.GraphQLQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/author", produces = "application/json")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    AllAuthorsDataFetcher allAuthorsDataFetcher;

    @Autowired
    private QueryUtil queryUtil;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll() {
        QueryBuilder queryBuilder = new GraphQLQueryBuilder();
        return queryBuilder.build("query", Author.class);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/allAuthors")
    public String sampleQuery() {
        return queryUtil.executeQuery("{" +
                "  allAuthors{" +
                "    id" +
                "  }" +
                "}").getData().toString();
    }
}
