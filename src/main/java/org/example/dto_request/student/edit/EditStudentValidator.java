package org.example.dto_request.student.edit;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.example.validators.ValidatorString;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

        ValidatorString.validateNull(request.getStatus(), errors, "status");
        ValidatorString.validateEmpty(request.getStatus(), errors, "status");

        ValidatorNumber.validateNumber(Integer.parseInt(request.getGroup()), errors, "groupId");

        return errors;
    }
}
