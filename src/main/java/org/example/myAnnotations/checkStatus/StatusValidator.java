package org.example.myAnnotations.checkStatus;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.enums.StatusStudent;

import java.util.ArrayList;

public class StatusValidator implements ConstraintValidator<CheckStatus, String> {
    private static final ArrayList<String> validStatus = new ArrayList<>();

    @Override
    public void initialize(CheckStatus constraintAnnotation) {
        validStatus.add(StatusStudent.STUDIES.toString().toLowerCase());
        validStatus.add(StatusStudent.EXPELLED.toString().toLowerCase());
        validStatus.add(StatusStudent.ACADEMIC_LEAVE.toString().toLowerCase());
    }

    @Override
    public boolean isValid(String status, ConstraintValidatorContext context) {
        if (status == null || status.isEmpty()) {
            return false;
        }
        return validStatus.contains(status.toLowerCase());
    }
}
