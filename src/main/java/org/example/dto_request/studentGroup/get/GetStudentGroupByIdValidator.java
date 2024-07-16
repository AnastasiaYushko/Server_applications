package org.example.dto_request.studentGroup.get;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStudentGroupByIdValidator implements RequestValidator<GetStudentGroupByIdRequest> {

    @Override
    public List<String> validate(GetStudentGroupByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");
        return errors;
    }
}
