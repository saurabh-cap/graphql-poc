package com.capillary.graphqlresolver.controller;

import com.capillary.graphqlresolver.datafetcher.AllAuthorsDataFetcher;
import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.repository.AuthorRepository;
import com.capillary.graphqlresolver.util.QueryBuilder;
import com.capillary.graphqlresolver.util.impl.GraphQLQueryBuilder;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@RestController
@RequestMapping(path = "/author", produces = "application/json")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    AllAuthorsDataFetcher allAuthorsDataFetcher;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll() {
        QueryBuilder queryBuilder = new GraphQLQueryBuilder();
        return queryBuilder.build("query", Author.class);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sample")
    public String sampleQuery() {
        final File schemaFile = new File(getClass().getClassLoader().getResource("schema.graphqls").getFile());


        final RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("allAuthors", allAuthorsDataFetcher))
                .build();

        final TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
        typeRegistry.merge(new SchemaParser().parse(schemaFile));
        final GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring);

        final GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        final ExecutionResult executionResult = build.execute("{" +
                "  allAuthors{" +
                "    id" +
                "  }" +
                "}");

        return executionResult.getData().toString();
    }
}
