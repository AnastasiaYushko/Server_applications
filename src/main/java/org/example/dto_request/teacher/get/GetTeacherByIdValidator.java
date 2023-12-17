package org.example.dto_request.teacher.get;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetTeacherByIdValidator implements RequestValidator<GetTeacherByIdRequest> {
    @Override
    public List<String> validate(GetTeacherByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        return errors;
    }
}
