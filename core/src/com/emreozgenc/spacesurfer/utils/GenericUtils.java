package com.emreozgenc.spacesurfer.utils;

import java.lang.reflect.ParameterizedType;

public class GenericUtils {
    public static <T> T getInstantGeneric(int index, Object object) {
        Class<?> c = null;
        try {
            c = Class.forName(
                    ((ParameterizedType) object.getClass().getGenericSuperclass())
                            .getActualTypeArguments()[index].getTypeName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return (T) c.getConstructor().newInstance();
        } catch (Exception ex) {
        }
        return null;
    }
}
