package org.example.dto_request.teacher.edit;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.example.validators.ValidatorString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditTeacherValidator implements RequestValidator<EditTeacherRequest> {

    @Override
    public List<String> validate(EditTeacherRequest request, List<String> errors) {

        int maxLength = 50;
        ValidatorString.validateNull(request.getLastName(), errors, "lastName");
        ValidatorString.validateEmpty(request.getLastName(), errors, "lastName");
        ValidatorString.validateLength(request.getLastName(), errors, "lastName", maxLength);

        ValidatorString.validateNull(request.getFirstName(), errors, "firstName");
        ValidatorString.validateEmpty(request.getFirstName(), errors, "firstName");
        ValidatorString.validateLength(request.getFirstName(), errors, "firstName", maxLength);

        ValidatorString.validateNull(request.getMiddleName(), errors, "middleName");
        ValidatorString.validateEmpty(request.getMiddleName(), errors, "middleName");
        ValidatorString.validateLength(request.getMiddleName(), errors, "middleName", maxLength);

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        return errors;
    }
}
