package org.example.dto_request.lesson.get.byId;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetLessonByIdValidator implements RequestValidator<GetLessonByIdRequest> {
    @Override
    public List<String> validate(GetLessonByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}
