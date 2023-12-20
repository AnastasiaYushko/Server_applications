package org.example.dto_request.lessonVisiting.edit;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class EditLessonVisitingValidator implements RequestValidator<EditLessonVisitingRequest>{
    @Override
    public List<String> validate(EditLessonVisitingRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        ValidatorNumber.validateNumber(request.getLessonVisitingId(), errors, "lessonVisitingId");
        return errors;
    }
}
