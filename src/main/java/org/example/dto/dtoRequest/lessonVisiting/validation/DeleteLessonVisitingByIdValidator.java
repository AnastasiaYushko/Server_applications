/*package org.example.dto.dtoRequest.lessonVisiting.validation;

import org.example.dto.dtoRequest.lessonVisiting.DeleteLessonVisitingByIdRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteLessonVisitingByIdValidator implements RequestValidator<DeleteLessonVisitingByIdRequest> {
    @Override
    public List<String> validate(DeleteLessonVisitingByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonVisitingId(), errors, "lessonVisitingId");
        return errors;
    }
}
 */
