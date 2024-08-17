/*
package org.example.dto.dtoRequest.subject.validation;

import org.example.dto.dtoRequest.subject.EditSubjectRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.example.validators.ValidatorString;

import java.util.List;

public class EditSubjectValidator implements RequestValidator<EditSubjectRequest> {

    @Override
    public List<String> validate(EditSubjectRequest request, List<String> errors) {

        int maxLength = 50;
        ValidatorString.validateNull(request.getName(), errors, "name");
        ValidatorString.validateEmpty(request.getName(), errors, "name");
        ValidatorString.validateLength(request.getName(), errors, "name", maxLength);

        ValidatorNumber.validateNumber(request.getId(), errors, "id");
        return errors;
    }
}
 */
