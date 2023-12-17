package org.example.dto_request.subject.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorString;

import java.util.List;

public class AddSubjectValidator implements RequestValidator<AddSubjectRequest> {
    @Override
    public List<String> validate(AddSubjectRequest request, List<String> errors) {

        ValidatorString.validateNull(request.getName(), errors, "name");
        return errors;
    }
}
