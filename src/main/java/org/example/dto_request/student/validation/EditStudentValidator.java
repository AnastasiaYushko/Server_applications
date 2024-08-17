package org.example.dto_request.student.validation;

import org.example.dto_request.student.EditStudentRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.example.validators.ValidatorStatus;
import org.example.validators.ValidatorString;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EditStudentValidator implements RequestValidator<EditStudentRequest> {

    @Override
    public List<String> validate(@NotNull EditStudentRequest request, List<String> errors) {

        int maxLength = 50;

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        ValidatorString.validateNull(request.getLastName(), errors, "lastName");
        ValidatorString.validateEmpty(request.getLastName(), errors, "lastName");
        ValidatorString.validateLength(request.getLastName(), errors, "lastName", maxLength);

        ValidatorString.validateNull(request.getFirstName(), errors, "firstName");
        ValidatorString.validateEmpty(request.getFirstName(), errors, "firstName");
        ValidatorString.validateLength(request.getFirstName(), errors, "firstName", maxLength);

        ValidatorString.validateNull(request.getMiddleName(), errors, "middleName");
        ValidatorString.validateEmpty(request.getMiddleName(), errors, "middleName");
        ValidatorString.validateLength(request.getMiddleName(), errors, "middleName", maxLength);

        ValidatorStatus.validateNull(request.getStatus(), errors, "status");
        ValidatorStatus.validateEmpty(request.getStatus(), errors, "status");
        ValidatorStatus.validateCorrectStatus(request.getStatus(), errors, "status");

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");

        return errors;
    }
}