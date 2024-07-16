package org.example.dto_request.lesson.get.byGroup;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorDate;
import org.example.validators.ValidatorNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetLessonsByGroupValidator implements RequestValidator<GetLessonsByGroupRequest> {

    @Override
    public List<String> validate(GetLessonsByGroupRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");

        ValidatorDate.validateDate(request.getStartDate(), errors, "startDate");

        ValidatorDate.validateDate(request.getEndDate(), errors, "endDate");

        return errors;
    }
}
