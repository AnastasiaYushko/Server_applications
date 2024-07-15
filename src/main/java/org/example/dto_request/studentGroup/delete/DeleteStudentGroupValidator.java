package org.example.dto_request.studentGroup.delete;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteStudentGroupValidator implements RequestValidator<DeleteStudentGroupRequest> {

    @Override
    public List<String> validate(DeleteStudentGroupRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");
        return errors;
    }
}
