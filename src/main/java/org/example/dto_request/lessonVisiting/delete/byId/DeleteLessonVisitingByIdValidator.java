package org.example.dto_request.lessonVisiting.delete.byId;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteLessonVisitingByIdValidator implements RequestValidator<DeleteLessonVisitingByIdRequest> {
    @Override
    public List<String> validate(DeleteLessonVisitingByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonVisitingId(), errors, "lessonVisitingId");
        return errors;
    }
}
