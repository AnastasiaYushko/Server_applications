package org.example.dto_request.teacher.validation;

import org.example.dto_request.teacher.DeleteTeacherRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteTeacherValidator implements RequestValidator<DeleteTeacherRequest> {

    @Override
    public List<String> validate(DeleteTeacherRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        return errors;
    }
}
