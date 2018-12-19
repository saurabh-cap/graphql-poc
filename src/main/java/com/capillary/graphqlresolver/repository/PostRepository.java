package com.capillary.graphqlresolver.repository;

import com.capillary.graphqlresolver.models.Post;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class PostRepository {
    public Post save(Post post) {
        return null;
    }

    public List<Post> findAll() {
        Post post1 = new Post();
        post1.setAuthorId("saurabh1");
        post1.setBody("");
        post1.setTitle("hello1 ");
        post1.setId("1");

        Post post2 = new Post();
        post2.setAuthorId("saurabh2");
        post2.setBody("");
        post2.setTitle("hello2 ");
        post2.setId("2");

        return Arrays.asList(post1,post2);
    }

    public List<Post> findByAuthorId(String id) {

        Post post1 = new Post();
        post1.setAuthorId("saurabh");
        post1.setBody("");
        post1.setTitle("hello ");
        post1.setId("1");

        Post post2 = new Post();
        post2.setAuthorId("saurabh");
        post2.setBody("");
        post2.setTitle("hello ");
        post2.setId("1");

        return Arrays.asList(post1);
    }

    public Post findOne(String postId) {
        return null;
    }
}
