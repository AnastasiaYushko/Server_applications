package org.example.dto_request.studentGroup.validation;

import org.example.dto_request.studentGroup.GetStudentGroupByIdRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetStudentGroupByIdValidator implements RequestValidator<GetStudentGroupByIdRequest> {

    @Override
    public List<String> validate(GetStudentGroupByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");
        return errors;
    }
}
