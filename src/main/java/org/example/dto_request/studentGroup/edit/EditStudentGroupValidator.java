package org.example.dto_request.studentGroup.edit;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.example.validators.ValidatorString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditStudentGroupValidator implements RequestValidator<EditStudentGroupRequest> {

    @Override
    public List<String> validate(EditStudentGroupRequest request, List<String> errors) {

        int maxLength = 30;
        ValidatorString.validateNull(request.getName(), errors, "name");
        ValidatorString.validateEmpty(request.getName(), errors, "name");
        ValidatorString.validateLength(request.getName(), errors, "name", maxLength);

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        return errors;
    }
}
