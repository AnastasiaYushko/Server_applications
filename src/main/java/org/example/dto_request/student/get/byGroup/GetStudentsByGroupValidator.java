package org.example.dto_request.student.get.byGroup;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStudentsByGroupValidator implements RequestValidator<GetStudentsByGroupRequest> {

    @Override
    public List<String> validate(GetStudentsByGroupRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");
        return errors;
    }
}
