package org.example.dto_request.lessonVisiting.delete;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteLessonVisitingValidator implements RequestValidator<DeleteLessonVisitingRequest> {
    @Override
    public List<String> validate(DeleteLessonVisitingRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}
