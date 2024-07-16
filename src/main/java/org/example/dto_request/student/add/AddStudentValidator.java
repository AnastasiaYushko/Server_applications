package org.example.dto_request.student.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddStudentValidator implements RequestValidator<AddStudentRequest> {

    @Override
    public List<String> validate(AddStudentRequest request, List<String> errors) {

        int maxLength = 50;
        ValidatorString.validateNull(request.getLastName(), errors, "lastName");
        ValidatorString.validateEmpty(request.getLastName(), errors, "lastName");
        ValidatorString.validateLength(request.getLastName(), errors, "lastName", maxLength);

        ValidatorString.validateNull(request.getFirstName(), errors, "firstName");
        ValidatorString.validateEmpty(request.getFirstName(), errors, "firstName");
        ValidatorString.validateLength(request.getFirstName(), errors, "firstName", maxLength);

        ValidatorString.validateNull(request.getMiddleName(), errors, "middleName");
        ValidatorString.validateEmpty(request.getMiddleName(), errors, "middleName");
        ValidatorString.validateLength(request.getMiddleName(), errors, "middleName", maxLength);

        ValidatorString.validateNull(request.getGroupId(), errors, "groupId");
        ValidatorString.validateEmpty(request.getGroupId(), errors, "groupId");

        ValidatorString.validateNull(request.getStatus(), errors, "status");
        ValidatorString.validateEmpty(request.getStatus(), errors, "status");

        return errors;
    }
}
