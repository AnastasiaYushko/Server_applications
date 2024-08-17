package org.example.dto_request.student.validation;

import org.example.dto_request.student.DeleteStudentRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteStudentValidator implements RequestValidator<DeleteStudentRequest> {

    @Override
    public List<String> validate(DeleteStudentRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getStudentId(), errors, "number");

        return errors;
    }
}