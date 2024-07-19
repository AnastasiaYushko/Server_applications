package org.example.dto_request.studentGroup.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorString;

import java.util.List;

public class AddStudentGroupValidator implements RequestValidator<AddStudentGroupRequest> {
    @Override
    public List<String> validate(AddStudentGroupRequest request, List<String> errors) {

        int maxLength = 50;

        ValidatorString.validateNull(request.getName(), errors, "name");
        ValidatorString.validateEmpty(request.getName(), errors, "name");
        ValidatorString.validateLength(request.getName(), errors, "name", maxLength);

        return errors;
    }
}
