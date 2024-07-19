package org.example.dto_request.lesson.delete.byId;

import org.example.validators.RequestValidator;
import org.example.validators.ValidatorNumber;

import java.util.List;

public class DeleteLessonByIdValidator implements RequestValidator<DeleteLessonByIdRequest> {

    @Override
    public List<String> validate(DeleteLessonByIdRequest request, List<String> errors) {

        ValidatorNumber.validateNumber(request.getLessonId(), errors, "lessonId");
        return errors;
    }
}
