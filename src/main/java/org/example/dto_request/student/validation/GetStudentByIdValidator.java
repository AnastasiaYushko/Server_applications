package org.example.dto_request.student.validation;

import org.example.dto_request.student.GetStudentByIdRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetStudentByIdValidator implements RequestValidator<GetStudentByIdRequest> {

    @Override
    public List<String> validate(GetStudentByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getStudentId(), errors, "id");
        return errors;
    }
}
