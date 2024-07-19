package org.example.dto_request.student.get.byGroup;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetStudentsByGroupValidator implements RequestValidator<GetStudentsByGroupRequest> {

    @Override
    public List<String> validate(GetStudentsByGroupRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");
        return errors;
    }
}
