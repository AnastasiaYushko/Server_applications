package org.example.dto_request.student.delete;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteStudentValidator implements RequestValidator<DeleteStudentRequest> {

    @Override
    public List<String> validate(DeleteStudentRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getStudentId(), errors, "number");

        return errors;
    }
}
