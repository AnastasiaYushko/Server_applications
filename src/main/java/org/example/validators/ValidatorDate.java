package org.example.validators;

import java.util.List;
import java.util.regex.Pattern;

public class ValidatorDate {

    public static void validateDate(String date, List<String> error, String fieldName) {
        String regex = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20|21)\\d\\d)";
        if (!Pattern.matches(regex, date)){
            error.add(fieldName + "  is not a date");
        }
    }
}
