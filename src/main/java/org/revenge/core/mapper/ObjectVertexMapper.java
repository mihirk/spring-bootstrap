package org.revenge.core.mapper;

import com.tinkerpop.blueprints.Vertex;

import java.lang.reflect.Field;

public class ObjectVertexMapper<T> {

    public Vertex toVertex(Vertex vertex, T object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String key = declaredField.getName();
            Class<?> type = declaredField.getType();
            vertex.setProperty(key, type.cast(declaredField.get(object)));
            declaredField.setAccessible(false);
        }
        return vertex;
    }

    public T toObject(Vertex vertex, T object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            declaredField.set(object, type.cast(vertex.getProperty(declaredField.getName())));
            declaredField.setAccessible(false);
        }
        return object;
    }
}
