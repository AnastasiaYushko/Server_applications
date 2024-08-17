/*
package org.example.dto.dtoRequest.lesson.validation;

import org.example.dto.dtoRequest.lesson.GetLessonsByGroupRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorDate;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetLessonsByGroupValidator implements RequestValidator<GetLessonsByGroupRequest> {

    @Override
    public List<String> validate(GetLessonsByGroupRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");

        ValidatorDate.validateDate(request.getStartDate(), errors, "startDate");

        ValidatorDate.validateDate(request.getEndDate(), errors, "endDate");

        return errors;
    }
}
 */
