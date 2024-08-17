package org.example.dtoRequest.lessonVisiting.validation;

import org.example.dtoRequest.lessonVisiting.GetLessonVisitingByIdRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class GetLessonVisitingByIdValidator implements RequestValidator<GetLessonVisitingByIdRequest> {
    @Override
    public List<String> validate(GetLessonVisitingByIdRequest request, List<String> errors) {
        ValidatorNumber.validateNumber(request.getLessonVisitingId(), errors, "lessonVisitingId");
        return errors;
    }
}
