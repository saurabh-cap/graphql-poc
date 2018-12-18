package com.capillary.graphqlresolver.resolver.root;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Post;
import com.capillary.graphqlresolver.repository.AuthorRepository;
import com.capillary.graphqlresolver.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private AuthorRepository authRepo;

    @Autowired
    private PostRepository postRepo;

    public Author addAuthor(String name) {
        return authRepo.save(new Author());
    }

    public Author removeAuthour(String id) {
        Author auth = authRepo.findOne(id);
        authRepo.delete(id);
        return auth;
    }

    public Post addPost(String title, String body, String authorId) {
        Author auth = authRepo.findOne(authorId);

        if (auth != null) {
            Post post = new Post();
            post.setAuthorId(authorId);
            return postRepo.save(post);
        } else {
            return null;
        }
    }
}
