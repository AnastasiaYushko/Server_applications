package org.example.dto_request.lessonVisiting.get;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetLessonVisitingValidator implements RequestValidator<GetLessonVisitingRequest> {
    @Override
    public List<String> validate(GetLessonVisitingRequest request,List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(),errors,"number");
        return errors;
    }
}
