package org.example.dto_request.student.get.byId;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStudentByIdValidator implements RequestValidator<GetStudentByIdRequest> {

    @Override
    public List<String> validate(GetStudentByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getStudentId(), errors, "id");
        return errors;
    }
}
