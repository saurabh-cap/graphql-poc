package com.capillary.graphqlresolver.repository;

import com.capillary.graphqlresolver.models.Post;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class PostRepository {
    public Post save(Post post) {
        return null;
    }

    public List<Post> findAll() {
        try {
            throw new ClassNotFoundException("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Post> findByAuthorId(String id) {
        try {
            throw new ClassNotFoundException("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Post findOne(String postId) {
        return null;
    }
}
