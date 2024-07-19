package org.example.dto_request.subject.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorString;

import java.util.List;

public class AddSubjectValidator implements RequestValidator<AddSubjectRequest> {

    @Override
    public List<String> validate(AddSubjectRequest request, List<String> errors) {

        int maxLength = 50;
        ValidatorString.validateLength(request.getName(), errors, "name", maxLength);
        ValidatorString.validateNull(request.getName(), errors, "name");
        return errors;
    }
}
