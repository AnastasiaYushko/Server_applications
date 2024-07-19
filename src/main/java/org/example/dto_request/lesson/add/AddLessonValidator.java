package org.example.dto_request.lesson.add;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorDate;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class AddLessonValidator implements RequestValidator<AddLessonRequest> {

    @Override
    public List<String> validate(AddLessonRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getNumber(), errors, "number");

        ValidatorDate.validateDate(request.getDate(), errors, "date");

        ValidatorNumber.validateNumber(request.getGroupId(), errors, "groupId");

        ValidatorNumber.validateNumber(request.getTeacherId(), errors, "teacherId");

        return errors;
    }
}