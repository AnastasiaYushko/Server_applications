package org.example.dto_request.student.get.byId;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetStudentByIdValidator implements RequestValidator<GetStudentByIdRequest> {
    @Override
    public List<String> validate(GetStudentByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");
        return errors;
    }
}
