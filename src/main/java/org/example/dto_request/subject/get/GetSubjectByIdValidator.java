package org.example.dto_request.subject.get;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSubjectByIdValidator implements RequestValidator<GetSubjectByIdRequest> {

    @Override
    public List<String> validate(GetSubjectByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        return errors;
    }
}
