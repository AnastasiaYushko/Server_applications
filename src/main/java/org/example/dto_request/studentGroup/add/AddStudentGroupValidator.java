package org.example.dto_request.studentGroup.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddStudentGroupValidator implements RequestValidator<AddStudentGroupRequest> {
    @Override
    public List<String> validate(AddStudentGroupRequest request, List<String> errors) {

        int maxLength = 30;

        ValidatorString.validateNull(request.getName(), errors, "name");
        ValidatorString.validateEmpty(request.getName(), errors, "name");
        ValidatorString.validateLength(request.getName(), errors, "name", maxLength);

        return errors;
    }
}
