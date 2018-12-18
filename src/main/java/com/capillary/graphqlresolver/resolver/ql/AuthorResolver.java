package com.capillary.graphqlresolver.resolver.ql;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Post;
import com.capillary.graphqlresolver.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorResolver.class);

    @Autowired
    private PostRepository postRepository;

    public List<Post> posts(Author auth) {
        LOGGER.error("author resolver posts");
        return postRepository.findByAuthorId(auth.getId());
    }
}