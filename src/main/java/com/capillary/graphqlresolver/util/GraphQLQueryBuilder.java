package com.capillary.graphqlresolver.util;

import com.capillary.graphqlresolver.models.Author;
import com.capillary.graphqlresolver.models.Comment;
import com.capillary.graphqlresolver.models.Post;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class GraphQLQueryBuilder {

    private static final List<Class> NESTABLE_CLASSES = Arrays.asList(Author.class, Comment.class, Post.class);

    private static final String NEW_LINE = "\n";
    private static final String OPEN_CURLY_BRACE = "{";
    private static final String TAB = "\t";
    private static final String CLOSE_CURLY_BRACE = "}";

    public static <T> String build(Class<T> clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPEN_CURLY_BRACE + NEW_LINE);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            stringBuilder.append(TAB);
            stringBuilder.append(field.getName());
            final Class<?> nestableClass = getNestableClass(field);
            if (nestableClass != null) {
                stringBuilder.append(build(nestableClass));
            }
            stringBuilder.append(NEW_LINE);
        }
        stringBuilder.append(CLOSE_CURLY_BRACE);
        return stringBuilder.toString();
    }

    private static Class<?> getNestableClass(Field field) {
        final boolean isNestableClass = NESTABLE_CLASSES.contains(field.getType());
        if (isNestableClass) {
            return field.getType();
        } else {
            return getNestableClassInsideCollection(field);
        }
    }

    private static Class<?> getNestableClassInsideCollection(Field field) {
        if (field.getGenericType() instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
            final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                if (NESTABLE_CLASSES.contains(actualTypeArgument)) {
                    try {
                        return Class.forName(actualTypeArgument.getTypeName());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}