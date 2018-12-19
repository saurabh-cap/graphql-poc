package com.capillary.graphqlresolver.resolver.ql;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Comment;
import com.capillary.graphqlresolver.models.Post;
import com.capillary.graphqlresolver.repository.AuthorRepository;
import com.capillary.graphqlresolver.repository.CommentRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostResolver implements GraphQLResolver<Post> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostResolver.class);

    @Autowired
    private AuthorRepository authRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Author author(Post post) {
        LOGGER.error("post " + post.getTitle() + " authour" + post.getAuthorId());
        return authRepository.findOne(post.getAuthorId());
    }

    public List<Comment> comments(Post post) {
        LOGGER.error("post resolver comments");
        return commentRepository.findByPostId(post.getId());
    }

    public List<Author> authors(Post post) {
        LOGGER.error("post " + post.getTitle() + " author" + post.getAuthorId());
        return authRepository.findAll();
    }
}
