package org.example.validators;

import java.util.List;

public class ValidatorString {
    public static void validateEmpty(String str, List<String> error, String fieldName) {
        if (str!= null && str.isEmpty()) {
            error.add(fieldName + " is empty");
        }
    }

    public static void validateNull(String str, List<String> error, String fieldName) {
        if (str == null) {
            error.add(fieldName + " is null");
        }
    }

    public static void validateLength(String str, List<String> error, String fieldName, int maxLength) {
        if (str != null && str.length() > maxLength) {
            error.add(fieldName + " exceeds the maximum length");
        }
    }
}
