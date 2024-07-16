package org.example.dto_request.subject.delete;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteSubjectValidator implements RequestValidator<DeleteSubjectRequest> {
    @Override
    public List<String> validate(DeleteSubjectRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(), errors, "id");
        return errors;
    }
}
