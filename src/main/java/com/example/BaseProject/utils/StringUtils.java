package com.example.BaseProject.utils;

public class StringUtils {
    public static boolean isNotNullOrEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
