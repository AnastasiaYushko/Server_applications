/*
package org.example.dto.dtoRequest.student.validation;

import org.example.dto.dtoRequest.student.AddStudentRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.example.validators.ValidatorStatus;
import org.example.validators.ValidatorString;

import java.util.List;

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

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");

        ValidatorStatus.validateNull(request.getStatus(), errors, "status");
        ValidatorStatus.validateEmpty(request.getStatus(), errors, "status");
        ValidatorStatus.validateCorrectStatus(request.getStatus(), errors, "status");

        return errors;
    }
}
 */
