package com.capillary.graphqlresolver.resolver.root;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Post;
import com.capillary.graphqlresolver.repository.AuthorRepository;
import com.capillary.graphqlresolver.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }
}
