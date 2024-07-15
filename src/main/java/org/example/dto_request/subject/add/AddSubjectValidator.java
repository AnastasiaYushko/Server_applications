package org.example.dto_request.subject.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddSubjectValidator implements RequestValidator<AddSubjectRequest> {

    @Override
    public List<String> validate(AddSubjectRequest request, List<String> errors) {

        ValidatorString.validateNull(request.getName(), errors, "name");
        return errors;
    }
}
