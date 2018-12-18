package com.capillary.graphqlresolver.resolver.ql;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Comment;
import com.capillary.graphqlresolver.models.Post;
import com.capillary.graphqlresolver.repository.AuthorRepository;
import com.capillary.graphqlresolver.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentResolver implements GraphQLResolver<Comment> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentResolver.class);

    @Autowired
    private AuthorRepository authRepository;

    @Autowired
    private PostRepository postRepository;

    public Author createdBy(Comment comment) {
        LOGGER.error("comment resolver createdBy");
        return authRepository.findOne(comment.getAuthorId());
    }

    public Post belongsTo(Comment comment) {
        LOGGER.error("comment resolver belongsTo");
        return postRepository.findOne(comment.getPostId());
    }

}
