package org.example.validators;

import java.util.List;

public class ValidatorNumber {

    public static void validateNumber(int number, List<String> error, String fieldName) {
        if  (number > 0) {
            error.add(fieldName + "<= 0");
        }
    }
}
