package com.capillary.graphqlresolver.repository;

import com.capillary.graphqlresolver.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class CommentRepository {
    public List<Comment> findByPostId(String postId){
        Comment comment=new Comment();
        comment.setAuthorId("auth-123");
        comment.setPostId("post-123");
        comment.setId("1");
        comment.setText("text");
        return Arrays.asList(comment);
    }
}
