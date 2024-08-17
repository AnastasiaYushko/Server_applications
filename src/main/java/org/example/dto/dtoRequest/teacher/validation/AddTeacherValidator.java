/*
package org.example.dto.dtoRequest.teacher.validation;

import org.example.dto.dtoRequest.teacher.AddTeacherRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorString;

import java.util.List;

public class AddTeacherValidator implements RequestValidator<AddTeacherRequest> {

    @Override
    public List<String> validate(AddTeacherRequest request, List<String> errors) {

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

        return errors;
    }
}
 */
