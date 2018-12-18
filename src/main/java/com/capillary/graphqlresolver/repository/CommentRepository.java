package com.capillary.graphqlresolver.repository;

import com.capillary.graphqlresolver.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CommentRepository {
    public List<Comment> findByPostId(String postId){
        return Collections.emptyList();
    }
}
