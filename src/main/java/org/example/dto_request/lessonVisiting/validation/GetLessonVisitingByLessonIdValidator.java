package org.example.dto_request.lessonVisiting.validation;

import org.example.dto_request.lessonVisiting.GetLessonVisitingByLessonIdRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetLessonVisitingByLessonIdValidator implements RequestValidator<GetLessonVisitingByLessonIdRequest> {
    @Override
    public List<String> validate(GetLessonVisitingByLessonIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}