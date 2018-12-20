package com.capillary.graphqlresolver.util;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Comment;
import com.capillary.graphqlresolver.models.Post;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class GraphQLQueryBuilder {

    public static final List<Class> NESTABLE_CLASSES = Arrays.asList(Author.class, Comment.class, Post.class);
    private static final String NEW_LINE = "\n";
    private static final String OPEN_CURLY_BRACE = "{";
    private static final String TAB = "\t";
    private static final String CLOSE_CURLY_BRACE = "}";

    public static <T> String build(Class<T> klazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPEN_CURLY_BRACE + NEW_LINE);
        Field[] fields = klazz.getDeclaredFields();
        for (Field field : fields) {
            stringBuilder.append(TAB);
            stringBuilder.append(field.getName());
            if (NESTABLE_CLASSES.contains(field.getType())) {
                stringBuilder.append(build(field.getType()));
            }
            stringBuilder.append(NEW_LINE);
        }
        stringBuilder.append(CLOSE_CURLY_BRACE);
        return stringBuilder.toString();
    }
}