package org.example.validators;

import org.example.enums.StatusStudent;

import java.util.List;
import java.util.Objects;

public class ValidatorStatus {
    public static void validateEmpty(String status, List<String> error, String fieldName) {
        if (status != null && status.isEmpty()) {
            error.add(fieldName + " is empty");
        }
    }

    public static void validateNull(String status, List<String> error, String fieldName) {
        if (status == null) {
            error.add(fieldName + " is null");
        }
    }
    public static void validateCorrectStatus(String status, List<String> error, String fieldName) {

        if (!((Objects.equals(StatusStudent.STUDIES.toString(), status))
                || (Objects.equals(StatusStudent.EXPELLED.toString(), status))
                || (Objects.equals(StatusStudent.ACADEMIC_LEAVE.toString(), status)))){
            error.add("Incorrect status : " + status + " in the field " + fieldName);
        }
    }
}
