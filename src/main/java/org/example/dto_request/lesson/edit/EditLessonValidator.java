package org.example.dto_request.lesson.edit;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorDate;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class EditLessonValidator implements RequestValidator<EditLessonRequest> {
    @Override
    public List<String> validate(EditLessonRequest request,List<String> errors) {

        ValidatorNumber.validateNumber(request.getId(),errors,"id");

        ValidatorNumber.validateNumber(request.getNumber(),errors,"number");

        ValidatorDate.validateDate(request.getDate(),errors,"date");

        ValidatorNumber.validateNumber(request.getGroupId(),errors,"groupId");

        ValidatorNumber.validateNumber(request.getTeacherId(),errors,"teacherId");

        return errors;
    }
}
