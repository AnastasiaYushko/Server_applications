package org.example.dto_request.studentGroup.validation;

import org.example.dto_request.studentGroup.DeleteStudentGroupRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteStudentGroupValidator implements RequestValidator<DeleteStudentGroupRequest> {

    @Override
    public List<String> validate(DeleteStudentGroupRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");
        return errors;
    }
}
