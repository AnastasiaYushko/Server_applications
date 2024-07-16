package org.example.dto_request.teacher.delete;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteTeacherValidator implements RequestValidator<DeleteTeacherRequest> {

    @Override
    public List<String> validate(DeleteTeacherRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");

        return errors;
    }
}
