package org.example.dtoRequest.subject.validation;

import org.example.dtoRequest.subject.GetSubjectByIdRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetSubjectByIdValidator implements RequestValidator<GetSubjectByIdRequest> {

    @Override
    public List<String> validate(GetSubjectByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        return errors;
    }
}
