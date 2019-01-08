package com.capillary.graphqlresolver.util;

import com.capillary.graphqlresolver.datafetcher.AllAuthorsDataFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Service
public class QueryUtil {
    private GraphQL graphQL;
    private File schemaFile;

    @Autowired
    private AllAuthorsDataFetcher allAuthorsDataFetcher;

    @PostConstruct
    private void buildSchema() throws FileNotFoundException {
        loadSchemaFile();
        buildGraphQL(buildRuntimeWiring());
    }

    private void buildGraphQL(RuntimeWiring runtimeWiring) {
        final TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
        typeRegistry.merge(new SchemaParser().parse(schemaFile));
        final GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("allAuthors", allAuthorsDataFetcher))
                .build();
    }

    private void loadSchemaFile() throws FileNotFoundException {
        final URL resource = getClass().getClassLoader().getResource("schema.graphqls");
        if (resource == null) {
            throw new FileNotFoundException("Schema File not present in /resources");
        }
        schemaFile = new File(resource.getFile());
    }

    public ExecutionResult executeQuery(String query) {
        return graphQL.execute(query);
    }
}
