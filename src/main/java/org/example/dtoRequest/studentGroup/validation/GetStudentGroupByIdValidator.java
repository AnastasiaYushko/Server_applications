package org.example.dtoRequest.studentGroup.validation;

import org.example.dtoRequest.studentGroup.GetStudentGroupByIdRequest;
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
