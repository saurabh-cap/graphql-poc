package com.capillary.graphqlresolver.util;

import java.util.Map;

public interface QueryBuilder {
    public <T> String build(String type, Class<T> clazz);
}
