package com.oopstudy.board.util;

public final class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(final String value) {
        return value == null || value.trim().equals("");
    }
}
