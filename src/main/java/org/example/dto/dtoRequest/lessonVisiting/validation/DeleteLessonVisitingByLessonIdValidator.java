/*package org.example.dto.dtoRequest.lessonVisiting.validation;

import org.example.dto.dtoRequest.lessonVisiting.DeleteLessonVisitingByLessonIdRequest;
import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteLessonVisitingByLessonIdValidator implements RequestValidator<DeleteLessonVisitingByLessonIdRequest> {
    @Override
    public List<String> validate(DeleteLessonVisitingByLessonIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}
 */
