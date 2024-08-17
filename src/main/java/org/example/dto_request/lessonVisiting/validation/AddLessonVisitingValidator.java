package org.example.dto_request.lessonVisiting.validation;

import org.example.dto_request.lessonVisiting.AddLessonVisitingRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class AddLessonVisitingValidator implements RequestValidator<AddLessonVisitingRequest> {
    @Override
    public List<String> validate(AddLessonVisitingRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}